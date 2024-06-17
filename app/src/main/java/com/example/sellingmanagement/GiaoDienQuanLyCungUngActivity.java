package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GiaoDienQuanLyCungUngActivity extends AppCompatActivity {
    // KHAI BÁO ID
    private Button btnqldathang,btnqlnhaphang,btnqldatgiaban,btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_quan_ly_cung_ung);
        Init();
        // xử lý click cho button đặt hàng
        btnqldathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdh = new Intent(GiaoDienQuanLyCungUngActivity.this,QuanLyDatHangActivity.class); // khai báo intent chuyển giao diện
                startActivity(intentdh); // bắt đầu chuyển sang giao diện đặt hàng
            }
        });
//        // xử lý click cho button nhập hàng
        btnqlnhaphang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnh = new Intent(GiaoDienQuanLyCungUngActivity.this,QuanLyNhapHangActivity.class);
                startActivity(intentnh);
            }
        });
//        // xử lý click cho button đặt giá bán
        btnqldatgiaban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdgb = new Intent(GiaoDienQuanLyCungUngActivity.this,QuanLyDatGiaBanActivity.class); // khai báo intent chuyển giao diện
                startActivity(intentdgb); // bắt đầu chuyển giao diện đặt giá bán
            }
        });
//        // xử lý click cho button đăng xuất
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();// quay về man hinh dang nhap
            }
        });
    }

    private void Init() {
        // ánh xạ id
        btnqldathang = findViewById(R.id.btnqldathang);
        btnqlnhaphang = findViewById(R.id.btnqlnhaphang);
        btnqldatgiaban = findViewById(R.id.btnqldatgiaban);
        btnlogout = findViewById(R.id.btnlogout);
    }
}