package com.geoq.arcserver.admin.message;

import com.geoq.arcserver.admin.message.element.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapServiceMessage extends BaseMessage {
   private double currentVersion;
   private String serviceDescription;
   private String mapName;
   private String description;
   private String copyrightText;
   private boolean supportsDynamicLayers;
   private Layer[] layers;
   private SpatialReference spatialReference;
   private boolean singleFusedMapCache;
   private TileInfo tileInfo;
   private Extent initialExtent;
   private Extent fullExtent;
   private double minScale;
   private double maxScale;
   private String units;
   private String supportedImageFormatTypes;
   private DocumentInfo documentInfo;
   private String capabilities;
   private String supportedQueryFormats;
   private boolean exportTilesAllowed;
   private boolean supportsDatumTransformation;
   private int maxRecordCount;
   private int maxImageHeight;
   private int maxImageWidth;
   private String supportedExtensions;
}
