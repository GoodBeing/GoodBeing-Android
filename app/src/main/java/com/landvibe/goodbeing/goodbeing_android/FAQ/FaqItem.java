package com.landvibe.goodbeing.goodbeing_android.FAQ;

/**
 * Created by jik on 2017-07-31.
 */

public class FaqItem {

    private String question;
    private String answer;

    public FaqItem(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    private int image;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
