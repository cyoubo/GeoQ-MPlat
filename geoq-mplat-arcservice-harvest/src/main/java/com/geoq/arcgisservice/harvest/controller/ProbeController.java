package com.geoq.arcgisservice.harvest.controller;

import com.geoq.arcgisservice.harvest.pojo.ServiceRecord;
import com.geoq.arcgisservice.harvest.service.ProbeService;
import com.geoq.common.entry.CommonResult;
import com.geoq.common.entry.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class ProbeController {

    @Resource
    private ProbeService service;

    @GetMapping("/probe")
    public CommonResult probeService(@RequestParam(name = "host") String host)
    {
        CommonResult<List<ServiceRecord>> result = new CommonResult<>();
        try
        {
            result.ok(CommonUtils.ResponseTag_Success, service.probeService(host));
        }
        catch (Exception ex)
        {
            log.error("probeService",ex);
            result.error(CommonUtils.errorMsgTemplate(ex.getLocalizedMessage()),null);
        }
        return result;
    }
}
