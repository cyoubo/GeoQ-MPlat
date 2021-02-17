package com.geoq.assettype.admin.pojo;

import com.geoq.common.datastruct.AdjacencyTableElement;

public class AssetTypePojo implements AdjacencyTableElement {
    private String uuid;

    private String parentUuid;

    private String name;

    private String code;

    public AssetTypePojo(String uuid, String parentUuid, String name, String code) {
        this.uuid = uuid;
        this.parentUuid = parentUuid;
        this.name = name;
        this.code = code;
    }

    public AssetTypePojo() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid == null ? null : parentUuid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    @Override
    public String getParentKey() {
        return this.parentUuid;
    }

    @Override
    public String getSelfKey() {
        return this.uuid;
    }
}