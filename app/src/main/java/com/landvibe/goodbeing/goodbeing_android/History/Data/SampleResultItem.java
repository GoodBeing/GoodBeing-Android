package com.landvibe.goodbeing.goodbeing_android.History.Data;

/**
 * Created by KSM on 2017-08-13.
 */

public class SampleResultItem {
    private String user_name;       // 사용자 이름
    private String sample_date;     // 설문 작성 날짜
    private String sample_status;    // 설문 점수
    private String sample_result;

    public SampleResultItem(String user_name, String sample_date, String sample_status, String sample_result) {
        this.user_name = user_name;
        this.sample_date = sample_date;
        this.sample_status = sample_status;
        this.sample_result = sample_result;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSample_date() {
        return sample_date;
    }

    public void setSample_date(String sample_date) {
        this.sample_date = sample_date;
    }

    public String getSample_status() {
        return sample_status;
    }

    public void setSample_status(String sample_status) {
        this.sample_status = sample_status;
    }

    public String getSample_result() {
        return sample_result;
    }

    public void setSample_result(String sample_result) {
        this.sample_result = sample_result;
    }
}
