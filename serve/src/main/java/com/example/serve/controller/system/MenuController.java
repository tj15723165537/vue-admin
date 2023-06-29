package com.example.serve.controller.system;


import com.example.serve.dto.system.menu.MenuCreateDTO;
import com.example.serve.dto.system.menu.MenuUpdateDTO;
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
    @ApiOperation("菜单列表")
    public Response<MenuVO[]> getList(){
        List<MenuVO> list = menuService.getList();
        return Response.ok(list);
    }

    @PostMapping("/add")
    @ApiOperation("新增菜单")
    public Response add(@RequestBody @Validated MenuCreateDTO menuDTO){
        menuService.add(menuDTO);
        return Response.ok();
    }

    @GetMapping("/delete/{id}")
    @ApiOperation("删除菜单")
    public Response delete(@PathVariable Long id){
        menuService.delete(id);
        return Response.ok();
    }

    @PostMapping("/update")
    @ApiOperation("编辑菜单")
    public Response update(@RequestBody @Validated MenuUpdateDTO menuDTO){
        menuService.update(menuDTO);
        return Response.ok();
    }

    @GetMapping("/detail/{id}")
    @ApiOperation("菜单详情")
    public Response<MenuVO> detail(@PathVariable Long id){
        MenuVO menuVO = menuService.getDetail(id);
        return Response.ok(menuVO);
    }

}
