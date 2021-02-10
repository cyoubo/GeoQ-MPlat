package com.geoq.arcgisservice.harvest.config;

import com.geoq.arcserver.admin.message.componenet.MessageArbiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceHelperConfig {

    @Bean
    public MessageArbiter baseMessageArbiter(){return new MessageArbiter();}
}
