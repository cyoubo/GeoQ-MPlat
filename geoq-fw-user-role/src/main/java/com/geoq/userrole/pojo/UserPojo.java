package com.geoq.userrole.pojo;

public class UserPojo {
    private String uuid;

    private String name;

    private String password;

    private String role;

    private String department;

    public UserPojo(String uuid, String name, String password, String role, String department) {
        this.uuid = uuid;
        this.name = name;
        this.password = password;
        this.role = role;
        this.department = department;
    }

    public UserPojo() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }
}