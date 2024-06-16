package com.example.sellingmanagement.Datamanagement;

import com.example.sellingmanagement.SQLServerManagement.SQLServerHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DatHang {
    String idDatHang;
    String idNhanVien;
    String idSanPham;
    String daiLyCungCap;
    Integer soLuong;
    Double donGia;
    Date ngayDatHang;

    public static void insertDatHang(String idDatHang, String idNhanVien, String idSanPham, String daiLyCungCap, Integer soLuong, Double donGia, String ngayDatHang) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever(); //Kết nối với SQL server
        Statement statement = connection.createStatement(); // Tạo đối tượng Statement
        // câu lệnh thêm dữ liệu vào sql server
        String sql = "INSERT INTO QLDH(IDDATHANG,MaNV,IDSANPHAM,DAILYCUNGCAP,SOLUONG,DONGIA,NGAYDH) VALUES ('"+idDatHang+"','"+idNhanVien+"','"+idSanPham+"','"+daiLyCungCap+"',"+soLuong+",'"+donGia+"','"+ngayDatHang+"')";
        statement.execute(sql); // thuc thi cau lenh
        statement.close(); // Dong doi tuong Statement
        connection.close(); // Dong ket noi
    }
    public static void updateDatHang(String idDatHang, String idNhanVien, String idSanPham, String daiLyCungCap, Integer soLuong, Double donGia, String ngayDatHang) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever(); //Kết nối với SQL server
        Statement statement = connection.createStatement(); // Tạo đối tượng Statement
        // câu lệnh thêm dữ liệu vào sql server
        String sql = "UPDATE QLDH SET MaNV = '"+idNhanVien+"', IDSANPHAM = '"+idSanPham+"', DAILYCUNGCAP = '"+daiLyCungCap+"', SOLUONG = "+soLuong+", DONGIA = '"+donGia+"',NGAYDH ='"+ngayDatHang+"'"
                + "WHERE IDDATHANG ='"+idDatHang+"'";
        statement.execute(sql); // thuc thi cau lenh
        statement.close(); // Dong doi tuong Statement
        connection.close(); // Dong ket noi
    }
    public static void deleteDatHang(String idDatHang) throws SQLException {
        Connection connection = SQLServerHelper.connectionSQLSever(); //Kết nối với SQL server
        Statement statement = connection.createStatement(); // Tạo đối tượng Statement
        // câu lệnh thêm dữ liệu vào sql server
        String sql = "DELETE FROM QLDH WHERE IDDATHANG = '"+idDatHang+"'";
        statement.execute(sql); // thuc thi cau lenh
        statement.close(); // Dong doi tuong Statement
        connection.close(); // Dong ket noi
    }


    public DatHang(String idDatHang, String idNhanVien, String idSanPham, String daiLyCungCap, Integer soLuong, Double donGia, Date ngayDatHang) {
        this.idDatHang = idDatHang;
        this.idNhanVien = idNhanVien;
        this.idSanPham = idSanPham;
        this.daiLyCungCap = daiLyCungCap;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.ngayDatHang = ngayDatHang;
    }

    public String getIdDatHang() {
        return idDatHang;
    }

    public void setIdDatHang(String idDatHang) {
        this.idDatHang = idDatHang;
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


    public String getDaiLyCungCap() {
        return daiLyCungCap;
    }

    public void setDaiLyCungCap(String daiLyCungCap) {
        this.daiLyCungCap = daiLyCungCap;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }
}
