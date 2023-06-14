package com.example.serve.controller.system.employee;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.serve.convert.employee.EmployeeConvert;
import com.example.serve.dto.employee.EmployeeDTO;
import com.example.serve.dto.employee.EmployeePageParamsDTO;
import com.example.serve.entity.employee.Employee;
import com.example.serve.service.employee.EmployeeService;
import com.example.serve.utils.PageList;
import com.example.serve.utils.Response;
import com.example.serve.vo.employee.EmployeeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "员工管理")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeConvert employeeConvert;

    @ApiOperation(value = "员工列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "page", required = true, dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "size", value = "size", required = true, dataTypeClass = Integer.class),
            @ApiImplicitParam(name = "name", value = "员工姓名", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = "phone", value = "电话", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = "address", value = "地址", required = false, dataTypeClass = String.class)
    })
    @GetMapping("/list")
    public Response<PageList<EmployeeVO>> list(EmployeePageParamsDTO filter) {
        IPage<Employee> ipage = employeeService.getList(filter);
        List<EmployeeVO> employeeVOList = employeeConvert.entitylist2Volist(ipage.getRecords());
        return Response.ok(employeeVOList, ipage.getTotal());
    }

    @ApiOperation(value = "添加员工")
    @PostMapping("/add")
    public Response add(@RequestBody @Validated EmployeeDTO dto) {
        boolean result = employeeService.add(dto);
        return Response.ok();
    }

    @ApiOperation(value = "删除员工")
    @ApiImplicitParam(name = "id", value = "员工id", required = true, dataTypeClass = Long.class)
    @GetMapping("/delete/{id}")
    public Response remove(@PathVariable Long id) {
        boolean result = employeeService.remove(id);
        return Response.ok();
    }

    @ApiOperation(value = "根据id查询员工")
    @ApiImplicitParam(name = "id", value = "员工id", required = true, dataTypeClass = Long.class)
    @GetMapping("/getEmployeeById/{id}")
    public Response<EmployeeVO> getById(@PathVariable Long id) {
        EmployeeVO employeeVO = employeeService.getById(id);
        return Response.ok(employeeVO);
    }

    @ApiOperation(value = "修改员工")
    @PostMapping("/update")
    public Response update(@RequestBody @Validated EmployeeDTO dto) {
        Boolean result = employeeService.update(dto);
        return Response.ok();
    }
}
