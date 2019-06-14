package com.skytech.grading.business.dao;

import com.skytech.grading.business.domain.RatingForm;

import java.util.List;

public interface RatingFormDao {
    List<RatingForm> selectRatingForms();

    void updateRatingForm(RatingForm ratingForm);

    void addRatingForm(RatingForm ratingForm);

    int selectByCondition(String condition);
}
