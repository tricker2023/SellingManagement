package com.example.sellingmanagement.Datamanagement;

import com.example.sellingmanagement.SQLServerManagement.SQLServerHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Logins {
    String User;
    String pass;
    public Logins(){
        User = "";
        pass = "";
    };
    public Logins(String user, String pass) {
        User = user;
        this.pass = pass;
    }
 public static Logins getuserlist(String user,String pass) throws SQLException {
     Connection connection = SQLServerHelper.connectionSQLSever();
     Logins login = new Logins();
     Statement statement = connection.createStatement();// Tạo đối tượng Statement.
     // lấy ra iduser có giá trị là user vừa nhập vào và passuser có giá trị là pass vừa nhập
     String sql = "SELECT*FROM LOGINS WHERE ID ='" + user +"' AND PASSWORDS ='" + pass +"'";
     // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
     ResultSet rs = statement.executeQuery(sql);
     while (rs.next()) {
         login = new Logins(
                 rs.getString(1).trim(),
                 rs.getString(2).trim());// Đọc dữ liệu từ ResultSet

     }
     statement.close(); // tắt đối tượng statement
     connection.close();// Đóng kết nối
     return login;
 }
    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
