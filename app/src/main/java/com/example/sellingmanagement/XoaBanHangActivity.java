package com.example.sellingmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sellingmanagement.Dataset.SanPham;
import com.example.sellingmanagement.Dataset.SanPham;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;

public class XoaBanHangActivity extends AppCompatActivity {
    //khai báo id
    TextInputEditText edtMaBHx;
    Button btnXoaBHx;
    ImageButton btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_xoa_ban_hang);
        //ánh xạ id
        edtMaBHx = findViewById(R.id.edtMaBHx);
        btnXoaBHx = findViewById(R.id.btnXoaBHx);
        btnback = findViewById(R.id.btnback);
        onClickChangePage(); // gọi tới hàm onlcickchangepage
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    // xử lý click btn xóa bán hàng
    private void onClickChangePage() {
        btnXoaBHx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maBH = edtMaBHx.getText().toString();
                try {
                    //gọi tới hàm deleteSP trong class SP
                    SanPham.deleteSP(maBH);
                }
                catch (SQLException e){
                    throw new RuntimeException(e);
                }
                finish();
            }
        });
    }
}