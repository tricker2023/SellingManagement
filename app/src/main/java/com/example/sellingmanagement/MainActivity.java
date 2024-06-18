package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // khơi tạo biến
    private Button addDebt,debtManagement,statisticManagement,logout;

    private Button button_QLyNv,button_QLyChamCong,button_QlyTinhLuong;
    private Button btnqldathang,btnqlnhaphang,btnqldatgiaban;
    private Button btnthemsuaHTtt,btnxoaHTtt,btnthemsuaBHtt,btnxoaBHtt;
    private SharedPreferences sharedPreferences;
    private String Positon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init(); // hàm khởi tạo giá trị
        clickButton(); // hàm xử lí sự kiện click
        getButtonPosition();
    }

    private void getButtonPosition() {
        if(Positon.equals("Bộ phân nhân sự")){
            button_QLyChamCong.setVisibility(View.VISIBLE);
            button_QLyNv.setVisibility(View.VISIBLE);
            button_QlyTinhLuong.setVisibility(View.VISIBLE);
        }else if(Positon.equals("Bộ phận cung ứng")){
            btnqldathang.setVisibility(View.VISIBLE);
            btnqlnhaphang.setVisibility(View.VISIBLE);
            btnqldatgiaban.setVisibility(View.VISIBLE);
        }else if(Positon.equals("Bộ phận quản lí bán hàng")){
            btnthemsuaHTtt.setVisibility(View.VISIBLE);
            btnxoaHTtt.setVisibility(View.VISIBLE);
            btnthemsuaBHtt.setVisibility(View.VISIBLE);
            btnxoaBHtt.setVisibility(View.VISIBLE);
        }else{
            addDebt.setVisibility(View.VISIBLE);
            debtManagement.setVisibility(View.VISIBLE);
            statisticManagement.setVisibility(View.VISIBLE);
        }
    }

    private void Init() {
        // ánh xạ View
        sharedPreferences = getSharedPreferences("loginData",MODE_PRIVATE);
        Positon = sharedPreferences.getString("Position","");

        addDebt = findViewById(R.id.main_addDebt);
        debtManagement = findViewById(R.id.main_managementDebt);
        statisticManagement = findViewById(R.id.main_managementStatistic);

        logout = findViewById(R.id.main_logOut);
        button_QLyNv = findViewById(R.id.button_QLyNv);
        button_QLyChamCong = findViewById(R.id.button_QLyChamCong);
        button_QlyTinhLuong = findViewById(R.id.button_QlyTinhLuong);

        btnqldathang = findViewById(R.id.btnqldathang);
        btnqlnhaphang = findViewById(R.id.btnqlnhaphang);
        btnqldatgiaban = findViewById(R.id.btnqldatgiaban);

        btnthemsuaHTtt = findViewById(R.id.btnthemsuaHTtt);
        btnxoaHTtt = findViewById(R.id.btnxoaHTtt);
        btnthemsuaBHtt = findViewById(R.id.btnthemsuaBHtt);
        btnxoaBHtt = findViewById(R.id.btnxoaBHtt);
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

            }
        });
        btnqldathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdh = new Intent(MainActivity.this,QuanLyDatHangActivity.class); // khai báo intent chuyển giao diện
                startActivity(intentdh); // bắt đầu chuyển sang giao diện đặt hàng
            }
        });
//        // xử lý click cho button nhập hàng
        btnqlnhaphang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnh = new Intent(MainActivity.this,QuanLyNhapHangActivity.class);
                startActivity(intentnh);
            }
        });
//        // xử lý click cho button đặt giá bán
        btnqldatgiaban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdgb = new Intent(MainActivity.this,QuanLyDatGiaBanActivity.class); // khai báo intent chuyển giao diện
                startActivity(intentdgb); // bắt đầu chuyển giao diện đặt giá bán
            }
        });
    }

}