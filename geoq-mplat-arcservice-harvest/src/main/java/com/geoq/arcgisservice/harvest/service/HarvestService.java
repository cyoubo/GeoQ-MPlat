package com.geoq.arcgisservice.harvest.service;

public interface HarvestService {

    String harvest_service_info(String serviceUrl);

    String harvest_service_state(String serviceUrl);
}
