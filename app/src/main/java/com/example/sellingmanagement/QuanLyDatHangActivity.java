package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sellingmanagement.Datamanagement.DatHang;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class QuanLyDatHangActivity extends AppCompatActivity {
    private ImageButton btnback;
    private TextInputEditText iddathang, idnhanviendh, idsanphamdh, edtdaily, edtsoluongdh, edtdongiadh;
    private TextView datedathang;
    private Button btnthemdh, btnsuadh, btnxoadh, btntimkiemdh;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_dat_hang);
        Init();
        setClickDateTime();
        clickThemDatHang();
        clickSuaDatHang();
        clickXoaDatHang();
        clickXemDatHang();
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Init() {

        btnback = findViewById(R.id.btnback);
        iddathang = findViewById(R.id.iddathang);
        idnhanviendh = findViewById(R.id.idnhanviendh);
        idsanphamdh = findViewById(R.id.idsanphamdh);
        edtdaily = findViewById(R.id.edtdaily);
        edtdongiadh = findViewById(R.id.edtdongiadh);
        edtsoluongdh = findViewById(R.id.edtsoluongdh);
        datedathang = findViewById(R.id.datedathang);
        btnthemdh = findViewById(R.id.btnthemdh);
        btnsuadh = findViewById(R.id.btnsuadh);
        btnxoadh = findViewById(R.id.btnxoadh);
        btntimkiemdh = findViewById(R.id.btntimkiemdh);
    }

    private void setClickDateTime() {
        datedathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDate(calendar, simpleDateFormat);
            }
        });
    }

    private void selectedDate(Calendar calendar, SimpleDateFormat simpleDateFormat) {
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);

                datedathang.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void clickXemDatHang() {
        btntimkiemdh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttk = new Intent(QuanLyDatHangActivity.this,XemDatHangActivity.class);
                startActivity(intenttk);
            }
        });
    }

    private void clickXoaDatHang() {
        btnxoadh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maDatHang = iddathang.getText().toString();
                try {
                    DatHang.deleteDatHang(maDatHang);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                finish();
            }
        });
    }

    private void clickSuaDatHang() {
        btnsuadh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maDatHang = iddathang.getText().toString();
                String maNhanVien = idnhanviendh.getText().toString();
                String maSanPham = idsanphamdh.getText().toString();
                int soLuong = Integer.parseInt(edtsoluongdh.getText().toString());
                String daiLy = edtdaily.getText().toString();
                Double donGiadh = Double.valueOf(edtdongiadh.getText().toString());
                String ngayDatHang = datedathang.getText().toString();
                try {
                    DatHang.updateDatHang(maDatHang, maNhanVien, maSanPham, daiLy, soLuong, donGiadh, ngayDatHang);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (maDatHang.length() > 0 && maNhanVien.length() > 0 && maSanPham.length() > 0  && soLuong > 0 && ngayDatHang.length() != 0) {
                    Toast.makeText(QuanLyDatHangActivity.this, "Sửa đặt hàng thành công", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(QuanLyDatHangActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clickThemDatHang() {
        btnthemdh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maDatHang = iddathang.getText().toString();
                String maNhanVien = idnhanviendh.getText().toString();
                String maSanPham = idsanphamdh.getText().toString();
                int soLuong = Integer.parseInt(edtsoluongdh.getText().toString());
                String daiLy = edtdaily.getText().toString();
                Double donGiadh = Double.valueOf(edtdongiadh.getText().toString());
                String ngayDatHang = datedathang.getText().toString();
                try {
                    DatHang.insertDatHang(maDatHang, maNhanVien, maSanPham, daiLy, soLuong, donGiadh, ngayDatHang);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (maDatHang.length() > 0 && maNhanVien.length() > 0 && maSanPham.length() > 0  && soLuong > 0 && datedathang.length() != 0) {
                    Toast.makeText(QuanLyDatHangActivity.this, "Thêm đặt hàng thành công", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(QuanLyDatHangActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}