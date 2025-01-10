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
        String tSach = "CREATE TABLE SACH(masach integer primary key autoincrement, tensach text, tacgia text, loaisach text, giaban integer)";
        db.execSQL(tSach);
        String tUser = "CREATE TABLE USER(mauser integer primary key autoincrement, username text, password text)";
        db.execSQL(tUser);

        //data mau loai sach va nguoidung
        db.execSQL("INSERT INTO SACH VALUES(1,'abc','xuat ban tre','thieu nhi',1000),(2,'ma','xuat ban thuong','kinh di',2000),(3,'cai luong','xuat ban gia','chieu chill',3000)");
        db.execSQL("INSERT INTO USER VALUES(1,'Nguyen Van A','111'),(2,'Nguyen Van B','222'),(3,'Nguyen Van C','333')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
