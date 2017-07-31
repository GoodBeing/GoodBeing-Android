package com.landvibe.goodbeing.goodbeing_android.FAQ;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;

/**
 * Created by jik on 2017-07-31.
 */

class FaqViewHolder extends RecyclerView.ViewHolder {
    private TextView question;
    private TextView answer;
    private ImageView image;

    public TextView getQuestion() {
        return question;
    }

    public void setQuestion(TextView question) {
        this.question = question;
    }

    public TextView getAnswer() {
        return answer;
    }

    public void setAnswer(TextView answer) {
        this.answer = answer;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public FaqViewHolder(View itemView) {
        super(itemView);

        question = (TextView) itemView.findViewById(R.id.faq_question_tv);
        answer = (TextView) itemView.findViewById(R.id.faq_answer_tv);
        image = (ImageView) itemView.findViewById(R.id.faq_item_iv);
    }
}
