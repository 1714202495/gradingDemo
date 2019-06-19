package com.skytech.grading.business.service.impl;

import com.skytech.grading.business.dao.EvidenceDao;
import com.skytech.grading.business.dao.UserDao;
import com.skytech.grading.business.domain.Evidence;
import com.skytech.grading.business.domain.User;
import com.skytech.grading.business.service.EvidenceService;
import com.skytech.grading.business.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.math.BigDecimal;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EvidenceServiceImpl implements EvidenceService {
    @Autowired
    private EvidenceDao evidenceDao;

    @Autowired
    private UserDao userDao;

    @Value("${evidence-path}")
    private String evidencePath;

    @Value("${evidence-path-yhsc}")
    private String evidencePathYhsc;

    @Value("${evidence-static-pattern}")
    private String evidenceStaticPattern;
    @GetMapping(value = "file")
    public String file() {
        return "file";
    }

    @Override
    public PageHelper getEvidenceList(PageHelper pageHelper) {
        try {
            if (pageHelper.getPage() <= 0) {
                pageHelper.setPage(1);
            }

            List<Evidence> list = evidenceDao.getEvidenceByPage(pageHelper.getPage(), pageHelper.getLimit());
            pageHelper.setList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pageHelper;
    }

    @Override
    @Transactional
    public boolean uploadEvidence(MultipartFile file,Evidence evidence,String userid) {
        try {
            Format format = new SimpleDateFormat("yyyyMMddHHmmss");
            if (file.isEmpty()) {
                System.out.println("文件为空");
            }

            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            String filePath = evidencePath + evidencePathYhsc + userid+"/" + format.format(new Date()); // 上传后的路径

            /*设置数据库同步插入的值*/
            String url = evidencePathYhsc + userid+"/" + format.format(new Date());

            evidence.setEvidenceId(UUID.randomUUID().toString());
            evidence.setEvidenceName(fileName);
            evidence.setEvidenceUploader(userid);
            evidence.setEvidenceUrl(url);

            File file1 = new File(filePath);
            if(!file1.exists()){
                file1.mkdirs();
            }

            //新文件名为登录ID+上传时间+文件后缀
            fileName = userid + format.format(new Date()) + suffixName; // 新文件名
            evidence.setEvidenceUrl(evidenceStaticPattern+url+"/"+fileName);
            File dest = new File(filePath +File.separator+fileName);
            file.transferTo(dest);

        } catch (Exception e) {
            return false;
        }
        evidenceDao.uploadEvidence(evidence);
        return true;
    }

    @Override
    public int delEvidence(Evidence evidence) {
        return evidenceDao.delEvidence(evidence);
    }
}
