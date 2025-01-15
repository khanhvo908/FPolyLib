package com.example.fpolylib.dao;

import android.content.Context;

import com.example.fpolylib.database.DbHelper;

public class SachDAO {

    private DbHelper dbHelper;

    public SachDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    //lay danh sach cua sach

}
