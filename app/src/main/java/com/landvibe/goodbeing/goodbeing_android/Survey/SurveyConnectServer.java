package com.landvibe.goodbeing.goodbeing_android.Survey;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by jik on 2017-08-07.
 */

public class SurveyConnectServer {
    private AsyncHttpClient mClient;
    private RequestParams mPrarams;
    private JSONObject JObject;
    private JSONArray JArray;
      /*
    *
    SURVEY_ID			설문 결과 인덱스
    USER_IDX			사용자 인덱스
    SURVEY_DATE			설문 작성 날짜
    SURVEY_SCORE			설문 총 점수
    SURVEY_TYPE_CODE			설문 결과 유형
    DELETE_YN			삭제여부
    REG_DT			최초입력일
    REG_ID			최초입력ID
    UPD_DT			수정입력일
    UPD_ID			수정입력ID

    * */

    public void sendSurvey(String user_id, int survey_code, int score){
    mClient = new AsyncHttpClient();
    mPrarams = new RequestParams();
            mPrarams.put("USER_IDX",user_id);
            mPrarams.put("SURVEY_TYPE_CODE",survey_code);
            mPrarams.put("SURVEY_SCORE",score);
            mClient.get("URL",mPrarams, new JsonHttpResponseHandler(){
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {


                    try {
                        String answer;
                        answer = response.getJSONArray("SAMPLE_RESULT_A").toString();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                }
            });


    }

    //score를 보내면 해당 답변을 준다
    public void receiveSurveyResult(String user_id, int score)
    {

        mClient = new AsyncHttpClient();
        mPrarams = new RequestParams();


    }

}