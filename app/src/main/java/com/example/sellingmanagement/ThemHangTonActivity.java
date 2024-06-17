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

import com.example.sellingmanagement.Dataset.HangTonKho;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;

public class ThemHangTonActivity extends AppCompatActivity {
    //khai bao id
    TextInputEditText edtMaHTts, edtmaspHTts, edtSoluongHTts;
    ImageButton btnback;
    TextView edtNgaynhapHTts;
    Button btnthemHT, btnsuaHT; // khai bao btn
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_them_hang_ton);
        // gọi tới các hàm
        Init();
        onClickChangePage1();
        onClickChangePage2();
        setClickDateNN();
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void onClickChangePage2() {
        // xử lý click btn sửa hàng tồn
        btnsuaHT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maHT = edtMaHTts.getText().toString();
                String maSP = edtmaspHTts.getText().toString();
                String soluongHT = edtSoluongHTts.getText().toString();
                String ngaynhapHT = edtNgaynhapHTts.getText().toString();
                // gọi tới hàm update hang ton kho
                try {
                    HangTonKho.updateHTK(maHT,maSP,soluongHT,ngaynhapHT);
                }
                catch (SQLException e){
                    throw new RuntimeException(e);
                }
                finish();
            }
        });
    }

    private void onClickChangePage1() {
        //xu ly btn them hang ton
        btnthemHT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maHT = edtMaHTts.getText().toString();
                String maSP = edtmaspHTts.getText().toString();
                String soluongHT = edtSoluongHTts.getText().toString();
                String ngaynhapHT = edtNgaynhapHTts.getText().toString();
                // goi toi ham insert hang ton kho
                try {
                    HangTonKho.inserHTK(maHT,maSP,soluongHT,ngaynhapHT);
                }
                catch (SQLException e){
                    throw new RuntimeException(e);
                }
                finish();
            }
        });
    }

    private void Init() {
        // anh xa id them sua hang ton
        edtMaHTts = findViewById(R.id.edtMaHTts);
        edtmaspHTts = findViewById(R.id.edtmaspHTts);
        edtSoluongHTts= findViewById(R.id.edtSoluongHTts);
        edtNgaynhapHTts = findViewById(R.id.edtNgaynhapHTts);
        btnthemHT = findViewById(R.id.btnthemHT);
        btnsuaHT = findViewById(R.id.btnsuaHT);
        btnback = findViewById(R.id.btnback);
    }

    private void setClickDateNN() {

        edtNgaynhapHTts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDateNN(calendar,simpleDateFormat);
            }
        });
    }
    private void selectedDateNN(Calendar calendar,SimpleDateFormat simpleDateFormat){
        int day = calendar.get(Calendar.DATE); // gắn biến day là biến được lấy dữ liệu từ date trong lịch
        int month = calendar.get(Calendar.MONTH); // gắn biến month là biến được lấy dữ liệu từ month trong lịch
        int year = calendar.get(Calendar.YEAR); // gắn biến year là biến được lấy dữ liệu từ year trong lịch
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                edtNgaynhapHTts.setText(simpleDateFormat.format(calendar.getTime())); // hiển thị các dữ liệu lên 1 dialog
            }
        }, year,month,day);
        datePickerDialog.show();
    }
}