package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sellingmanagement.Datamanagement.DatGiaBan;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;

public class QuanLyDatGiaBanActivity extends AppCompatActivity {
    private ImageButton btnback;
    private TextInputEditText iddatgiaban,idnhanviendgb,idsanphamdgb,edtthue,edtuudai;
    private Button btnthemdgb,btnsuadgb,btnxoadgb,btntimkiemdgb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_dat_gia_ban);
        Init();
        clickTHEMDGB();
        clickXOADGB();
        clickSUADGB();
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void clickSUADGB() {
        btnsuadgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maDatGiaBan = iddatgiaban.getText().toString();
                String maNhanVien = idnhanviendgb.getText().toString();
                String maSanPham = idsanphamdgb.getText().toString();
                double thue = Double.parseDouble(edtthue.getText().toString());
                String uuDai = edtuudai.getText().toString();
                try {
                    DatGiaBan.updateDatGiaBan(maDatGiaBan,maNhanVien,maSanPham,thue,uuDai);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(maDatGiaBan.length()>0 && maNhanVien.length()>0 && maSanPham.length()>0 && thue>0 && uuDai.length() != 0){
                    Toast.makeText(QuanLyDatGiaBanActivity.this, "Sửa giá bán thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(QuanLyDatGiaBanActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void clickTHEMDGB() {
        btnthemdgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maDatGiaBan = iddatgiaban.getText().toString();
                String maNhanVien = idnhanviendgb.getText().toString();
                String maSanPham = idsanphamdgb.getText().toString();
                double thue = Double.parseDouble(edtthue.getText().toString());
                String uuDai = edtuudai.getText().toString();
                try {
                    DatGiaBan.insertDatGiaBan(maDatGiaBan,maNhanVien,maSanPham,thue,uuDai);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(maDatGiaBan.length()>0 && maNhanVien.length()>0 && maSanPham.length()>0 && thue>0 && uuDai.length() != 0){
                    Toast.makeText(QuanLyDatGiaBanActivity.this, "Thêm giá bán thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(QuanLyDatGiaBanActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void clickXOADGB() {
        btnxoadgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maDatGiaBan = iddatgiaban.getText().toString();
                try {
                    DatGiaBan.deleteDatGiaBan(maDatGiaBan);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                finish();
            }
        });
    }
    private void Init() {
        btnback = findViewById(R.id.btnback);
        iddatgiaban = findViewById(R.id.iddatgiaban);
        idnhanviendgb = findViewById(R.id.idnhanviendgb);
        idsanphamdgb = findViewById(R.id.idsanphamdgb);
        edtuudai = findViewById(R.id.edtuudai);
        edtthue = findViewById(R.id.edtthue);
        btnthemdgb = findViewById(R.id.btnthemdgb);
        btnsuadgb = findViewById(R.id.btnsuadgb);
        btnxoadgb = findViewById(R.id.btnxoadgb);
        btntimkiemdgb = findViewById(R.id.btntimkiemdgb);

    }
}