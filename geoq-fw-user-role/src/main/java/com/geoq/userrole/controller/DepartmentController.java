package com.geoq.userrole.controller;

import com.geoq.common.entry.CommonResult;
import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.pojo.DepartmentPojo;
import com.geoq.userrole.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class DepartmentController {

    @Resource
    private DepartmentService service;

    @GetMapping("/department/all_record")
    @ApiOperation(value = "返回所有的用户信息", notes = "notes" , httpMethod = "GET")
    public CommonResult all_record()
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.all_record());
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage(), ex);
            result.error(ex.getMessage(),null);
        }
        return result;
    }

    @GetMapping("/department/part_record")
    @ApiOperation(value = "分页返回用户信息", notes = "分页返回用户信息" , httpMethod = "GET")
    public CommonResult part_record(@RequestParam(name = "start")int start, @RequestParam(name="size")int size)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.part_record(start,size));
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage(), ex);
            result.error(ex.getMessage(),null);
        }
        return result;
    }

    @GetMapping("/department")
    public CommonResult select_by_uuid(@RequestParam(name = "uuid") String uuid)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.select_by_uuid(uuid));
        }
        catch (Exception ex)
        {
            log.error("select_by_uuid", ex);
            result.ok_str(CommonUtils.errorMsgTemplate(ex.getLocalizedMessage()));
        }
        return result;
    }

    @PostMapping("/department")
    public CommonResult create_department(@RequestBody DepartmentPojo pojo)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.create_department(pojo));
        return result;
    }

    @PutMapping("/department")
    public CommonResult update_department(@RequestBody DepartmentPojo pojo)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.update_department(pojo));
        return result;
    }

    @DeleteMapping("/department")
    public CommonResult delete_department(@RequestBody String uuid)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.delete_department(uuid));
        return result;
    }

}
