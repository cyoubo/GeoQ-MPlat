package com.geoq.arcserver.admin.message;

import com.geoq.arcserver.admin.message.element.DocumentInfo;
import com.geoq.arcserver.admin.message.element.Extent;
import com.geoq.arcserver.admin.message.element.Layer;
import com.geoq.arcserver.admin.message.element.SpatialReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FeatureServiceMessage extends BaseMessage{
    private double currentVersion;
    private String serviceDescription;
    private boolean hasVersionedData;
    private boolean hasArchivedData;
    private boolean supportsDisconnectedEditing;
    private boolean supportsQueryDataElements;
    private boolean supportsRelationshipsResource;
    private boolean syncEnabled;
    private String supportedQueryFormats;
    private int maxRecordCount;
    private int maxRecordCountFactor;
    private String capabilities;
    private String description;
    private String copyrightText;
    private SpatialReference spatialReference;
    private Extent initialExtent;
    private Extent fullExtent;
    private boolean allowGeometryUpdates;
    private boolean allowTrueCurvesUpdates;
    private boolean onlyAllowTrueCurveUpdatesByTrueCurveClients;
    private boolean supportsApplyEditsWithGlobalIds;
    private boolean supportsTrueCurve;
    private String units;
    private DocumentInfo documentInfo;
    private boolean supportsQueryDomains;
    private List<Layer> layers;
    private List<String> tables;
    private List<String> relationships;
    private boolean enableZDefaults;
    private boolean allowUpdateWithoutMValues;
}
