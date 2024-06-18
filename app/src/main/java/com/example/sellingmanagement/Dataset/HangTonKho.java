package com.example.sellingmanagement.Dataset;

import android.util.Log;

import com.example.sellingmanagement.SQLServerManagement.SQLServerHelper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class HangTonKho {
    private String IDHangTK;
    private String IDSPHangTK;
    private Integer SoLuongHangTK;
    private Date NgayNhapHTK;
    //tạo constructor


    public String getIDHangTK() {
        return IDHangTK;
    }

    public void setIDHangTK(String IDHangTK) {
        this.IDHangTK = IDHangTK;
    }

    public String getIDSPHangTK() {
        return IDSPHangTK;
    }

    public void setIDSPHangTK(String IDSPHangTK) {
        this.IDSPHangTK = IDSPHangTK;
    }

    public Integer getSoLuongHangTK() {
        return SoLuongHangTK;
    }

    public void setSoLuongHangTK(Integer soLuongHangTK) {
        SoLuongHangTK = soLuongHangTK;
    }

    public Date getNgayNhapHTK() {
        return NgayNhapHTK;
    }

    public void setNgayNhapHTK(Date ngayNhapHTK) {
        NgayNhapHTK = ngayNhapHTK;
    }

    public HangTonKho(String IDHangTK, String IDSPHangTK, Integer soLuongHangTK, Date ngayNhapHTK) {
        this.IDHangTK = IDHangTK;
        this.IDSPHangTK = IDSPHangTK;
        SoLuongHangTK = soLuongHangTK;
        NgayNhapHTK = ngayNhapHTK;
    }

    // tạo kết nối với csdl vào bảng HANGTONKHO , tạo hàm thêm HTK
    public static void inserHTK(String IDHangTK, String IDSPHangTK, String SoLuongHangTK, String NgayNhapHTK) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever(); // tạo kết nối với sqlsever
        Statement statement = connection.createStatement(); // tạo đối tượng statement
        String sql = "INSERT INTO HANGTONKHO(IDHANGTON,IDSANPHAM,SOLUONGHANGTON,NGAYNHAPHANGTON) VALUES('" + IDHangTK + "','" + IDSPHangTK + "','" + SoLuongHangTK + "','" + NgayNhapHTK + "')";
        Log.e("DATA", sql);
        statement.execute(sql); // thực thi câu lệnh
        statement.close(); // đóng đối tượng statement
        connection.close(); // đóng kết nối
    }

    // tạo kết nối với csdl vào bảng HANGTONKHO , tạo hàm sửa HTK
    public static void updateHTK(String IDHangTK, String IDSPHangTK, String SoLuongHangTK, String NgayNhapHTK) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever();// tạo kết nối với sqlsever
        Statement statement = connection.createStatement();// tạo đối tượng statement
        String sql = "UPDATE HANGTONKHO SET IDSANPHAM = '" + IDSPHangTK + "', SOLUONGHANGTON = '" + SoLuongHangTK + "', NGAYNHAPHANGTON = '" + NgayNhapHTK + "'" +
                "WHERE IDHANGTON = '" + IDHangTK + "'";
        Log.e("DATA", sql);
        statement.execute(sql);// thực thi câu lệnh
        statement.close();// đóng đối tượng statement
        connection.close();// đóng kết nối
    }

    // tạo kết nối với csdl vào bảng HANGTONKHO , tạo hàm xóa HHTK
    public static void deleteHTK(String IDHangTK) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever();// tạo kết nối với sqlsever
        Statement statement = connection.createStatement();// tạo đối tượng statement
        String sql = "DELETE FROM HANGTONKHO WHERE IDHANGTON = '" + IDHangTK + "'";
        Log.e("DATA", sql);
        statement.execute(sql);// thực thi câu lệnh
        statement.close();// đóng đối tượng statement
        connection.close();// đóng kết nối
    }

}


