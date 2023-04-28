package com.example.serve.controller.system;


import com.example.serve.service.system.MenuService;
import com.example.serve.utils.Response;
import com.example.serve.vo.system.MenuVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "菜单管理")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    @ApiModelProperty("获取菜单列表")
    public Response<MenuVO> getList(){
        List<MenuVO> list = menuService.getList();
        return Response.ok(list);
    }

}
