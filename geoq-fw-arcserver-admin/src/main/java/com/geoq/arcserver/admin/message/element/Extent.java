package com.geoq.arcserver.admin.message.element;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Extent {
    private double xmin;
    private double ymin;
    private double xmax;
    private double ymax;
    private SpatialReference spatialReference;
}
