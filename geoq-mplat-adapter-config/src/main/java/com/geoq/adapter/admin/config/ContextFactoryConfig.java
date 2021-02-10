package com.geoq.adapter.admin.config;

import com.geoq.mplat.component.dataadapter.AdapterContextFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextFactoryConfig {

    @Bean
    public AdapterContextFactory adapterContextFactory()
    {
        return new AdapterContextFactory();
    }
}
