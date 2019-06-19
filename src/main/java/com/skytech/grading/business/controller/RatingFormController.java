package com.skytech.grading.business.controller;

import com.skytech.grading.business.domain.RatingForm;
import com.skytech.grading.business.service.RatingFormService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RatingFormController {

    @Autowired
    private RatingFormService ratingFormService;

    @RequestMapping("/showRatingForm")
    public String showRatingForm(Model model) {
        List<RatingForm> ratingForms = ratingFormService.selectRatingForms();
        model.addAttribute("ratingForm", ratingForms);
        return "index";
    }



    @RequestMapping(value = "/import")
    public String exImport(@RequestParam(value = "filename")MultipartFile file, HttpSession session) {
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = ratingFormService.batchImport(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:index";
    }

    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException {
        List<RatingForm> ratingForms = ratingFormService.selectRatingForms();

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("获取excel测试表格");

        HSSFRow row = null;

        row = sheet.createRow(0); //创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("定岗定级评分表"); //为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第5个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 5);
        sheet.addMergedRegion(rowRegion);
		/*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
		sheet.addMergedRegion(columnRegion);*/

        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("编号");//为第一个单元格设值
        row.createCell(1).setCellValue("等级");//为第二个单元格设值
        row.createCell(2).setCellValue("类别");//为第三个单元格设值
        row.createCell(3).setCellValue("条件");//为第四个单元格设值
        row.createCell(4).setCellValue("分数");//为第五个单元格设值

        for (int i = 0; i < ratingForms.size(); i++) {
            row = sheet.createRow(i + 2);
            RatingForm ratingForm = ratingForms.get(i);
            row.createCell(0).setCellValue(ratingForm.getRatingFormId());
            row.createCell(1).setCellValue(ratingForm.getLevel());
            row.createCell(2).setCellValue(ratingForm.getSort());
            row.createCell(3).setCellValue(ratingForm.getCondition());
            row.createCell(4).setCellValue(ratingForm.getScore()
            );
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=定岗定级.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }

    @RequestMapping
    public void selectAvgScore(@RequestParam("level")String level){
        ratingFormService.selectAvgScore(level);
    }

}
