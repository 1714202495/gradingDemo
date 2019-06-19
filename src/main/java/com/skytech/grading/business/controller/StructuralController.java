package com.skytech.grading.business.controller;

import com.skytech.grading.business.domain.Structural;
import com.skytech.grading.business.service.StructuralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StructuralController {
    @Autowired
    private StructuralService structuralService;

    /**
     * 添加部门组织结构
     * @param structural fdfd
     */
    @RequestMapping(value = "/Structural/addInfor", method = RequestMethod.POST)
    public void addInfor(@RequestBody Structural structural){
        try {
            structuralService.addInfor(structural);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据员工号删除项目组成员
     * @param id
     */
    @RequestMapping(value = "/Structural/delById",method = RequestMethod.GET)
    public void delById(@RequestParam("id") String id){
        try {
            structuralService.delById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据项目组名称删除项目组
     * @param project_name
     */
    @RequestMapping(value = "/Structural/delByProjectName",method = RequestMethod.GET)
    public void delByProjectName(@RequestParam("project_name") String project_name){
        try {
            structuralService.delByProjectName(project_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据产品线名称删除产品线
     * @param product_name
     */
    @RequestMapping(value = "/Structural/delByProductName",method = RequestMethod.GET)
    public void delByProductName(@RequestParam("product_name") String product_name){
        try {
            structuralService.delByProductName(product_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改
     * @param structural
     */
    @RequestMapping(value = "/Structural/updateInfor",method = RequestMethod.POST)
    public void updateInfor(@RequestBody Structural structural){
        try {
            structuralService.updateInfor(structural);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/Structural/findInfor",method = RequestMethod.GET)
    public List<Structural> findInfor(@RequestParam("id") String id) throws Exception {
        return structuralService.findInfor(id);
    }
}
