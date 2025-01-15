package com.example.fpolylib.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "QUANLYTHUVIEN", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tao bang loai sach và nguoi dung
        String tSach = "CREATE TABLE SACH(masach integer primary key autoincrement, tensach text)";
        db.execSQL(tSach);
        String tUser = "CREATE TABLE USER(mauser integer primary key autoincrement, username text, password text)";
        db.execSQL(tUser);

        //data mau loai sach va nguoidung
        db.execSQL("INSERT INTO SACH VALUES(1,'abc'),(2,'ma'),(3,'cai luong')");
        db.execSQL("INSERT INTO USER VALUES(1,'Vo Duy Bao Khanh','111'),(2,'Nguyen Hong Bao Ngoc','255'),(3,'Nguyen Van Ba','333')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1) {
            db.execSQL("DROP TABLE IF EXISTS SACH");
            db.execSQL("DROP TABLE IF EXISTS USER");
            onCreate(db);
        }
    }
}
