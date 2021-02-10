package com.geoq.arcserver.admin.message.element;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TileInfo {
   private int rows;
   private int cols;
   private int dpi;
   private String format;
   private int compressionQuality;
   private Point origin;
   private SpatialReference spatialReference;
   private Lod[] lods;
}
