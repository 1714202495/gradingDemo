package com.skytech.grading.business.domain;

/**
 * 部门组织架构实体类
 */
public class Structural {
    private String id;//员工编号
    private String project_emp;//员工姓名
    private String project_name;//项目组名称
    private String project_manager;//项目组负责人
    private String product_name;//产品线名称
    private String product_manager;//产品线负责人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_manager() {
        return product_manager;
    }

    public void setProduct_manager(String product_manager) {
        this.product_manager = product_manager;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_manager() {
        return project_manager;
    }

    public void setProject_manager(String project_manager) {
        this.project_manager = project_manager;
    }

    public String getProject_emp() {
        return project_emp;
    }

    public void setProject_emp(String project_emp) {
        this.project_emp = project_emp;
    }
}
