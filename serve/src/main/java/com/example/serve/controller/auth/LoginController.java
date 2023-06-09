package com.example.serve.controller.auth;

import com.example.serve.dto.auth.LoginDTO;
import com.example.serve.service.auth.LoginService;
import com.example.serve.utils.JwtUtil;
import com.example.serve.utils.Response;
import com.example.serve.vo.auth.LoginVO;
import com.example.serve.vo.system.MenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "登录")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Response<LoginVO> login(@Validated @RequestBody LoginDTO dto){
        LoginVO data = loginService.login(dto);
        return Response.ok(data);
    }

    @GetMapping("/auth")
    @ApiOperation("已有菜单权限列表")
    public Response<MenuVO[]> getAuthList(@RequestHeader("Authorization") String jwtToken){
        Long currentUserId = JwtUtil.getUserId(jwtToken);
        List<MenuVO> authList = loginService.getAuthList(currentUserId);
        return Response.ok(authList);
    }
}
