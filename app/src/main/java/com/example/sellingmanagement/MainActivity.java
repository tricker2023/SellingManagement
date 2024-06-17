package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // khơi tạo biến
    private Button addDebt,debtManagement,statisticManagement,logout;
<<<<<<< HEAD

    Button button_QLyNv,button_QLyChamCong,button_QlyTinhLuong,button_DangXuat;
=======
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
>>>>>>> origin/M2

=======
    private Button btnthemsuaHTtt,btnxoaHTtt,btnthemsuaBHtt,btnxoaBHtt;
>>>>>>> origin/M3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
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
<<<<<<< HEAD
        //hàm xử lý sự kiện khi click vào nút đăng xuất
        button_DangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Login.class);
                startActivity(myintent);
                Toast.makeText(MainActivity.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            }
        });

        //hàm xử lý sự kiện khi click vào nút quản lý nhân viên
        button_QLyNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, TrangChuQuanLyNhanVien.class);
                startActivity(myintent);
            }
        });
        //hàm xử lý sự kiện khi click vào nút quản lý chấm công
        button_QLyChamCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, TrangChuQuanLyChamCong.class);
                startActivity(myintent);
            }
        });

        //hàm xử lý sự kiện khi click vào nút quản lý tính lương
        button_QlyTinhLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, TrangChuQuanLyTinhLuong.class);
                startActivity(myintent);
=======
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
>>>>>>> origin/M3
            }
        });
    }

    private void Init() {
        // ánh xạ View
        addDebt = findViewById(R.id.main_addDebt);
        debtManagement = findViewById(R.id.main_managementDebt);
        statisticManagement = findViewById(R.id.main_managementStatistic);
        logout = findViewById(R.id.main_logOut);
<<<<<<< HEAD
        button_QLyNv = findViewById(R.id.button_QLyNv);
        button_QLyChamCong = findViewById(R.id.button_QLyChamCong);
        button_QlyTinhLuong = findViewById(R.id.button_QlyTinhLuong);
        button_DangXuat = findViewById(R.id.button_DangXuat);
=======
>>>>>>> origin/M2
=======
        btnthemsuaHTtt = findViewById(R.id.btnthemsuaHTtt);
        btnxoaHTtt = findViewById(R.id.btnxoaHTtt);
        btnthemsuaBHtt = findViewById(R.id.btnthemsuaBHtt);
        btnxoaBHtt = findViewById(R.id.btnxoaBHtt);
>>>>>>> origin/M3
    }
}