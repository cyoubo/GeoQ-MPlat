package com.geoq.arcgisservice.harvest.controller;

import com.geoq.arcgisservice.harvest.service.HarvestService;
import com.geoq.common.entry.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HarvestController {

    @Resource
    private HarvestService service;

    @PostMapping("/arcservice/service_info")
    public CommonResult harvest_service_info(@RequestParam(name = "service_url")String serviceUrl)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok_str(service.harvest_service_info(serviceUrl));
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage(), ex);
            result.error(ex.getCause().getMessage(),null);
        }
        return result;
    }

    @PostMapping("/arcservice/service_state")
    public CommonResult harvest_service_state(@RequestParam(name = "service_url")String serviceUrl)
    {
        CommonResult result = new CommonResult<>();
        try
        {
            result.ok_str(service.harvest_service_state(serviceUrl));
        }
        catch (Exception ex)
        {
            log.error(ex.getMessage(), ex);
            result.error(ex.getMessage(),null);
        }
        return result;
    }
}
