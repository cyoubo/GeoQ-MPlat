package com.geoq.userrole.pojo;

public class RolePojo {
    private String uuid;

    private String name;

    public RolePojo(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public RolePojo() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}