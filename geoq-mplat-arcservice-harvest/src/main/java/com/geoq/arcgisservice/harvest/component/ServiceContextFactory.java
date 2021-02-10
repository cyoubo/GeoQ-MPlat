package com.geoq.arcgisservice.harvest.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;



@Component
@Slf4j
public class ServiceContextFactory {

    public AbstractServiceContext create(String messageClassName)
    {
        switch (messageClassName)
        {
            case "MapServiceMessage" : return new MapServiceContext();
            case "FeatureServiceMessage" :return new FeatureServiceContext();
            case "GPServiceMessage" :return new GPServiceContext();
            case "GeometryServiceMessage" : return new GeometryContext();
            default: return null;
        }
    }

}


