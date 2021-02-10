package com.geoq.adapter.admin.pojo;

public class AdapterPojo {
    private String uuid;

    private String adapterType;

    private String adapterName;

    private String adapterContext;

    private String adapterDescription;

    public AdapterPojo(String uuid, String adapterType, String adapterName, String adapterContext, String adapterDescription) {
        this.uuid = uuid;
        this.adapterType = adapterType;
        this.adapterName = adapterName;
        this.adapterContext = adapterContext;
        this.adapterDescription = adapterDescription;
    }

    public AdapterPojo() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getAdapterType() {
        return adapterType;
    }

    public void setAdapterType(String adapterType) {
        this.adapterType = adapterType == null ? null : adapterType.trim();
    }

    public String getAdapterName() {
        return adapterName;
    }

    public void setAdapterName(String adapterName) {
        this.adapterName = adapterName == null ? null : adapterName.trim();
    }

    public String getAdapterContext() {
        return adapterContext;
    }

    public void setAdapterContext(String adapterContext) {
        this.adapterContext = adapterContext == null ? null : adapterContext.trim();
    }

    public String getAdapterDescription() {
        return adapterDescription;
    }

    public void setAdapterDescription(String adapterDescription) {
        this.adapterDescription = adapterDescription == null ? null : adapterDescription.trim();
    }
}