package com.example.fpolylib.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fpolylib.database.DbHelper;
import com.example.fpolylib.model.NguoiDung;

public class NguoiDungDAO {
    private DbHelper dbHelper;

    public NguoiDungDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    //kiem tra thon tin dang nhap
    public boolean kiemTraDangNhap(String username, String password) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM USER WHERE username = ? AND password = ?", new String[]{username, password});
        return cursor.getCount() > 0;
    }

    //dang ky
    public boolean dangKy(String username, String password) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);

        long check = sqLiteDatabase.insert("USER", null, contentValues);
        //check trung username


        return check != -1;
    }

}
