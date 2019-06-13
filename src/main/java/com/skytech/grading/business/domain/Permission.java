package com.skytech.grading.business.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
    private String permissionId;
    private String permissionName;
    //中文名字
    private String permissionZNName;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionZNName() {
        return permissionZNName;
    }

    public void setPermissionZNName(String permissionZNName) {
        this.permissionZNName = permissionZNName;
    }
}
