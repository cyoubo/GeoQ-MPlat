package com.geoq.userrole.controller;


import com.geoq.common.entry.CommonResult;
import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.pojo.RolePojo;
import com.geoq.userrole.service.RoleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class RoleController {

    @Resource
    private RoleService service;

    @GetMapping("/role/all_record")
    @ApiOperation(value = "返回所有的用户信息", notes = "notes" , httpMethod = "GET")
    public CommonResult all_record(@RequestParam(name = "token")String token)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.all_record(token));
        }
        catch (Exception ex)
        {
            log.error("all_record",ex);
            result.error(CommonUtils.ResponseTag_Error,ex.getLocalizedMessage());
        }
        return result;
    }

    @GetMapping("/role/part_record")
    @ApiOperation(value = "分页返回用户信息", notes = "分页返回用户信息" , httpMethod = "GET")
    public CommonResult part_record(@RequestParam(name = "token")String token, @RequestParam(name = "start")int start,
                                    @RequestParam(name="size")int size)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.part_record(token,start,size));
        }
        catch (Exception ex)
        {
            log.error("part_record",ex);
            result.error(CommonUtils.ResponseTag_Error,ex.getLocalizedMessage());
        }
        return result;
    }

    @GetMapping("/role")
    public CommonResult select_by_uuid(@RequestParam(name = "uuid") String uuid)
    {
        CommonResult result = new CommonResult();
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

    @PostMapping("/role")
    public CommonResult create_role(@RequestBody RolePojo pojo)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.create_role(pojo));

        return result;
    }

    @PutMapping("/role")
    public CommonResult update_role(@RequestBody RolePojo pojo)
    {
       CommonResult result = new CommonResult<>();
       result.ok_str(service.update_role(pojo));
       return result;
    }

    @DeleteMapping("/role")
    public CommonResult delete_role(@RequestBody String uuid)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.delete_role(uuid));
        return result;
    }

}
