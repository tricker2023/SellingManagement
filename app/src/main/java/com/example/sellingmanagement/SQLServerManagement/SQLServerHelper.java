package com.example.sellingmanagement.SQLServerManagement;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerHelper {
<<<<<<< HEAD
<<<<<<< HEAD
    private static String sql = "jdbc:jtds:sqlserver://192.168.60.192:1433;databasename=QUANLYBH;user=sa;password=0522721509"; // dia chi ket noi
=======
    private static String sql = "jdbc:jtds:sqlserver://192.168.1.99:1433;databasename=QUANLYBH;user=CNPM;password=tranvietkhoa123"; // dia chi ket noi
>>>>>>> origin/M2
=======
    private static String sql = "jdbc:jtds:sqlserver://192.168.60.194:1433;databasename=QUANLYBH;user=CNPM;password=nguyenduc123"; // dia chi ket noi
>>>>>>> origin/M3
    public static Connection connectionSQLSever(){
        Connection connection = null;
        try {
            try {
                StrictMode.ThreadPolicy policy =
                        new StrictMode.ThreadPolicy.Builder().permitAll().build(); // lấy tất cả các quyền
                StrictMode.setThreadPolicy(policy); // thiết lập chính xác kết nối các quyền
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection(sql);
                Log.i("THONG BAO:","Ket noi thanh cong"); // thông báo kết nối thành công
            } catch (Exception e) {
                Log.e("THONGBAO","LOSS"); // thông báo kết nối không thành công
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
