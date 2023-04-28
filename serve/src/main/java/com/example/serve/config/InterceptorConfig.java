package com.example.serve.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.serve.entity.system.User;
import com.example.serve.exception.BusinessException;
import com.example.serve.service.system.UserService;
import com.example.serve.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将我们上步定义的实现了HandlerInterceptor接口的拦截器实例authenticationInterceptor添加InterceptorRegistration中，并设置过滤规则，所有请求都要经过authenticationInterceptor拦截。
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }

    class AuthenticationInterceptor implements HandlerInterceptor {

        @Autowired
        UserService userService;


        @Override
        public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
            String url = httpServletRequest.getRequestURI();
            String[] whiteList = {"/login"};
            for (String s : whiteList) {
                if (url.contains(s)) {
                    return true;
                }
            }
            // 从 http 请求头中取出 token
            String token = httpServletRequest.getHeader("authorization");
            // 如果不是映射到方法直接通过
            if (!(object instanceof HandlerMethod)) {
                return true;
            }
            HandlerMethod handlerMethod = (HandlerMethod) object;
            Method method = handlerMethod.getMethod();
            // 执行认证
            if (token == null) {
                throw new BusinessException("无token，请重新登录");
            }
            // 获取 token 中的 user id
            String userId;
            try {
                userId = JWT.decode(token).getClaim("userId").asString();
            } catch (JWTDecodeException j) {
                throw new BusinessException("401");
            }
            User user = userService.getById(userId);
            if (user == null) {
                throw new BusinessException("用户不存在，请重新登录");
            }

            // 验证 token
            try {
                if (!JwtUtil.verity(token, user.getPassword())) {
                    throw new BusinessException("无效的令牌");
                }
            } catch (JWTVerificationException e) {
                throw new BusinessException("401");
            }
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        }
    }
}



