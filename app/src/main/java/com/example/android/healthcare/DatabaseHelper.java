package com.example.android.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "Register.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("Create table user(email text primary key,username text,password text,phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");

    }
    // inserting in database
    public boolean insert(String username,String email,String password,String phone)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("phone",phone);
        long ins=db.insert("user",null,contentValues);
        if(ins==-1) return false;
        else return true;
    }
    public Boolean checkemail(String email)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from user where email=?",new String[] {email});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    //checking the email and password

    public Boolean emailpassword(String email,String password)
    {
     SQLiteDatabase db=this.getReadableDatabase();
     Cursor cursor = db.rawQuery("Select * from user where email=? and password=?",new String[]{email,password});
     if(cursor.getCount()>0) return true;
     else return false;
    }
    public String getName(String email1){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select username from user where email='"+email1+"'",new String[]{});
        StringBuffer buffer=new StringBuffer();
        while(cursor.moveToNext()){
            String name=cursor.getString(0);
            buffer.append(""+name);
        }
        return buffer.toString();
    }
}
