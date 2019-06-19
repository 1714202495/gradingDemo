package com.skytech.grading.business.dao;

import com.skytech.grading.business.domain.RatingForm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingFormDao {
    List<RatingForm> selectRatingForms();

    void updateRatingForm(RatingForm ratingForm);

    void selectAvgScore(String level);

    //void addRatingForm(RatingForm ratingForm);

    //int selectByCondition(String condition);
}
