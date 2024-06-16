package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sellingmanagement.SQLServerManagement.SQLServerHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.BreakIterator;

public class XemDatHangActivity extends AppCompatActivity {
    ImageButton btn_timKiemNV;
    TextView timkiemDH,xemMaDH,xemMaNV,xemMaSP,xemTenSP,xemDaiLy,xemSoLuong,xemDonGia,xemNgayDH;
    Button button_backXemNv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_dat_hang);
        Init();
        button_backXemNv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//hàm xử lý sự kiện khi click vào nút tìm kiếm
        btn_timKiemNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kết nối csdl
                Connection connection = SQLServerHelper.connectionSQLSever();
                String maDH = timkiemDH.getText().toString();
                try {
                    if (connection != null) {
                        BreakIterator id;
                        //tạo đối tượng statement
                        Statement statement = connection.createStatement();
                        //tạo câu lệnh xem thông tin trong bảng PhieuMuon
                        String sqlXem = "SELECT IDDATHANG,MaNV,SANPHAM.IDSANPHAM,SANPHAM.TENSP,DAILYCUNGCAP,SOLUONG,DONGIA,NGAYDH" +
                                " FROM QLDH INNER JOIN SANPHAM" +
                                " ON SANPHAM.IDSANPHAM = QLDH.IDSANPHAM" +
                                " WHERE IDDATHANG = '" +maDH+ "'";
                        Log.e("DATA",sqlXem);
                        statement.executeQuery(sqlXem);
                        // Thực thi câu lệnh SQL và lấy kết quả
                        ResultSet rs = statement.executeQuery(sqlXem);
                        while (rs.next()) {
                            //ánh xạ các thông tin vưà truy xuất từ câu lệnh sql lên id của các thành phần giao diện tương ứng
                            xemMaDH.setText(rs.getString(1));
                            xemMaNV.setText(rs.getString(2));
                            xemMaSP.setText(rs.getString(3));
                            xemTenSP.setText(rs.getString(4));
                            xemDaiLy.setText(rs.getString(5));
                            xemSoLuong.setText(rs.getString(6));
                            xemDonGia.setText(rs.getString(7));
                            xemNgayDH.setText(rs.getString(8));

                        }
                        statement.close();
                        connection.close();
                    }
                } catch (SQLException exception) {
                    Log.e("Error", exception.getMessage()); // Changed "Errol" to "Error" for consistency
                }
            }
        });
    }

    private void Init() {
        //ánh xạ id
        btn_timKiemNV = findViewById(R.id.btn_timKiemNV);
        timkiemDH = findViewById(R.id.timkiemDH);
        xemMaNV = findViewById(R.id.xemMaNV);
        xemMaDH = findViewById(R.id.xemMaDH);
        xemMaSP = findViewById(R.id.xemMaSP);
        xemTenSP = findViewById(R.id.xemTenSP);
        xemDaiLy = findViewById(R.id.xemDaiLy);
        xemSoLuong = findViewById(R.id.xemSoLuong);
        xemDonGia = findViewById(R.id.xemDonGia);
        xemNgayDH = findViewById(R.id.xemNgayDH);
        button_backXemNv = findViewById(R.id.button_backXemNv);
    }
}