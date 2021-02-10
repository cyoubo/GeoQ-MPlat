package com.geoq.arcgisservice.harvest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRecord {
    private String fold;
    private String name;
    private String type;
}
