package com.example.sellingmanagement.Dataset;

import android.util.Log;

import com.example.sellingmanagement.SQLServerManagement.SQLServerHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class Statistic {
    private String ID;
    private String IDSANPHAM;
    private String TENSP;
    private int SOLUONG;
    private int GIASP;
    private Date DATE;

    public Statistic(String ID, String IDSANPHAM, String TENSP, int SOLUONG, int GIASP, Date DATE) {
        this.ID = ID;
        this.IDSANPHAM = IDSANPHAM;
        this.TENSP = TENSP;
        this.SOLUONG = SOLUONG;
        this.GIASP = GIASP;
        this.DATE = DATE;
    }

    // hàm lấy dữ liệu từ nhập hàng
    public static ArrayList<Statistic> getuserlistNHAPHANG() throws SQLException { // Hàm lấy dữ liệu
        Connection connection = SQLServerHelper.connectionSQLSever(); // Kết nối với SQL server
        ArrayList<Statistic> list = new ArrayList<>(); // Tạo list để lưu dữ liệu
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select IDNHAPHANG,NHAPHANG.IDSANPHAM,TENSP,NHAPHANG.SOLUONG,GIASP,NGAYNHAP from NHAPHANG inner join SANPHAM\n" +
                "on NHAPHANG.IDSANPHAM = SANPHAM.IDSANPHAM"; // Câu lênh truy vấn SQL Server lấy ra dữ liệu trong bảng
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new Statistic(
                    rs.getString(1).trim(), // Lấy dữ liệu
                    rs.getString(2).trim(),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getDate(6)));// Đọc dữ liệu từ ResultSet
        }
        statement.close(); // Đóng đối tương statement
        connection.close();// Đóng kết nối
        return list; // Trả về list
    }

    // hàm lấy dữ liệu từ nhập hàng
    public static ArrayList<Statistic> getuserlistDATHANG() throws SQLException { // Hàm lấy dữ liệu
        Connection connection = SQLServerHelper.connectionSQLSever(); // Kết nối với SQL server
        ArrayList<Statistic> list = new ArrayList<>(); // Tạo list để lưu dữ liệu
        Statement statement = connection.createStatement();// Tạo đối tượng Statement.
        String sql = "select IDDATHANG,QLDH.IDSANPHAM,TENSP,QLDH.SOLUONG,GIASP,NGAYDH from QLDH inner join SANPHAM\n" +
                "on QLDH.IDSANPHAM = SANPHAM.IDSANPHAM"; // Câu lênh truy vấn SQL Server lấy ra dữ liệu trong bảng
        // Thực thi câu lệnh SQL trả về đối tượng ResultSet. // Mọi kết quả trả về sẽ được lưu trong ResultSet
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            list.add(new Statistic(
                    rs.getString(1).trim(), // Lấy dữ liệu
                    rs.getString(2).trim(),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getDate(6)));// Đọc dữ liệu từ ResultSet
        }
        statement.close(); // Đóng đối tương statement
        connection.close();// Đóng kết nối
        return list; // Trả về list
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getIDSANPHAM() {
        return IDSANPHAM;
    }

    public void setIDSANPHAM(String IDSANPHAM) {
        this.IDSANPHAM = IDSANPHAM;
    }

    public String getTENSP() {
        return TENSP;
    }

    public void setTENSP(String TENSP) {
        this.TENSP = TENSP;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public int getGIASP() {
        return GIASP;
    }

    public void setGIASP(int GIASP) {
        this.GIASP = GIASP;
    }

    public Date getDATE() {
        return DATE;
    }

    public void setDATE(Date DATE) {
        this.DATE = DATE;
    }
}
