package com.example.sellingmanagement.Dataset;

import android.util.Log;

import com.example.sellingmanagement.SQLServerManagement.SQLServerHelper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class SanPham {
    private String IDSanPham;
    private String TenSP;
    private Integer SoLuongSP;
    private Date NgayNhapSP;
    private Date HSDHSP;
    private Integer GiaSP;

    // tạo kết nối với csdl vào bảng SANPHAM , tạo hàm thêm SP
    public static void insertSP(String IDSanPham, String TenSP, String SoLuongSP, String NgayNhapSP, String HSDHSP, String GiaSP) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever(); // tạo kết nối với sqlsever
        Statement statement = connection.createStatement(); // tạo đối tượng statement
        String sql = "INSERT INTO SANPHAM(IDSANPHAM,TENSP,SOLUONGSP,NGAYNHAPSP,HSDSANPHAM,GIASP) VALUES ('"+IDSanPham+"','"+TenSP+"','"+SoLuongSP+"','"+NgayNhapSP+"','"+HSDHSP+"','"+GiaSP+"')";
        Log.e("DATA",sql);
        statement.execute(sql); // thực thi câu lệnh
        statement.close(); // đóng đối tượng statement
        connection.close(); // đóng kết nối
    }
    // tạo kết nối với csdl vào bảng SANPHAM , tạo hàm sửa SP
    public static void updateSP(String IDSanPham, String TenSP, String SoLuongSP, String NgayNhapSP, String HSDHSP, String GiaSP) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever();// tạo kết nối với sqlsever
        Statement statement = connection.createStatement();// tạo đối tượng statement
        String sql = "UPDATE SANPHAM SET IDSANPHAM = '" +IDSanPham+ "',TENSP = '"+TenSP+"', SOLUONGSP = '"+SoLuongSP+"', NGAYNHAPSP = '"+NgayNhapSP+"', HSDSANPHAM = '"+HSDHSP+"', GIASP = '"+GiaSP+"'"+
                "WHERE IDSANPHAM = '"+IDSanPham+"'";
        Log.e("DATA",sql);
        statement.execute(sql);// thực thi câu lệnh
        statement.close();// đóng đối tượng statement
        connection.close();// đóng kết nối
    }
    // tạo kết nối với csdl vào bảng SANPHAM , tạo hàm xóa SP
    public static void deleteSP(String IDSanPham) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever();// tạo kết nối với sqlsever
        Statement statement = connection.createStatement();// tạo đối tượng statement
        String sql = "DELETE FROM SANPHAM WHERE IDSANPHAM = '"+IDSanPham+"'";
        Log.e("DATA",sql);
        statement.execute(sql);// thực thi câu lệnh
        statement.close();// đóng đối tượng statement
        connection.close();// đóng kết nối
    }
    // Tạo constructor
    public SanPham(String IDSanPham, String tenSP, Integer soLuongSP, Date ngayNhapSP, Date HSDHSP, Integer giaSP) {
        this.IDSanPham = IDSanPham;
        TenSP = tenSP;
        SoLuongSP = soLuongSP;
        NgayNhapSP = ngayNhapSP;
        this.HSDHSP = HSDHSP;
        GiaSP = giaSP;
    }

    public String getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(String IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public Integer getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(Integer soLuongSP) {
        SoLuongSP = soLuongSP;
    }

    public Date getNgayNhapSP() {
        return NgayNhapSP;
    }

    public void setNgayNhapSP(Date ngayNhapSP) {
        NgayNhapSP = ngayNhapSP;
    }

    public Date getHSDHSP() {
        return HSDHSP;
    }

    public void setHSDHSP(Date HSDHSP) {
        this.HSDHSP = HSDHSP;
    }

    public Integer getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(Integer giaSP) {
        GiaSP = giaSP;
    }
}
