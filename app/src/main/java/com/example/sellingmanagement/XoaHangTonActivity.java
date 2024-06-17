package com.example.sellingmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sellingmanagement.Dataset.HangTonKho;
import com.example.sellingmanagement.Dataset.HangTonKho;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;

public class XoaHangTonActivity extends AppCompatActivity {
    //khai báo id
    TextInputEditText edtMaHTx;
    Button btnXoaHT;
    ImageButton btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xoa_hang_ton);
        // ánh xạ id
        edtMaHTx = findViewById(R.id.edtMaHTx);
        btnXoaHT = findViewById(R.id.btnXoaHT);
        btnback = findViewById(R.id.btnback);
        onClickChangePage(); // gọi tới hàm onClickChangePage
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void onClickChangePage() {
        // xử lý click btn xóa hang ton
        btnXoaHT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maHT = edtMaHTx.getText().toString();
                try {
                    HangTonKho.deleteHTK(maHT);
                }
                catch (SQLException e){
                    throw new RuntimeException(e);
                }
                finish();
            }
        });
    }
}