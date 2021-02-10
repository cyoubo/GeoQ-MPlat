package com.geoq.userrole.controller;


import com.geoq.common.entry.CommonResult;
import com.geoq.common.entry.CommonUtils;
import com.geoq.userrole.component.CommonEnum;
import com.geoq.userrole.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@Api(tags = {"通用业务逻辑操作"})
public class AdminController {
    @Resource
    private AdminService service;

    @PostMapping(value = "/admin/login")
    @ApiOperation(value = "用户登录", notes = "通过用户名和密码获取登录详情信息", consumes = "json")
    CommonResult<Object> login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        CommonResult<Object> result = new CommonResult<>();
        try {
            Map<String,Object> temp = new HashMap<>();
            if (service.login(name, password,temp))
                result.ok(CommonUtils.ResponseTag_Success,temp);
            else
                result.error(CommonUtils.ResponseTag_Fail, temp.get(CommonEnum.MapKey_Reason.name()));
        } catch (Exception ex) {
            log.error("login", ex);
            result.error(CommonUtils.ResponseTag_Error, ex.getLocalizedMessage());
        }
        return result;
    }


    @GetMapping("/admin/role_right_code")
    @ApiOperation(value = "权限查询", notes = "查询指定角色uuid所有配赋的权限", consumes = "json")
    public CommonResult<Map<String,Object>> query_role_right_code(@RequestParam(value = "uuid") String uuid)
    {
        CommonResult<Map<String,Object>> result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.query_role_right_code(uuid));
        }
        catch (Exception ex)
        {
            log.error("query_role_right_code", ex);
            result.error(CommonUtils.ResponseTag_Error, null);
        }
        return result;
    }
}
