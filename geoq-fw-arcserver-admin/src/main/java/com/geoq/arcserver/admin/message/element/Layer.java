package com.geoq.arcserver.admin.message.element;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Layer {
    private int id;
    private String name;
    private int parentLayerId;
    private boolean defaultVisibility;
    private int minScale;
    private int maxScale;
}
