package com.example.fpolylib;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearSach = findViewById(R.id.lnlQuanLySach);
        LinearLayout linearTaiKhoan = findViewById(R.id.lnlQuanLyTaiKhoan);

        linearSach.setOnClickListener(view -> startActivities(new Intent[]{new Intent(MainActivity.this, SachActivity.class)}));

        linearTaiKhoan.setOnClickListener(view -> startActivities(new Intent[]{new Intent(MainActivity.this, TaikhoanActivity.class)}));
    }
}