package com.geoq.arcgisservice.harvest.serviceImp;

import cn.hutool.json.JSONUtil;
import com.geoq.arcgisservice.harvest.component.AbstractServiceContext;
import com.geoq.arcgisservice.harvest.component.ServiceContextFactory;
import com.geoq.arcserver.admin.message.BaseMessage;
import com.geoq.arcserver.admin.message.componenet.MessageFactory;
import com.geoq.arcserver.admin.message.componenet.MessageArbiter;
import com.geoq.arcgisservice.harvest.service.HarvestService;
import com.geoq.common.entry.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Slf4j
public class HarvestServiceImp implements HarvestService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private MessageArbiter arbiter;

    @Resource
    private ServiceContextFactory factory;

    @Override
    public String harvest_service_info(String serviceUrl) {
        String result = "";
        try
        {
            //利用工厂生成指定的消息实体，方便解析
            BaseMessage type = MessageFactory.create(serviceUrl.substring(serviceUrl.lastIndexOf("/") + 1));
            String temp  = restTemplate.getForObject(serviceUrl + "?f=json", String.class);
            BaseMessage msg = JSONUtil.toBean(JSONUtil.parseObj(temp), type.getClass());
            //判别器判断是否正确
            if(arbiter.arbitrateState(msg.getError())== MessageArbiter.BaseMessageState.success)
            {
                //按照具体类型机型收割
                AbstractServiceContext context = factory.create(type.getClass().getSimpleName());
                if(context != null)
                    result = context.extract(msg).toJson();
            }
            else
                result = CommonUtils.failMsgTemplate("service stop");
        }
        catch (Exception ex)
        {
            log.error("harvest_service_info",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return CommonUtils.successMsgTemplate(result);
    }

    @Override
    public String harvest_service_state(String serviceUrl) {

        String result = "";
        try
        {
            String tempStr  = restTemplate.getForObject(serviceUrl+"?f=json", String.class);
            BaseMessage baseMessage = JSONUtil.toBean(JSONUtil.parseObj(tempStr), BaseMessage.class);
            result = CommonUtils.successMsgTemplate(arbiter.arbitrateState(baseMessage.getError()).name());
        }
        catch (Exception ex)
        {
            log.error("harvest_service_state",ex);
            result = CommonUtils.errorMsgTemplate(ex.getLocalizedMessage());
        }
        return result;
    }
}
