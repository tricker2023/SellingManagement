package com.example.sellingmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sellingmanagement.Dataset.Debt;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddDebt extends AppCompatActivity {
    // khai báo biển
    private boolean initData;
    private ImageButton buttonBack;
    private TextInputEditText IdDebt,Account,Moneys;
    private Button buttonInsertDebt;
    private TextView Credit,Debit,textHeading,Dates;
    private String idDebt,type;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_debt);
        Init(); // hàm khởi tạo giá trị
        clickButtonBack(); // hàm xử lí sự kiện click Back
        clickButtonInsertDebt(); // hàm xử lí xự kiện click insert Debt
        clickCreditAndDebit(); // hàm xử lí sự kiện khi nhấn 1 trong 2 nút
        clickDateChange(); // hàm xử lí thay đổi thời gian
    }

    private void clickDateChange() {
        Calendar calendar = Calendar.getInstance(); // lấy ra ngày giò trên thiết bị
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); // chuyẻn đổi dạng ngày tháng
        Dates.setText(simpleDateFormat.format(calendar.getTime()));
        Dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedDate(calendar,simpleDateFormat);
            } // hàm khởi tạo datepicker
        });
    }
    private void selectedDate(Calendar calendar,SimpleDateFormat simpleDateFormat){
        // khởi tạo giá trị ngày tháng
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                Dates.setText(simpleDateFormat.format(calendar.getTime())); // set giá trị cho textview
            }
        }, year,month,day);
        datePickerDialog.show();

    }

    private void clickCreditAndDebit() {
        Credit.setOnClickListener(new View.OnClickListener() { // sự kiện khi click vào Credit
            @Override
            public void onClick(View v) {
                type = "Khoản thu";
                Credit.setBackgroundColor(getResources().getColor(R.color.primary));
                Debit.setBackgroundColor(getResources().getColor(R.color.button));
            }
        });
        Debit.setOnClickListener(new View.OnClickListener() { // sự kiện khi click vào Debit
            @Override
            public void onClick(View v) {
                type = "Khoản chi";
                Credit.setBackgroundColor(getResources().getColor(R.color.button));
                Debit.setBackgroundColor(getResources().getColor(R.color.primary));
            }
        });
    }
    private String changDate(String dates){
        // Định dạng pattern đầu vào
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

        // Định dạng pattern đầu ra
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

        // Chuyển đổi chuỗi sang Date
        Date date = null;
        try {
            date = sdf1.parse(dates);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String formattedString = sdf2.format(date);
        return formattedString;
    }

    // hàm xử lí xự kiện click insert Debt
    private void clickButtonInsertDebt() {
        // vào sửa data trong sql
        if(initData){
            buttonInsertDebt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // lấy dữ liệu từ ô nhập
                    String account = Account.getText().toString();
                    String moneys = Moneys.getText().toString();
                    String dates = Dates.getText().toString();
                    String formattedString = changDate(dates);

                    // kiểm tra xem các ô nhập liệu có rỗng
                    if (account.isEmpty() || moneys.isEmpty()){
                        Toast.makeText(AddDebt.this, "Bạn chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }else{
                        try {
                            Debt.updateList(idDebt,account,type,moneys,formattedString); // update dữ liệu
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        Toast.makeText(AddDebt.this, "Cập nhật thông tin thành công", Toast.LENGTH_SHORT).show(); // thông báo
                        changePage(); // hàm intent chuyển giao diện
                    }
                }
            });
        }else{ // ínert data trong sql
            buttonInsertDebt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // lấy dữ liệu từ ô nhập
                    String idDebts = IdDebt.getText().toString();
                    String id = sharedPreferences.getString("ID","not");
                    String account = Account.getText().toString();
                    String moneys = Moneys.getText().toString();
                    String dates = Dates.getText().toString();
                    String formattedString = changDate(dates);
                    // kiểm tra xem các ô nhập liệu có rỗng
                    if (idDebts.isEmpty() || account.isEmpty() || moneys.isEmpty()){

                        Toast.makeText(AddDebt.this, "Bạn chưa nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    }else{
                        try {
                            Debt.insertList(idDebts,id,account,type,moneys,formattedString); // insert đữ liệu
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        Toast.makeText(AddDebt.this, "Lưu thông tin thành công", Toast.LENGTH_SHORT).show(); // thông báo
                        changePage(); // hàm intent chuyển giao diện
                    }
                }
            });
        }
    }

    private void changePage(){
        // code chuyển giao diện về màn hình main
        Intent intent = new Intent(AddDebt.this,MainActivity.class);
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

    // hàm khởi tạo giá trị
    private void Init() {
        // ánh xạ View
        sharedPreferences = getSharedPreferences("loginData",MODE_PRIVATE);
        initData = getIntent().getBooleanExtra("initData",false);
        idDebt = getIntent().getStringExtra("IdDebt");
        type = "Nợ";
        textHeading = findViewById(R.id.addDebt_textHeading);
        buttonBack = findViewById(R.id.addDebt_back);
        IdDebt = findViewById(R.id.addDebt_idDebt);
        Account = findViewById(R.id.addDebt_account);
        Moneys = findViewById(R.id.addDebt_moneys);
        Dates = findViewById(R.id.addDebt_date);
        buttonInsertDebt = findViewById(R.id.addDebt_saveData);
        Credit = findViewById(R.id.addDebt_credit);
        Debit = findViewById(R.id.addDebt_debit);
        Credit.setBackgroundColor(getResources().getColor(R.color.primary));
        Debit.setBackgroundColor(getResources().getColor(R.color.button));
        if (initData){
            // chuyển đổi thành màn hình sửa công nợ
            textHeading.setText("Sửa công nợ");
            IdDebt.setText(idDebt);
            IdDebt.setEnabled(false);
        }
    }
}