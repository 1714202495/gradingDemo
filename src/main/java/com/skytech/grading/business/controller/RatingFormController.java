package com.skytech.grading.business.controller;

import com.skytech.grading.business.domain.RatingForm;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RatingFormController {
    @GetMapping("/")
    String test(HttpServletRequest request) {
        return "ratingFromImport";

    }

//处理文件上传

    @ResponseBody//返回json数据

    @RequestMapping(value = "/ratingFromImport", method = RequestMethod.POST)

    public String uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        if (file.isEmpty()) {
            return "文件为空！";
        }
        try {
            //根据路径获取这个操作excel的实例
            HSSFWorkbook wb = new HSSFWorkbook(file.getInputStream()); //根据页面index 获取sheet页
            HSSFSheet sheet = wb.getSheetAt(0);

            //实体类集合
            List<RatingForm> ratingForms = new ArrayList<>();
            HSSFRow row = null;

            //循环sesheet页中数据从第二行开始，第一行是标题
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                //获取每一行数据
                row = sheet.getRow(i);

                RatingForm rate = new RatingForm();

                rate.setRatingFormId(row.getCell(0).getStringCellValue());
                rate.setLevel(row.getCell(1).getStringCellValue());
                rate.setSort(row.getCell(2).getStringCellValue());
                rate.setCondition(row.getCell(3).getStringCellValue());
                rate.setScore(Integer.valueOf((int) row.getCell(4).getNumericCellValue()));
                ratingForms.add(rate);
            }

            //循环展示导入的数据，实际应用中应该校验并存入数据库
            for (RatingForm rf : ratingForms) {
                //SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                System.out.println("ID:"+rf.getRatingFormId()+" level:"+rf.getLevel()+" sort:"+rf.getSort()+" condition:"+rf.getCondition()+" score:"+rf.getScore());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "导入成功!";
    }
}
