package com.example.serve.controller.system;


import com.example.serve.dto.system.MenuDTO;
import com.example.serve.service.system.MenuService;
import com.example.serve.utils.Response;
import com.example.serve.vo.system.MenuVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "菜单管理")
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    @ApiOperation("获取菜单列表")
    public Response<MenuVO[]> getList(){
        List<MenuVO> list = menuService.getList();
        return Response.ok(list);
    }

    @PostMapping("/add")
    @ApiOperation("新增菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "path", value = "菜单路径", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "name", value = "路由名称", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "redirect", value = "重定向路径", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "title", value = "菜单标题", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "icon", value = "菜单图标", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "pid", value = "父级菜单", required = true, dataTypeClass = Long.class)
    })
    public Response add(@RequestBody @Validated MenuDTO menuDTO){
        menuService.add(menuDTO);
        return Response.ok();
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("获取菜单列表")
    public Response delete(@PathVariable Long id){
        menuService.delete(id);
        return Response.ok();
    }

}
