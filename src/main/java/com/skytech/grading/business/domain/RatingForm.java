package com.skytech.grading.business.domain;

public class RatingForm {
    private String ratingFormId;
    private String level; //等级
    private String sort; //类别
    private String condition; //条件
    private int score; //分数

    public String getRatingFormId() {
        return ratingFormId;
    }

    public void setRatingFormId(String ratingFormId) {
        this.ratingFormId = ratingFormId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
