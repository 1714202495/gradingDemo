package com.skytech.grading.business.service.impl;

import com.skytech.grading.business.common.MyException;
import com.skytech.grading.business.dao.RatingFormDao;
import com.skytech.grading.business.domain.RatingForm;
import com.skytech.grading.business.service.RatingFormService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class RatingFormServiceImpl implements RatingFormService {

    @Autowired
    private RatingFormDao ratingFormDao;

    @Override
    public List<RatingForm> selectRatingForms() {
        return ratingFormDao.selectRatingForms();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;
//        List<RatingForm> rfList = new ArrayList<>();
//        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            throw new MyException("上传文件格式不正确");
//        }
//        boolean isExcel2003 = true;
//        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
//            isExcel2003 = false;
//        }
//        InputStream is = file.getInputStream();
//        Workbook wb = null;
//        if (isExcel2003) {
//            wb = new HSSFWorkbook(is);
//        } else {
//            wb = new XSSFWorkbook(is);
//        }
//        Sheet sheet = wb.getSheetAt(0);
//        if(sheet!=null){
//            notNull = true;
//        }
//        RatingForm ratingForm;
//        for (int r = 2; r <= sheet.getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据
//            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
//            if (row == null){
//                continue;
//            }
//
//            //sheet.getLastRowNum() 的值是多少，那么Excel表中的数据至少就是这么多条；不然报错 NullPointerException
//
//            ratingForm = new RatingForm();
//
//            if(row.getCell(0).getCellType() !=1){//循环时，得到每一行的单元格进行判断
//                throw new MyException("导入失败(第"+(r+1)+"行,用户名请设为文本格式)");
//            }
//
//            String level = row.getCell(0).getStringCellValue();//得到每一行第一个单元格的值
//            if(level == null || level.isEmpty()){//判断是否为空
//                throw new MyException("导入失败(第"+(r+1)+"行,等级未填写)");
//            }
//
//            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
//
//            String sort = row.getCell(1).getStringCellValue();
//            if(sort==null || sort.isEmpty()){
//                throw new MyException("导入失败(第"+(r+1)+"行,类别未填写)");
//            }
//
//            String condition = row.getCell(2).getStringCellValue();
//            if(condition==null || condition.isEmpty()){
//                throw new MyException("导入失败(第"+(r+1)+"行,条件未填写)");
//            }
//
//            int score = Integer.valueOf((int) row.getCell(3).getNumericCellValue());
//
//            //完整的循环一次 就组成了一个对象
//            ratingForm.setLevel(level);
//            ratingForm.setSort(sort);
//            ratingForm.setCondition(condition);
//            ratingForm.setScore(score);
//            rfList.add(ratingForm);
//        }
//        for (RatingForm record : rfList) {
//            //String condition = record.getCondition();
//            //int cnt = ratingFormDao.selectByCondition(condition);
////            if (cnt == 0) {
////                ratingFormDao.addRatingForm(record);
////                System.out.println(" 插入 "+record);
////            } else {
//                ratingFormDao.updateRatingForm(record);
//                System.out.println(" 更新 "+record);
// //           }
//        }
        return notNull;
    }

    @Override
    public void selectAvgScore(String level){
        ratingFormDao.selectAvgScore(level);
    }
}
