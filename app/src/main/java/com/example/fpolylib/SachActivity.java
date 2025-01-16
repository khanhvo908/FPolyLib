package com.example.fpolylib;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fpolylib.adapter.SachAdapter;
import com.example.fpolylib.dao.SachDAO;
import com.example.fpolylib.model.Sach;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class SachActivity extends AppCompatActivity {
    private SachDAO sachDAO;
    private RecyclerView recyclerViewSach;
    private ArrayList<Sach> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);

        //thiet ke giao dien
        recyclerViewSach = findViewById(R.id.recyclerViewSach);
        FloatingActionButton floatAdd = findViewById(R.id.floatAdd);

        //su kien
        floatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hien thi dialog them sach
                showDialogThem();
            }
        });

        //data
        sachDAO = new SachDAO(this);


        //adapter
        loadData();


    }

    private void loadData() {
        //adapter
        list = sachDAO.getDSSach();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewSach.setLayoutManager(linearLayoutManager);
        SachAdapter SachAdapter = new SachAdapter(this, list);
        recyclerViewSach.setAdapter(SachAdapter);
    }

    private void showDialogThem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_sach, null);
        builder.setView(view);

        AlertDialog alertdialog = builder.create();
        Objects.requireNonNull(alertdialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        alertdialog.setCancelable(false);
        alertdialog.show();

        //anh xa
        EditText edtTenSach = view.findViewById(R.id.edtTenSach);
        Button btnThem = view.findViewById(R.id.btnThem);
        Button btnHuy = view.findViewById(R.id.btnHuy);

        //su kien
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tensach = edtTenSach.getText().toString();
                boolean check = sachDAO.themSach(tensach);
                if (check) {
                    Toast.makeText(SachActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                    loadData();
                    alertdialog.dismiss();
                } else {
                    Toast.makeText(SachActivity.this, "Them that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}