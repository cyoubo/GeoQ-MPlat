package com.geoq.assettype.admin.controller;

import cn.hutool.core.lang.UUID;
import com.geoq.assettype.admin.pojo.AssetTypePojo;
import com.geoq.assettype.admin.service.AdminService;
import com.geoq.common.entry.CommonResult;
import com.geoq.common.entry.CommonUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class AdminController {

    @Resource
    private AdminService service;

    @GetMapping(value = "/all_record")
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

    @PostMapping("/asset_type")
    public CommonResult create_asset_type(AssetTypePojo pojo)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.create_asset_type(pojo));
        return result;
    }

    @PutMapping("/asset_type")
    public CommonResult update_asset_type(AssetTypePojo pojo)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.update_asset_type(pojo));
        return result;
    }

    @GetMapping("/asset_type")
    public CommonResult select_by_uuid(String uuid)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.select_by_uuid(uuid));
        }
        catch (Exception ex)
        {
            log.error("all_record",ex);
            result.error(CommonUtils.ResponseTag_Error,ex.getLocalizedMessage());
        }
        return result;
    }

    @DeleteMapping("/asset_type")
    public CommonResult delete_by_uuid(String uuid)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.delete_by_uuid(uuid));
        return result;
    }

    @GetMapping("/asset_type_code")
    public CommonResult generate_asset_type_code(String uuid)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.generate_asset_type_code(uuid));
        }
        catch (Exception ex)
        {
            log.error("all_record",ex);
            result.error(CommonUtils.ResponseTag_Error,ex.getLocalizedMessage());
        }
        return result;
    }
}
