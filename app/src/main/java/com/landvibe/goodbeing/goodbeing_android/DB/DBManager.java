package com.landvibe.goodbeing.goodbeing_android.DB;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jik on 2017-08-24.
 */

public class DBManager extends SQLiteOpenHelper{
    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        SQLiteDatabase db= this.getWritableDatabase();
    }

    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DB(TOTAL_SCORE TEXT , " +
                                        "SECTION1_SCORE TEXT, " +
                                        "SECTION2_SCORE TEXT ," +
                                        "SECTION3_SCORE TEXT ," +
                                        "SECTION4_SCORE TEXT , " +
                                        "SECTION5_SCORE TEXT ," +
                                        "SECTION6_SCORE TEXT , " +
                                        "SECTION7_SCORE TEXT ," +
                                        "SECTION8_SCORE TEXT);");
        Log.d("asdfDB"," 생성완료");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion == 1 && newVersion == 2){
            db.execSQL("ALTER TABLE DB ADD DATE TEXT");
        }
    }




}
