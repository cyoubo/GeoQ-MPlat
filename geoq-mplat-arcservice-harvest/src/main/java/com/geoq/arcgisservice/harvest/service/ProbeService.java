package com.geoq.arcgisservice.harvest.service;

import com.geoq.arcgisservice.harvest.pojo.ServiceRecord;

import java.util.List;

public interface ProbeService {

    List<ServiceRecord> probeService(String host);
}
