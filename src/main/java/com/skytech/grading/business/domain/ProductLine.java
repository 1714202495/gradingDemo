package com.skytech.grading.business.domain;

public class ProductLine {
    private int id;
    private String productLineName; //产品线名称
    private String pricipal; //负责人

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductLineName() {
        return productLineName;
    }

    public void setProductLineName(String productLineName) {
        this.productLineName = productLineName;
    }

    public String getPricipal() {
        return pricipal;
    }

    public void setPricipal(String pricipal) {
        this.pricipal = pricipal;
    }
}
