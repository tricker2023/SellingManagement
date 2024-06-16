package com.example.sellingmanagement.AdapterManagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sellingmanagement.Dataset.Statistic;
import com.example.sellingmanagement.R;

import java.sql.SQLException;
import java.util.ArrayList;

public class AdapterStatistic extends BaseAdapter {
    Context context;
    ArrayList<Statistic> arrayList;
    LayoutInflater layoutInflater;
    public AdapterStatistic(Context context,ArrayList<Statistic> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }


    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.item_statistic,null); // ánh xạ layout

        TextView TENSP = convertView.findViewById(R.id.itemStatistic_TENSP);
        TextView SOLUONG = convertView.findViewById(R.id.itemStatistic_SOLUONG);
        TextView GIASP = convertView.findViewById(R.id.itemStatistic_GIASP);
        TextView NGAYNHAP = convertView.findViewById(R.id.itemStatistic_NGAYNHAP);

        Statistic statistic = arrayList.get(position); // lấy dữ liệu trong danh sách

        if(statistic != null){
            // set các giá tri cho view
            TENSP.setText(statistic.getID());
            SOLUONG.setText(String.valueOf(statistic.getSOLUONG()));
            GIASP.setText(String.valueOf(statistic.getGIASP()));
            NGAYNHAP.setText(String.valueOf(statistic.getDATE()));
        }

        return convertView;
    }
}
