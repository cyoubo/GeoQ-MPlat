package com.geoq.userrole.controller;


import com.geoq.common.entry.CommonResult;
import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.pojo.RoleRightPojo;
import com.geoq.userrole.service.RoleRightService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class RoleRightController {

    @Resource
    private RoleRightService service;

    @GetMapping("/role_right/all_record")
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
           log.error("all_record",ex);
           result.error(CommonUtils.ResponseTag_Error,ex.getLocalizedMessage());
       }
       return result;
    }

    @GetMapping("/role_right/part_record")
    @ApiOperation(value = "分页返回用户信息", notes = "分页返回用户信息" , httpMethod = "GET")
    public CommonResult part_record( @RequestParam(name = "start")int start,
                                    @RequestParam(name="size")int size)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.part_record(start,size));
        }
        catch (Exception ex)
        {
            log.error("part_record",ex);
            result.error(CommonUtils.ResponseTag_Error,ex.getLocalizedMessage());
        }
        return result;
    }

    @GetMapping("/role_right")
    public CommonResult select_by_uuid(@RequestParam(name = "uuid") String uuid)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.select_by_uuid(uuid));
        }
        catch (Exception ex)
        {
            log.error("select_by_uuid",ex);
            result.error(CommonUtils.ResponseTag_Error,ex.getLocalizedMessage());
        }
        return result;
    }

    @PostMapping("/role_right")
    public CommonResult create_role_right(@RequestBody RoleRightPojo pojo)
    {
        CommonResult result = new CommonResult();
        result.ok_str(service.create_role_right(pojo));
        return result;
    }

    @PutMapping("/role_right")
    public CommonResult update_role_right(@RequestBody RoleRightPojo pojo)
    {
        CommonResult result = new CommonResult();
        result.ok_str(service.update_role_right(pojo));
        return result;
    }

    @DeleteMapping("/role_right")
    public CommonResult delete_role_right(@RequestBody String uuid)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.delete_role_right(uuid));
        return result;
    }
}
