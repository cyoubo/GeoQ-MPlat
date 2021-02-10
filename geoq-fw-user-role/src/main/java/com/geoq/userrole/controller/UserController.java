package com.geoq.userrole.controller;

import com.geoq.common.entry.CommonResult;
import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.pojo.UserPojo;
import com.geoq.userrole.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = {"用户管理操作接口"})
@Slf4j
public class UserController {

    @Resource
    private UserService service;


    @GetMapping("/user/all_record")
    @ApiOperation(value = "返回所有的用户信息",
            notes = "返回所有的用户信息," ,
            httpMethod = "GET")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "token", value = "当token为后台指定值时，返回含密码的信息，否则密码被替代", required = false)
    )
    public CommonResult all_record(@RequestParam(name = "token", required = false)String token)
    {
        CommonResult result = new CommonResult();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.all_record(token));
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage(), ex);
            result.error(ex.getMessage(),null);
        }
        return result;
    }

    @GetMapping("/user/part_record")
    @ApiOperation(value = "分页返回用户信息",
            notes = "分页返回用户信息,当token为后台指定值时，返回含密码的信息，否则密码被替代" ,
            httpMethod = "GET")
    public CommonResult part_record(@RequestParam(name = "token", required = false)String token,
                                    @RequestParam(name = "start")int start,
                                    @RequestParam(name="size")int size)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.part_record(token, start,size));
        }
        catch (Exception ex)
        {
           log.error("",ex);
           result.error(CommonUtils.ResponseTag_Error,ex.getLocalizedMessage());
        }
        return result;
    }

    @GetMapping("/user")
    @ApiOperation(value = "查询指定编号的用户信息", notes = "查询指定编号的用户信息" , httpMethod = "GET")
    public CommonResult select_by_uuid(@RequestParam(name = "uuid") String uuid)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success,service.select_by_uuid(uuid));
        }
        catch (Exception ex)
        {
            log.error("select_by_uuid",ex);
            result.error(CommonUtils.ResponseTag_Error,ex.getLocalizedMessage());
        }
        return result;
    }

    @PostMapping("/user")
    @ApiOperation(value = "创建用户记录", notes = "创建用户记录")
    public CommonResult create_user(@RequestBody UserPojo pojo)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.create_user(pojo));
        return result;
    }

    @PutMapping("/user")
    @ApiOperation(value = "修改用户记录", notes = "修改用户记录")
    public CommonResult update_user(@RequestBody UserPojo pojo)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.update_user(pojo));
        return result;
    }

    @DeleteMapping("/user")
    @ApiOperation(value = "删除用户记录", notes = "删除用户记录")
    public CommonResult delete_user(@RequestBody String[] uuids)
    {
        CommonResult result = new CommonResult<>();
        result.ok_str(service.delete_user(uuids));
        return result;
    }


}
