package com.landvibe.goodbeing.goodbeing_android;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistoryItem {

    private String name;

    private Boolean gender;

    private int age;

    private int bloodType;

    public HistoryItem() {
    }

    public HistoryItem(String name, Boolean gender, int age, int bloodType) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.bloodType = bloodType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBloodType() {
        return bloodType;
    }

    public void setBloodType(int bloodType) {
        this.bloodType = bloodType;
    }
}
