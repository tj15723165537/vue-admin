package com.example.serve.controller.system;

import com.example.serve.dto.system.user.UserCreateDTO;
import com.example.serve.dto.system.user.UserPageParamsDTO;
import com.example.serve.dto.system.user.UserUpdateDTO;
import com.example.serve.service.system.UserService;
import com.example.serve.utils.PageList;
import com.example.serve.utils.Response;
import com.example.serve.vo.system.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ApiOperation(value = "用户列表")
    public Response<PageList<UserVO>> list(UserPageParamsDTO dto){
        PageList<UserVO> pageList = userService.getPage(dto);
        return Response.ok(pageList);
    }

    @PostMapping("/add")
    @ApiOperation("添加用户")
    public Response add(@Validated @RequestBody UserCreateDTO dto){
        userService.add(dto);
        return Response.okMsg("添加成功");
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("用户详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Long.class)
    public Response<UserVO> getDetail (@PathVariable Long id){
        UserVO userVO = userService.getById(id);
        return Response.ok(userVO);
    }

    @PostMapping("/update")
    @ApiOperation("编辑用户")
    public Response update(@Validated @RequestBody UserUpdateDTO dto){
        userService.update(dto);
        return Response.okMsg("修改成功");
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Long.class)
    public Response delete(@PathVariable Long id){
        userService.delete(id);
        return Response.okMsg("删除成功");
    }

    @GetMapping("/updateStatus/{id}")
    @ApiOperation("禁用启用用户")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Long.class)
    public Response updateStatus(@PathVariable Long id){
        userService.updateStatus(id);
        return Response.okMsg("修改成功");
    }
}
