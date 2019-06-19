package com.skytech.grading.business.service.impl;

import com.skytech.grading.business.dao.StructuralDao;
import com.skytech.grading.business.domain.Structural;
import com.skytech.grading.business.service.StructuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StructuralServiceImpl implements StructuralService {

    @Autowired
    private StructuralDao structuralDao;
    @Override
    public void addInfor(Structural structural) throws Exception {
        structuralDao.addInfor(structural);
    }

    @Override
    public void delById(String id) throws Exception {
        structuralDao.delById(id);
    }

    @Override
    public void delByProjectName(String project_name) throws Exception {
        structuralDao.delByProjectName(project_name);
    }

    @Override
    public void delByProductName(String product_name) throws Exception {
        structuralDao.delByProductName(product_name);
    }

    @Override
    public void updateInfor(Structural structural) throws Exception {
        structuralDao.updateInfor(structural);
    }

    @Override
    public List<Structural> findInfor(String id) throws Exception {
        return structuralDao.findInfor(id);
    }
}
