package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sellingmanagement.Datamanagement.NhapHang;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class QuanLyNhapHangActivity extends AppCompatActivity {
    private ImageButton btnback;
    private TextInputEditText idnhaphang,idnhanviennh,idsanphamnh,edtsoluongnh;
    private TextView datenhaphang;
    private Button btnthemnh,btnsuanh;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_nhap_hang);
        Init();
        clickOnChangePage1();
        clickOnChangePage2();
        setClickDateTime();
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setClickDateTime() {
        datenhaphang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDate(calendar,simpleDateFormat);
            }
        });
    }
    private void selectedDate(Calendar calendar,SimpleDateFormat simpleDateFormat){
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);

                datenhaphang.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year,month,day);
        datePickerDialog.show();
    }

    private void clickOnChangePage2() {
        btnsuanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNhapHang = idnhaphang.getText().toString();
                String maNhanVien = idnhanviennh.getText().toString();
                String maSanPham = idsanphamnh.getText().toString();
                int soLuong = Integer.parseInt(edtsoluongnh.getText().toString());
                String ngayNhap = datenhaphang.getText().toString();
                try {
                    NhapHang.updateNhapHang(maNhapHang,maNhanVien,maSanPham,soLuong,ngayNhap);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(maNhapHang.length()>0 && maNhanVien.length()>0 && maSanPham.length()>0 && soLuong>0 &&  datenhaphang.length() != 0){
                    Toast.makeText(QuanLyNhapHangActivity.this, "Cập nhật hàng nhập thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(QuanLyNhapHangActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clickOnChangePage1() {
        btnthemnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNhapHang = idnhaphang.getText().toString();
                String maNhanVien = idnhanviennh.getText().toString();
                String maSanPham = idsanphamnh.getText().toString();
                int soLuong = Integer.parseInt(edtsoluongnh.getText().toString());
                String ngayNhap = datenhaphang.getText().toString();
                try {
                    NhapHang.insertNhapHang(maNhapHang,maNhanVien,maSanPham,soLuong,ngayNhap);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(maNhapHang.length()>0 && maNhanVien.length()>0 && maSanPham.length()>0 && soLuong>0 &&  datenhaphang.length() != 0){
                    Toast.makeText(QuanLyNhapHangActivity.this, "Thêm hàng nhập thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(QuanLyNhapHangActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Init() {

        btnback = findViewById(R.id.btnback);
        idnhaphang = findViewById(R.id.idnhaphang);
        idnhanviennh = findViewById(R.id.idnhanviennh);
        idsanphamnh = findViewById(R.id.idsanphamnh);
        edtsoluongnh = findViewById(R.id.edtsoluongnh);
        datenhaphang = findViewById(R.id.datenhaphang);
        btnsuanh = findViewById(R.id.btnsuanh);
        btnthemnh = findViewById(R.id.btnthemnh);

    }
}