package com.example.serve.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.example.serve.convert.system.RoleConvert;
import com.example.serve.dto.system.role.RoleAssignDTO;
import com.example.serve.dto.system.role.RoleCreateDTO;
import com.example.serve.dto.system.role.RolePageParamsDTO;
import com.example.serve.dto.system.role.RoleUpdateDTO;
import com.example.serve.entity.system.Role;
import com.example.serve.service.system.RoleService;
import com.example.serve.utils.PageList;
import com.example.serve.utils.Response;
import com.example.serve.vo.system.RoleMenuListVO;
import com.example.serve.vo.system.RoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "角色管理")
@RequestMapping(value = "/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @Resource
    private RoleConvert roleConvert;

    @GetMapping("/list")
    @ApiOperation("获取角色列表")
    public Response<PageList<RoleVO>> list(RolePageParamsDTO dto) {
        IPage<Role> list = roleService.getList(dto);
        List<RoleVO> roleVOS = roleConvert.entityList2VoList(list.getRecords());
        return Response.ok(roleVOS, list.getTotal());
    }

    @GetMapping("/allList")
    @ApiOperation("获取所有角色")
    public Response<List<RoleVO>> list() {
        List<RoleVO> list = roleService.getAllList();
        return Response.ok(list);
    }

    @PostMapping("/add")
    @ApiOperation("新建角色")
    public Response add(@RequestBody RoleCreateDTO dto) {
        roleService.add(dto);
        return Response.ok();
    }

    /**
     * 删除角色
     */
    @GetMapping("/delete/{id}")
    @ApiOperation("删除角色")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Long.class)
    public Response delete(@PathVariable Long id) {
        roleService.delete(id);
        return Response.ok();
    }

    /**
     * 获取角色详情
     */
    @GetMapping("/detail/{id}")
    @ApiOperation("获取角色详情")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Long.class)
    public Response<RoleVO> detail(@PathVariable Long id) {
        RoleVO roleVO = roleService.getDetail(id);
        return Response.ok(roleVO);
    }

    /**
     * 修改角色
     */
    @PostMapping("/update")
    @ApiOperation("修改角色")
    public Response update(@Validated @RequestBody RoleUpdateDTO dto) {
        roleService.update(dto);
        return Response.ok();
    }

    /**
     * 修改角色权限
     */
    @PostMapping("/assign")
    @ApiOperation("更改角色权限")
    public Response assign(@Validated @RequestBody RoleAssignDTO dto) {
        roleService.assign(dto);
        return Response.ok();
    }

    /**
     * 获取角色权限列表
     */
    @GetMapping("/roleMenuList/{id}")
    @ApiOperation("获取角色权限列表")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataTypeClass = Long.class)
    public Response<RoleMenuListVO> getRoleMenuList(@PathVariable Long id) {
        RoleMenuListVO roleMenuList = roleService.getRoleMenuList(id);
        return Response.ok(roleMenuList);
    }
}
