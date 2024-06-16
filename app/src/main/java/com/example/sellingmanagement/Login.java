package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.sellingmanagement.Datamanagement.Logins;

import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;

public class Login extends AppCompatActivity {
    //     khai bao id
    private TextInputEditText login_user,login_password; // khai bao id user va password

    private Button btnlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Init(); // gọi hàm khai báo ánh xạ id
        onClickChangePage(); // gọi hàm chuyển giao diện
    }
    private void onClickChangePage() {
        //xử lý click cho buttton login
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = login_user.getText().toString(); // gắn biến user để lấy dữ liệu từ text user
                String passwords = login_password.getText().toString(); // gắn biến passwords để lấy dữ liệu từ text password
                Logins login = new Logins(); // tạo 1 login mới
                try {
                    login = login.getuserlist(user,passwords);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if(user.length()==0 || passwords.length()==0){ // kiểm tra form đã nhập hay chưa
                    Toast.makeText(Login.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();// kiểm tra xem user và pass của người dùng nhập có đúng với csdl k

                }else if(login.getUser().equals(user) && login.getPass().equals(passwords)){ // kiểm tra xem dữ liệu nhập có đúng với csdl k?
                    Intent intentlog = new Intent(Login.this, GiaoDienQuanLyCungUngActivity.class); // tạo intent để chuyển qua giao diện bạn đọc
                    startActivity(intentlog); // bắt đầu chuyển giao diện
                    Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login.this, "Tài khoản mật khẩu không chính xác", Toast.LENGTH_SHORT).show(); // nếu người dùng nhập k đúng báo tk mk k chính xác
                }
            }
        });
    }

    private void Init() {
        login_user = findViewById(R.id.login_user); // anh xa id cho user
        login_password = findViewById(R.id.login_password); // anh xa id cho password
        btnlogin = findViewById(R.id.btnlogin); // anh xa id cho button dang nhap
    }
}


