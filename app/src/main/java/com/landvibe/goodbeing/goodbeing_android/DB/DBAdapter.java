package com.landvibe.goodbeing.goodbeing_android.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.landvibe.goodbeing.goodbeing_android.History.Data.SurveyTotalItem;

import java.util.ArrayList;

/**
 * Created by jik on 2017-08-24.
 */

public class DBAdapter {
    private DBManager dbHelper;
    public DBAdapter()
    {
    }
    public DBAdapter(Context context)
    {
        dbHelper = new DBManager(context,"SQLITEDB",null,1);
    }

    public void insert(String totalscore,String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String _query = "insert into DB (TOTAL_SCORE, SECTION1_SCORE," +
                                            "SECTION2_SCORE,SECTION3_SCORE," +
                                            "SECTION4_SCORE, SECTION5_SCORE, " +
                                            "SECTION6_SCORE,SECTION7_SCORE," +
                                            "SECTION8_SCORE) " +
                                            "values(" + totalscore + "," + s1 + " , " + s2+ "," + s3+"," + s4+"," + s5+"," + s6+"," + s7+"," + s8 + ")";

        Log.d("asdfDB"," insert query : "+_query);
        db.execSQL(_query);
        db.close();
        Log.d("asdfDB"," insert 완료");
    }

    public ArrayList<SurveyTotalItem> selectAll()
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<SurveyTotalItem> arrlist = new ArrayList<SurveyTotalItem>();
        String str = "";
        Cursor cursor = db.rawQuery("select * from DB",null);
        if(cursor!=null)
        {
            while(cursor.moveToNext())
            {
                SurveyTotalItem item = new SurveyTotalItem(cursor.getString(0),cursor.getString(1),
                        cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
                        cursor.getString(6),cursor.getString(7),cursor.getString(8));
                arrlist.add(item);
            }
            return arrlist;
        }
        else
            return null;
    }
}
