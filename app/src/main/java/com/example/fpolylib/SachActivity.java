package com.example.fpolylib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fpolylib.adapter.SachAdapter;
import com.example.fpolylib.dao.SachDAO;
import com.example.fpolylib.model.Sach;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SachActivity extends AppCompatActivity {
    private SachDAO sachDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);

        //thiet ke giao dien
        RecyclerView recyclerViewSach = findViewById(R.id.recyclerViewSach);
        FloatingActionButton floatAdd = findViewById(R.id.floatAdd);

        //data
        sachDAO = new SachDAO(this);
        ArrayList<Sach> list = sachDAO.getDSSach();

        //adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewSach.setLayoutManager(linearLayoutManager);
        SachAdapter SachAdapter = new SachAdapter(this, list);
        recyclerViewSach.setAdapter(SachAdapter);

    }
}