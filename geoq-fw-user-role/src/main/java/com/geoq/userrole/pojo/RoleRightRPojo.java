package com.geoq.userrole.pojo;

public class RoleRightRPojo {
    private String uuid;

    private String roleUuid;

    private String rightUuid;

    public RoleRightRPojo(String uuid, String roleUuid, String rightUuid) {
        this.uuid = uuid;
        this.roleUuid = roleUuid;
        this.rightUuid = rightUuid;
    }

    public RoleRightRPojo() {
        super();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid == null ? null : roleUuid.trim();
    }

    public String getRightUuid() {
        return rightUuid;
    }

    public void setRightUuid(String rightUuid) {
        this.rightUuid = rightUuid == null ? null : rightUuid.trim();
    }
}