package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Item;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jik on 2017-08-13.
 */

public class SurveyItem implements Parcelable{


    public SurveyItem(int code, int answer, String s_answer, int score) {
        this.code = code;
        this.answer = answer;
        this.s_answer = s_answer;
        this.score = score;
    }

    private int code;
    private int answer;
    private String s_answer;
    private int score;

    protected SurveyItem(Parcel in) {
        code = in.readInt();
        answer = in.readInt();
        s_answer = in.readString();
        score = in.readInt();
    }

    public static final Creator<SurveyItem> CREATOR = new Creator<SurveyItem>() {
        @Override
        public SurveyItem createFromParcel(Parcel in) {
            return new SurveyItem(in);
        }

        @Override
        public SurveyItem[] newArray(int size) {
            return new SurveyItem[size];
        }
    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getS_answer() {
        return s_answer;
    }

    public void setS_answer(String s_answer) {
        this.s_answer = s_answer;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(code);
        parcel.writeInt(answer);
        parcel.writeString(s_answer);
        parcel.writeInt(score);
    }

}
