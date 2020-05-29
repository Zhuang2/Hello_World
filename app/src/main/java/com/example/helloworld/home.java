package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.helloworld.databinding.ActivityHomeBinding;

public class home extends AppCompatActivity {

    private ActivityHomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent intent = getIntent();//获取传过来的Intent对象
        String phone = intent.getStringExtra("data_phone");//取出对应的值
        mBinding.userPhone.setText(phone);

        SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);
        String userName = sp.getString("name_"+phone,"0");
        String userSex = sp.getString("sex_"+phone,"0");
        String userSms = sp.getString("sms_"+phone,"0").equals("")?"接受":"拒绝";
        mBinding.userName.setText(userName);
        mBinding.userSex.setText(userSex);
        String temp = mBinding.userSms.getText().toString()+":"+userSms;//接受信息推送：接送/拒绝
        mBinding.userSms.setText(temp);
    }
}
