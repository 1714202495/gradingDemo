package com.skytech.grading.business.dao;

import com.skytech.grading.business.domain.Evidence;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvidenceDao {
    List<Evidence> getEvidenceByPage(int page, int limit);

    int uploadEvidence(Evidence evidence);

    int delEvidence(Evidence evidence);

}
