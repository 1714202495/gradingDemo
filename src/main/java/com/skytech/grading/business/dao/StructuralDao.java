package com.skytech.grading.business.dao;

import com.skytech.grading.business.domain.Structural;

import java.util.List;

public interface StructuralDao {
    //新增
    void addInfor(Structural structural) throws Exception;

    //根据员工号删除项目组成员
    void delById(String id) throws Exception;
    //根据项目组名称删除项目组
    void delByProjectName(String project_name) throws Exception;
    //根据产品线名称删除产品线
    void delByProductName(String product_name) throws Exception;

    void updateInfor(Structural structural) throws Exception;

    List<Structural> findInfor(String id) throws Exception;



}
