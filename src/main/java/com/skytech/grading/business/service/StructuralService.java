package com.skytech.grading.business.service;

import com.skytech.grading.business.domain.Structural;

import java.util.List;

public interface StructuralService {
    void addInfor(Structural structural) throws Exception;

    void delById(String id) throws Exception;
    void delByProjectName(String project_name) throws Exception;
    void delByProductName(String product_name) throws Exception;

    void updateInfor(Structural structural) throws Exception;

    List<Structural> findInfor(String id) throws Exception;
}
