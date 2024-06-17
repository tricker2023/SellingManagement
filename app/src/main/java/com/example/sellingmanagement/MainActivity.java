package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // khơi tạo biến
    private Button addDebt,debtManagement,statisticManagement,logout;
    private Button btnthemsuaHTtt,btnxoaHTtt,btnthemsuaBHtt,btnxoaBHtt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init(); // hàm khởi tạo giá trị
        clickButton(); // hàm xử lí sự kiện click
    }

    private void clickButton() {
        addDebt.setOnClickListener(new View.OnClickListener() { // chuyển màn hình sang thêm công nợ
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddDebt.class);
                startActivity(intent);
            }
        });

        debtManagement.setOnClickListener(new View.OnClickListener() { // chuyển màn hình sang xem công nợ
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DebtManagement.class);
                startActivity(intent);
            }
        });
        statisticManagement.setOnClickListener(new View.OnClickListener() { // chuyển màn hình sang xem thống kê
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatisticManagement.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() { // chuyển màn hình về đăng nhập
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
        btnthemsuaHTtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemHangTonActivity.class);
                startActivity(intent);
            }
        });

        //xu ly click btn xoa hang ton
        btnxoaHTtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XoaHangTonActivity.class);
                startActivity(intent);
            }
        });

        // xu ly click btn them sua ban hang
        btnthemsuaBHtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThemSuaBanHangActivity.class);
                startActivity(intent);
            }
        });
        btnxoaBHtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, XoaBanHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Init() {
        // ánh xạ View
        addDebt = findViewById(R.id.main_addDebt);
        debtManagement = findViewById(R.id.main_managementDebt);
        statisticManagement = findViewById(R.id.main_managementStatistic);
        logout = findViewById(R.id.main_logOut);
        btnthemsuaHTtt = findViewById(R.id.btnthemsuaHTtt);
        btnxoaHTtt = findViewById(R.id.btnxoaHTtt);
        btnthemsuaBHtt = findViewById(R.id.btnthemsuaBHtt);
        btnxoaBHtt = findViewById(R.id.btnxoaBHtt);
    }
}