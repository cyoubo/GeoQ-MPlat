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

    @Override
    public String toString() {
        return "spatialReferenceElement{" +
                "wkid=" + wkid +
                ", latestWkid=" + latestWkid +
                '}';
    }
}
