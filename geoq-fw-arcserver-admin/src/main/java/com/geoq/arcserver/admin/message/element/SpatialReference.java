package com.geoq.arcserver.admin.message.element;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpatialReference {

    private int wkid;
    private int latestWkid;
    private String wkt;

}
