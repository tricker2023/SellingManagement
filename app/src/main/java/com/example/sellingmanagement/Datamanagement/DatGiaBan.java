package com.example.sellingmanagement.Datamanagement;

import android.util.Log;

import com.example.sellingmanagement.SQLServerManagement.SQLServerHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatGiaBan {
    String idDatGiaBan;
    String idNhanVien;
    String idSanPham;
    Double Thue;
    String uuDai;

    // tạo kết nối với csdl vào bảng DATGIABAN
    public static void insertDatGiaBan(String idDatGiaBan, String idNhanVien, String idSanPham, Double thue, String uuDai) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever(); //Kết nối với SQL server
        Statement statement = connection.createStatement(); // Tạo đối tượng Statement
        // câu lệnh thêm dữ liệu vào sql server
        String sql = "INSERT INTO DATGIABAN(IDDATGIABAN,MaNV,IDSANPHAM,THUE,UUDAI) VALUES ('"+idDatGiaBan+"','"+idNhanVien+"','"+idSanPham+"',"+thue+",'"+uuDai+"')";
        statement.execute(sql); // thuc thi cau lenh
        statement.close(); // Dong doi tuong Statement
        connection.close(); // Dong ket noi
    }
    public static void deleteDatGiaBan(String idDatGiaBan) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever(); //Kết nối với SQL server
        Statement statement = connection.createStatement(); // Tạo đối tượng Statement
        // câu lệnh thêm dữ liệu vào sql server
        String sql = "DELETE FROM DATGIABAN WHERE IDDATGIABAN = '"+idDatGiaBan+"'";
        Log.e("DATA",sql);
        statement.execute(sql); // thuc thi cau lenh
        statement.close(); // Dong doi tuong Statement
        connection.close(); // Dong ket noi
    }
    public static void updateDatGiaBan(String idDatGiaBan, String idNhanVien, String idSanPham, Double thue, String uuDai) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever();
        Statement statement = connection.createStatement();
        String sql = "UPDATE DATGIABAN SET MaNV = '"+idNhanVien+"', IDSANPHAM = '"+idSanPham+"', THUE = "+thue+", UUDAI = '"+uuDai+"'" +
                "WHERE IDDATGIABAN ='"+idDatGiaBan+"'";
        Log.e("DATA",sql);
        statement.execute(sql);
        statement.close();
        connection.close();
    }



    public DatGiaBan(String idDatGiaBan, String idNhanVien, String idSanPham, Double thue, String uuDai) {
        this.idDatGiaBan = idDatGiaBan;
        this.idNhanVien = idNhanVien;
        this.idSanPham = idSanPham;
        Thue = thue;
        this.uuDai = uuDai;
    }

    public String getIdDatGiaBan() {
        return idDatGiaBan;
    }

    public void setIdDatGiaBan(String idDatGiaBan) {
        this.idDatGiaBan = idDatGiaBan;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }


    public Double getThue() {
        return Thue;
    }

    public void setThue(Double thue) {
        Thue = thue;
    }

    public String getUuDai() {
        return uuDai;
    }

    public void setUuDai(String uuDai) {
        this.uuDai = uuDai;
    }
}
