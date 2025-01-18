package com.example.fpolylib.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fpolylib.database.DbHelper;
import com.example.fpolylib.model.Sach;

import java.util.ArrayList;

public class SachDAO {

    private DbHelper dbHelper;

    public SachDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    //lay danh sach cua sach
    public ArrayList<Sach> getDSSach() {
        ArrayList<Sach> list = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SACH", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new Sach(cursor.getInt(0), cursor.getString(1)));
            } while (cursor.moveToNext());
        }

        return list;
    }

    //them sach
    public boolean themSach(String tensach) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("tensach", tensach);

        long check = sqLiteDatabase.insert("SACH", null, contentValues);

        return check != -1;
    }

    public boolean suaSach(Sach sach) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("tensach", sach.getTensach());

        int check = sqLiteDatabase.update("SACH", contentValues, "masach=?", new String[]{String.valueOf(sach.getMasach())});

        return check != 0;
    }

    public boolean xoaSach(int masach) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        int check = sqLiteDatabase.delete("SACH", "masach=?", new String[]{String.valueOf(masach)});

        return check != 0;
    }

}
