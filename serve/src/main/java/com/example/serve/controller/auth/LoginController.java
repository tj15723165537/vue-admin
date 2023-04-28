package com.example.serve.controller.auth;

import com.example.serve.dto.auth.LoginDTO;
import com.example.serve.service.auth.LoginService;
import com.example.serve.utils.Response;
import com.example.serve.vo.system.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(tags = "登录")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataTypeClass = String.class)
    })
    public Response<UserVO> login(@RequestBody LoginDTO dto){
        Map<String,Object> data = loginService.login(dto);
        return Response.ok(data);
    }
}
