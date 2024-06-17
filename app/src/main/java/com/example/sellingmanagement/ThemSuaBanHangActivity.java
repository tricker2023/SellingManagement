package com.example.sellingmanagement;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sellingmanagement.Dataset.SanPham;
import com.example.sellingmanagement.Dataset.SanPham;
import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ThemSuaBanHangActivity extends AppCompatActivity {
    // khai báo id
    TextInputEditText edtMaSPts,edtTenSPts,edtSoluongSPts,edtGiaSPts;
    ImageButton btnback;
    Button btnthemSP,btnsuaSP;
    TextView edtNgaynhapSPts,edtHSDSPts;
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_sua_ban_hang);
        //gọi tới các hàm
        Init();
        onClickChangePage1();
        onClickChangePage2();
        setClickDateNNSP();
        setClickDateHSDSP();
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void onClickChangePage2() {
        // xử lý click btn sua sp
        btnsuaSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maSP = edtMaSPts.getText().toString();
                String tenSP = edtTenSPts.getText().toString();
                String soluongSP = edtSoluongSPts.getText().toString();
                String giaSP = edtGiaSPts.getText().toString();
                String HSDSP = edtHSDSPts.getText().toString();
                String ngaynhapSP = edtNgaynhapSPts.getText().toString();
                int check = ngaynhapSP.compareTo(HSDSP);
                if(check >0 ){
                    Toast.makeText(ThemSuaBanHangActivity.this, "Sản phẩm hết hạn", Toast.LENGTH_SHORT).show();
                }
                // goi toi ham insert san pham
                try {
                    SanPham.updateSP(maSP,tenSP,soluongSP,HSDSP,ngaynhapSP,giaSP);
                }
                catch (SQLException e){
                    throw new RuntimeException(e);
                }
                finish();
            }
        });
    }

    private void onClickChangePage1() {
        //xử lý click btn thêm sp
        btnthemSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maSP = edtMaSPts.getText().toString();
                String tenSP = edtTenSPts.getText().toString();
                String soluongSP = edtSoluongSPts.getText().toString();
                String giaSP = edtGiaSPts.getText().toString();
                String HSDSP = edtHSDSPts.getText().toString();
                String ngaynhapSP = edtNgaynhapSPts.getText().toString();
                int check = ngaynhapSP.compareTo(HSDSP);
                if(check >0 ){
                    Toast.makeText(ThemSuaBanHangActivity.this, "Sản phẩm hết hạn", Toast.LENGTH_SHORT).show();
                }
                // goi toi ham insert sanpham
                try {
                    SanPham.insertSP(maSP,tenSP,soluongSP,ngaynhapSP,HSDSP,giaSP);
                }
                catch (SQLException e){
                    throw new RuntimeException(e);
                }
                finish();
            }
        });
    }

    private void Init() {
        // ánh xạ id
        edtMaSPts = findViewById(R.id.edtMaSPts);
        edtTenSPts = findViewById(R.id.edtTenSPts);
        edtSoluongSPts = findViewById(R.id.edtSoluongSPts);
        edtGiaSPts = findViewById(R.id.edtGiaSPts);
        edtNgaynhapSPts = findViewById(R.id.edtNgaynhapSPts);
        edtHSDSPts = findViewById(R.id.edtHSDSPts);
        btnthemSP = findViewById(R.id.btnthemSP);
        btnsuaSP = findViewById(R.id.btnsuaSP);
        btnback = findViewById(R.id.btnback);
    }
    //xử lý click textview ngày nhập sp
    private void setClickDateNNSP() {
        edtNgaynhapSPts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDateNNSP(calendar,simpleDateFormat);
            }
        });
    }
    private void selectedDateNNSP(Calendar calendar,SimpleDateFormat simpleDateFormat){
        int day = calendar.get(Calendar.DATE); // gắn biến day là biến được lấy dữ liệu từ date trong lịch
        int month = calendar.get(Calendar.MONTH); // gắn biến month là biến được lấy dữ liệu từ month trong lịch
        int year = calendar.get(Calendar.YEAR); // gắn biến year là biến được lấy dữ liệu từ year trong lịch
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                edtNgaynhapSPts.setText(simpleDateFormat.format(calendar.getTime())); // hiển thị các dữ liệu lên 1 dialog
            }
        }, year,month,day);
        datePickerDialog.show();
    }
    // xử lý click textview hsd sản phẩm
    private void setClickDateHSDSP() {

        edtHSDSPts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDateHSDSP(calendar,simpleDateFormat);
            }
        });
    }
    private void selectedDateHSDSP(Calendar calendar,SimpleDateFormat simpleDateFormat){
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                edtHSDSPts.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, year,month,day);
        datePickerDialog.show();
    }
}