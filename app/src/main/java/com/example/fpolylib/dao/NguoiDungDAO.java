package com.example.fpolylib.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fpolylib.database.DbHelper;

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

}
