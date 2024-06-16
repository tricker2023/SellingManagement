package com.example.sellingmanagement.Datamanagement;

import android.util.Log;

import com.example.sellingmanagement.SQLServerManagement.SQLServerHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class NhapHang {
    String idNhapHang;
    String idNhanVien;
    String idSanPham;
    Integer soLuong;
    Date ngayNhap;


    // tạo kết nối với csdl vào bảng DATGIABAN
    public static void insertNhapHang(String idNhapHang, String idNhanVien, String idSanPham, Integer soLuong, String ngayNhap) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever(); //Kết nối với SQL server
        Statement statement = connection.createStatement(); // Tạo đối tượng Statement
        // câu lệnh thêm dữ liệu vào sql server
        String sql = "INSERT INTO NHAPHANG(IDNHAPHANG,MaNV,IDSANPHAM,SOLUONG,NGAYNHAP) VALUES ('"+idNhapHang+"','"+idNhanVien+"','"+idSanPham+"',"+soLuong+",'"+ngayNhap+"')";
        statement.execute(sql); // thuc thi cau lenh
        statement.close(); // Dong doi tuong Statement
        connection.close(); // Dong ket noi
    }

    public static void updateNhapHang(String idNhapHang, String idNhanVien, String idSanPham, Integer soLuong, String ngayNhap) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever(); //Kết nối với SQL server
        Statement statement = connection.createStatement(); // Tạo đối tượng Statement
        // câu lệnh thêm dữ liệu vào sql server
        String sql = "UPDATE NHAPHANG SET MaNV ='"+idNhanVien+"',IDSANPHAM ='"+idSanPham+"',SOLUONG = "+soLuong+",NGAYNHAP='"+ngayNhap+"'WHERE IDNHAPHANG ='"+idNhapHang+"'";
        Log.e("DATA",sql);
        statement.execute(sql); // thuc thi cau lenh
        statement.close(); // Dong doi tuong Statement
        connection.close(); // Dong ket noi
    }








    public NhapHang(String idDatGiaBan, String idNhanVien, String idSanPham, Integer soLuong, Date ngayNhap) {
        this.idNhapHang = idDatGiaBan;
        this.idNhanVien = idNhanVien;
        this.idSanPham = idSanPham;

        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
    }

    public String getIdDatGiaBan() {
        return idNhapHang;
    }

    public void setIdDatGiaBan(String idDatGiaBan) {
        this.idNhapHang = idDatGiaBan;
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


    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
