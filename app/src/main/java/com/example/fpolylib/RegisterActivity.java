package com.example.fpolylib;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fpolylib.dao.NguoiDungDAO;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText edtUser = findViewById(R.id.edtUser);
        EditText edtPass = findViewById(R.id.edtPass);
        EditText edtRePass = findViewById(R.id.edtRePass);
        Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(view -> {
            String user = edtUser.getText().toString();
            String pass = edtPass.getText().toString();
            String rePass = edtRePass.getText().toString();

            if (pass.equals(rePass)) {
                //dang ky
                NguoiDungDAO nguoiDungDAO = new NguoiDungDAO(RegisterActivity.this);
                boolean check = nguoiDungDAO.dangKy(user, pass);
                if (check) {
                    Toast.makeText(RegisterActivity.this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "Dang ky that bai", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(RegisterActivity.this, "Mat khau khong trung khop", Toast.LENGTH_SHORT).show();
            }
        });
    }
}