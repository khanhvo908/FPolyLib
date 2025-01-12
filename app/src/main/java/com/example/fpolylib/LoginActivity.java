package com.example.fpolylib;

import static androidx.core.content.ContextCompat.startActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fpolylib.dao.NguoiDungDAO;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        NguoiDungDAO nguoiDungDAO;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtUser = findViewById(R.id.edtUser);
        EditText edtPass = findViewById(R.id.edtPass);
        Button btnLogin = findViewById(R.id.btnLogin);

        nguoiDungDAO = new NguoiDungDAO(this);

        btnLogin.setOnClickListener(view -> {
            String user = edtUser.getText().toString();
            String pass = edtPass.getText().toString();

            boolean check = nguoiDungDAO.kiemTraDangNhap(user, pass);

            if (check) {
                startActivities(new Intent[]{new Intent(LoginActivity.this, MainActivity.class)});
            } else {
                Toast.makeText(LoginActivity.this, "Tên đăng nhập hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
            }
        });
    }
}