package com.example.fpolylib.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fpolylib.R;
import com.example.fpolylib.dao.SachDAO;
import com.example.fpolylib.model.Sach;

import java.util.ArrayList;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Sach> list;

    private SachDAO sachDAO;

    public SachAdapter(Context context, ArrayList<Sach> list, SachDAO sachDAO) {
        this.context = context;
        this.list = list;
        this.sachDAO = sachDAO;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_sach, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtMaSach.setText("ID: " + list.get(position).getMasach());
        holder.txtTenSach.setText(list.get(position).getTensach());

        //su kien
        holder.ivEdit.setOnClickListener(view -> {
            //hien thi dialog sua sach
            showDialogSua(list.get(holder.getAdapterPosition()));

        });
        holder.ivDelete.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Thong Bao Xoa Sach");
            builder.setMessage("Ban co chac chan muon xoa sach nay khong?");
            builder.setPositiveButton("CO", (dialogInterface, i) -> {
                int check = sachDAO.xoaSach(list.get(holder.getAdapterPosition()).getMasach());
                if (check == 1) {
                    Toast.makeText(context, "Xoa thanh cong", Toast.LENGTH_SHORT).show();
                    loadData();
                } else {
                    Toast.makeText(context, "Xoa that bai", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("KHONG", null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //khai bao cac thanh phan trong item
        TextView txtMaSach;
        TextView txtTenSach;
        ImageView ivEdit;
        ImageView ivDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //anh xa
            txtMaSach = itemView.findViewById(R.id.txtMaSach);
            txtTenSach = itemView.findViewById(R.id.txtTenSach);
            ivEdit = itemView.findViewById(R.id.ivEdit);
            ivDelete = itemView.findViewById(R.id.ivDelete);
        }
    }

    private void showDialogSua(Sach sach) {
        //dialog sua sach
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_sach, null);
        builder.setView(view);

        AlertDialog alertdialog = builder.create();
        alertdialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        alertdialog.setCancelable(false);
        alertdialog.show();

        TextView txtTieuDe = view.findViewById(R.id.txtTieuDe);
        EditText edtTenSach = view.findViewById(R.id.edtTenSach);
        Button btnThem = view.findViewById(R.id.btnThem);
        Button btnHuy = view.findViewById(R.id.btnHuy);

        //set du lieu
        txtTieuDe.setText("Sửa sách");
        btnThem.setText("Sửa");
        edtTenSach.setText(sach.getTensach());

        btnThem.setOnClickListener(view1 -> {
            //lay du lieu tu edittext
            String tenSach = edtTenSach.getText().toString().trim();
            Sach sachUpdate = new Sach(sach.getMasach(), tenSach);
            boolean check = sachDAO.suaSach(sachUpdate);
            if (check) {
                Toast.makeText(context, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                loadData();
                alertdialog.dismiss();
            } else {
                Toast.makeText(context, "Cap nhat that bai", Toast.LENGTH_SHORT).show();
            }
        });
        btnHuy.setOnClickListener(view2 -> alertdialog.dismiss());
    }

    private void loadData() {
        list.clear();
        list = sachDAO.getDSSach();
        notifyDataSetChanged();
    }
}
