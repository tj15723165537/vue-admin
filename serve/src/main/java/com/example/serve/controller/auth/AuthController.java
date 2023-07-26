package com.example.serve.controller.auth;

import com.example.serve.dto.auth.LoginDTO;
import com.example.serve.dto.auth.ResetPasswordDTO;
import com.example.serve.service.auth.AuthService;
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
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Response<LoginVO> login(@Validated @RequestBody LoginDTO dto) {
        LoginVO data = authService.login(dto);
        return Response.ok(data);
    }

    @GetMapping("/auth")
    @ApiOperation("已有菜单权限列表")
    public Response<MenuVO[]> getAuthList(@RequestHeader("Authorization") String jwtToken) {
        Long currentUserId = JwtUtil.getUserId(jwtToken);
        List<MenuVO> authList = authService.getAuthList(currentUserId);
        return Response.ok(authList);
    }

    @PostMapping("/resetPassword")
    @ApiOperation("修改密码")
    public Response resetPassword(@RequestBody @Validated ResetPasswordDTO dto, @RequestHeader("Authorization") String jwtToken) {
        Long currentUserId = JwtUtil.getUserId(jwtToken);
        authService.resetPassword(dto, currentUserId);
        return Response.ok();
    }
}
