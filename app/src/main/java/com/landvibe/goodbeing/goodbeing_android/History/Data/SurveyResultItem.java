package com.landvibe.goodbeing.goodbeing_android.History.Data;

/**
 * Created by KSM on 2017-08-13.
 */

public class SurveyResultItem {
    private String user_name;       // 사용자 이름
    private String survey_date;     // 설문 작성 날짜
    private String survey_score;    // 설문 점수

    public SurveyResultItem(String user_name, String survey_date, String survey_score) {
        this.user_name = user_name;
        this.survey_date = survey_date;
        this.survey_score = survey_score;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSurvey_date() {
        return survey_date;
    }

    public void setSurvey_date(String survey_date) {
        this.survey_date = survey_date;
    }

    public String getSurvey_score() {
        return survey_score;
    }

    public void setSurvey_score(String survey_score) {
        this.survey_score = survey_score;
    }
}
