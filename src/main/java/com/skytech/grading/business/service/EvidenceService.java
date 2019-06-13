package com.skytech.grading.business.service;

import com.skytech.grading.business.domain.Evidence;
import com.skytech.grading.business.util.PageHelper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EvidenceService {
    public PageHelper getEvidenceList(PageHelper pageHelper);

    boolean uploadEvidence(MultipartFile file,Evidence evidence,String evidenceId);

    int delEvidence(Evidence evidence);

}
