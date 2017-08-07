package com.landvibe.goodbeing.goodbeing_android.Login;

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

public class LoginConnectServer {
    private AsyncHttpClient mClient;
    private RequestParams mPrarams;
    private JSONObject JObject;
    private JSONArray JArray;
      /*
    *
        USER_IDX			사용자 인덱스
        USER_ID			사용자 아이디
        USER_PW			사용자 비밀번호
        USER_NAME			사용자 이름
        USER_BIRTHDAY			사용자 생년월일
        USER_SEX			사용자 성별
        USER_ADDRESS			사용자 집주소 번호
        USER_MOBILE			사용자 휴대전화 번호
        USER_EMAIL			사용자 이메일
        DELETE_YN			삭제여부
        REG_DT			최초입력일
        REG_ID			최초입력ID
        UPD_DT			수정입력일
        UPD_ID			수정입력ID

    * */


      //id와 pw를 push하고 USER_IDX get
    public int requestLogin(String id, String pw)
    {
        int idx=0;

        mClient = new AsyncHttpClient();
        mPrarams = new RequestParams();
        mPrarams.put("USER_ID",id);
        mPrarams.put("USER_PW",pw);
        mClient.post("URL",mPrarams, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                JArray = new JSONArray();
                try {

                    JArray = response.getJSONArray("USER_IDX");

                    //idx = JArray.get(0);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            }
        });
        return idx;
    }

}
