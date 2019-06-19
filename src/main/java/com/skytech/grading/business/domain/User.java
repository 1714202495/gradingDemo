package com.skytech.grading.business.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Classname User
 * @Description TODO
 * @Date 2019/4/28 19:55
 * @Created by huangdasheng
 */
//lombok
@Data  //不用手动添加set get方法
public class User implements Serializable {
    private String id;
    private String password;
    private String name;
    private Integer age;
    private String email;
    private List<Role> roleList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
