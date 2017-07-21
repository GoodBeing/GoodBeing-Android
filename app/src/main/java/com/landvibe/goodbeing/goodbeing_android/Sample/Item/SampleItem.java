package com.landvibe.goodbeing.goodbeing_android.Sample.Item;

/**
 * Created by KSM on 2017-07-21.
 */

public class SampleItem {
    int user_image;
    String user_name;           // 신청자 성명
    String sample_date;         // 신청 날짜
    String sample_status;       // 진행 현황

    public SampleItem(int user_image, String user_name, String sample_date, String sample_status) {
        this.user_image = user_image;
        this.user_name = user_name;
        this.sample_date = sample_date;
        this.sample_status = sample_status;
    }

    public int getUser_image() {
        return user_image;
    }

    public void setUser_image(int user_image) {
        this.user_image = user_image;
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
}
