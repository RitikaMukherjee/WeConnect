package com.example.weconnect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="Database";
    private static final String TABLE_NAME="USER_Table";
    private static int version=1;
    private static final String UID="uid";
    private static final String UNAME="uname";
    private static final String PASSWORD="password";
    private static final String EMAIL="email";
    private static final String COLLEGE="college";
    private static final String COURSE="course";
    private static final String STREAM="stream";
    private static final String YOA="yoa";
    private static final String YOP="yop";
    private static final String COMPANY="company";
    private static final String CREATE_TABLE="CREATE TABLE "+TABLE_NAME+"("+UID+" INTEGER(10) PRIMARY KEY AUTOINCREMENT, "+UNAME+" VARCHAR(50) NOT NULL, "+EMAIL+" VARCHAR(50) NOT NULL, "+PASSWORD+" VARCHAR(10) NOT NULL, "+COLLEGE+" VARCHAR(50) NOT NULL, "+COURSE+" VARCHAR(50) NOT NULL, "+STREAM+" VARCHAR(50) NOT NULL, "+YOA+" INTEGER(4) NOT NULL, "+YOP+" INTEGER(4) NOT NULL, "+COMPANY+" VARCHAR(50));";
    private static final String UPGRADE_TABLE="UPDATE "+TABLE_NAME+" SET UNAME='uname',EMAIL='email',PASSEORD='password',COLLEGE='college',COURSE='course',STREAM='stream',YOA=yoa,YOP=yop,COMPANY='company' WHERE UID=uid;";
    private  Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Toast.makeText(context,"User is signed up successfully",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(context,""+e,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            version++;
            sqLiteDatabase.execSQL(UPGRADE_TABLE);
            Toast.makeText(context,"User is signed up successfully",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(context,""+e,Toast.LENGTH_LONG).show();
        }
    }
}
