package com.example.fpolylib.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fpolylib.database.DbHelper;

public class NguoiDungDAO {
    private DbHelper dbHelper;
    SharedPreferences sharedPreferences;

    public NguoiDungDAO(Context context) {
        dbHelper = new DbHelper(context);
        sharedPreferences = context.getSharedPreferences("dataUser", Context.MODE_PRIVATE);
    }

    //kiem tra thon tin dang nhap
    public boolean kiemTraDangNhap(String username, String password) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM USER WHERE username = ? AND password = ?", new String[]{username, password});

        SharedPreferences.Editor editor = sharedPreferences.edit();


        return cursor.getCount() > 0;
    }

}
