package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sellingmanagement.AdapterManagement.AdapterDebt;
import com.example.sellingmanagement.AdapterManagement.AdapterStatistic;
import com.example.sellingmanagement.Dataset.Debt;
import com.example.sellingmanagement.Dataset.Statistic;

import java.sql.SQLException;
import java.util.ArrayList;

public class StatisticManagement extends AppCompatActivity {
    // khơi tạo biến
    private ImageButton buttonBack;
    private TextView noData,sum,DATHANG,NHAPHANG;
    private ListView listView;
    private ArrayList<Statistic> arrayList;
    private AdapterStatistic adapterStatistic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic_management);
        Init(); // khởi tạo giá trị
        clickButtonBack(); // hàm xử lí sự kiện click Back
        setNoData();
        setClickChange(); // hàm xử lí khi chuyển xem báo cáo nhập hàng và đặt hàng
    }

    private void setClickChange() {
        DATHANG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // thay đổi màu của button khi click
                DATHANG.getBackground().setTint(getResources().getColor(R.color.white));
                NHAPHANG.getBackground().setTint(getResources().getColor(R.color.button));

                try {
                    arrayList = Statistic.getuserlistDATHANG(); // lấy dữ liệu đặt hàng
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                adapterStatistic = new AdapterStatistic(StatisticManagement.this,arrayList); // thay đổi dữ liệu hiển thị
                listView.setAdapter(adapterStatistic);
                setNoData();
                setDataSum(); // thay đổi giá trị tổng
            }
        });
        NHAPHANG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // thay đổi màu của button khi click
                DATHANG.getBackground().setTint(getResources().getColor(R.color.button));
                NHAPHANG.getBackground().setTint(getResources().getColor(R.color.white));
                try {
                    arrayList = Statistic.getuserlistNHAPHANG(); // lấy dữ liệu nhập hàng
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                adapterStatistic = new AdapterStatistic(StatisticManagement.this,arrayList);// thay đổi dữ liệu hiển thị
                listView.setAdapter(adapterStatistic);
                setNoData();
                setDataSum(); // thay đổi giá trị tổng
            }
        });
    }

    // hàm set hiển thị khi size của listview = 0
    private void setNoData() {
        if(arrayList.size() == 0){
            listView.setVisibility(View.GONE);
            noData.setVisibility(View.VISIBLE);
        }else{
            listView.setVisibility(View.VISIBLE);
            noData.setVisibility(View.GONE);
        }
    }
    private void changePage(){
        // code chuyển giao diện về màn hình main
        Intent intent = new Intent(StatisticManagement.this,MainActivity.class);
        startActivity(intent);
    }
    // hàm xử lí sự kiện click Back
    private void clickButtonBack() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage(); // hàm intent chuyển giao diện
            }
        });
    }
    // tính tổng số tiền
    private void setDataSum(){
        int index = 0;
        for(int i = 0;i<arrayList.size();++i){
            index += arrayList.get(i).getGIASP() * arrayList.get(i).getSOLUONG();
        }
        sum.setText(String.valueOf(index));
    }
    private void Init() {
        // ánh xạ View
        buttonBack = findViewById(R.id.statisticManagement_back);
        noData = findViewById(R.id.statisticManagement_noData);
        listView = findViewById(R.id.statisticManagement_listView);
        sum = findViewById(R.id.statisticManagement_sum);
        DATHANG = findViewById(R.id.statisticManagement_DATHANG);
        NHAPHANG = findViewById(R.id.statisticManagement_NHAPHANG);
        try {
            arrayList = Statistic.getuserlistDATHANG();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adapterStatistic = new AdapterStatistic(this,arrayList);
        listView.setAdapter(adapterStatistic);
        setDataSum();
    }
}