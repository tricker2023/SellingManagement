package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sellingmanagement.Dataset.Logins;
=======
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.sellingmanagement.Datamanagement.Logins;

>>>>>>> origin/M2
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;

public class Login extends AppCompatActivity {
<<<<<<< HEAD
    // khỏi tạo biến
    private TextInputEditText ID,Passwords;
    private Button buttonLogin;
    private TextView buttonSignUp;
    private SharedPreferences sharedPreferences;

=======
    //     khai bao id
    private TextInputEditText login_user,login_password; // khai bao id user va password

    private Button btnlogin;
>>>>>>> origin/M2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< HEAD
        Init(); // hàm khởi tạo giá trị
        clickButtonLogin(); // hàm xử lí sự kiện click button Login
        clickButtonSignUp(); // hàm xử lí sự kiện click textview SignUp
    }

    // hàm xử lí sự kiện click textview SignUp
    private void clickButtonSignUp() {
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,SignUp.class); // code chuyển màn hình sang SignUp
                startActivity(intent);
            }
        });
    }

    // hàm xử lí sự kiện click button Login
    private void clickButtonLogin() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = ID.getText().toString(); // lấy dữ liệu ở ô tài khoản
                String passWords = Passwords.getText().toString(); // lấy dữ liệu ở ô mật khẩu

                Logins login = new Logins(); // tạo đối tượng login
                if(!id.isEmpty() && !passWords.isEmpty()) { // kiểm tra nhập đầy đủ thông tin chưa
                    try {
                        login = Logins.getuserlist(id, passWords); // gán login với dữ liệu lấy từ sql
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(id.isEmpty() || passWords.isEmpty()){ // kiểm tra chưa có thông tin nhập vào thì thông báo
                    Toast.makeText(Login.this, "Bạn chưa nhập tài khoản mật khẩu", Toast.LENGTH_SHORT).show();
                }
                else if(id.equals(login.getIDLOG()) && passWords.equals(login.getPASSWORDS())){ // nhập chính xác chuyển sang màn hình main
                    sharedPreferences.edit().putString("ID",id).commit();
                    sharedPreferences.edit().putString("Position",login.getCHUCVU()).commit();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                }else{ // kiểm tra ID với password là sai
                    Toast.makeText(Login.this, "Tài khoản mật khẩu của bạn chưa chính xác", Toast.LENGTH_SHORT).show();
=======
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
>>>>>>> origin/M2
                }
            }
        });
    }

<<<<<<< HEAD
    // hàm khởi tạo giá trị
    private void Init() {
        // ánh xạ View
        sharedPreferences = getSharedPreferences("loginData",MODE_PRIVATE);
        ID = findViewById(R.id.login_user);
        Passwords = findViewById(R.id.login_password);
        buttonLogin = findViewById(R.id.login_button);
        buttonSignUp = findViewById(R.id.login_signUp);
    }
}
=======
    private void Init() {
        login_user = findViewById(R.id.login_user); // anh xa id cho user
        login_password = findViewById(R.id.login_password); // anh xa id cho password
        btnlogin = findViewById(R.id.btnlogin); // anh xa id cho button dang nhap
    }
}


>>>>>>> origin/M2
