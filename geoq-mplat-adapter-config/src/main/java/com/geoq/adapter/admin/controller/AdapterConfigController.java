package com.geoq.adapter.admin.controller;

import com.geoq.adapter.admin.service.AdapterConfigService;
import com.geoq.common.entry.CommonResult;
import com.geoq.common.entry.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@Api(tags = {"适配器统一管理接口"})
public class AdapterConfigController {

    @Resource
    private AdapterConfigService service;

    @GetMapping("/adapter_config/all_record")
    @ApiOperation(value = "返回所有的用户信息",
            notes = "返回所有的用户信息," ,
            httpMethod = "GET")
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

    @GetMapping("/adapter_config/part_record")
    public CommonResult part_record(@RequestParam(name = "start")int start, @RequestParam(name="size")int size)
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
    
    @GetMapping("/adapter_config")
    public CommonResult select_by_uuid(@RequestParam(name = "uuid")String uuid)
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

    @PostMapping("/adapter_config")
    public CommonResult create_adapter_config(@RequestParam(name = "type")String type,
                                              @RequestParam(name = "name")String name,
                                              @RequestParam(name = "description", required = false)String description,
                                              @RequestParam(name = "objstr") String objstr)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.create_adapter_config(type,name,description,objstr));
        return result;
    }

    @PutMapping("/adapter_config")
    public CommonResult update_adapter_config(@RequestParam(name = "uuid")String uuid,
                                              @RequestParam(name = "type")String type,
                                              @RequestParam(name = "name")String name,
                                              @RequestParam(name = "description", required = false)String description,
                                              @RequestParam(name = "objstr") String objstr)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.update_adapter_config(uuid,type,name,description,objstr));
        return result;
    }

    @DeleteMapping("/adapter_config")
    public CommonResult delete_adapter_config(@RequestParam(name = "uuids")String[] uuids)
    {
        CommonResult result = new CommonResult<>();
        result.ok("success", service.delete_adapter_config(uuids));
        return result;
    }

}
