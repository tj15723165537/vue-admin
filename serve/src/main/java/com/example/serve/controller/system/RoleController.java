package com.example.serve.controller.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.serve.convert.system.RoleConvert;
import com.example.serve.dto.system.role.RoleCreateDTO;
import com.example.serve.dto.system.role.RolePageParamsDTO;
import com.example.serve.entity.system.Role;
import com.example.serve.service.system.RoleService;
import com.example.serve.utils.PageList;
import com.example.serve.utils.Response;
import com.example.serve.vo.system.RoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
        return  Response.ok(roleVOS,list.getTotal());
    }

    @PostMapping("/add")
    @ApiOperation("新建角色")
    public Response add(@RequestBody RoleCreateDTO dto) {
        roleService.add(dto);
        return Response.ok();
    }

}
