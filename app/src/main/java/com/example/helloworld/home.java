package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityHomeBinding;

public class home extends AppCompatActivity {

    private ActivityHomeBinding mBinding;
    private long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        //获取传过来的Intent对象
        Intent intent = getIntent();

        //取出对应的值
        String phone = intent.getStringExtra("data_phone");
        mBinding.userPhone.setText(phone);

        SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);
        String userName = sp.getString("name_"+phone,"0");
        String userSex = sp.getString("sex_"+phone,"0");
        String userSms = "1".equals(sp.getString("sms_"+phone,"0")) ? "接受":"拒绝";
        mBinding.userName.setText(userName);
        mBinding.userSex.setText(userSex);

        //接受信息推送：接送/拒绝
        String temp = mBinding.userSms.getText().toString()+":"+userSms;
        mBinding.userSms.setText(temp);
    }
    /**
     * 拦截系统返回键
     */
    @Override
    public void onBackPressed() {
        exit();
    }

    private void exit(){
        long time = 2000 ;
        if(System.currentTimeMillis() - exitTime > time){
            //存储此次点击返回键的时间
            exitTime = System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),"快速点击两次，可退出当前账号",Toast.LENGTH_SHORT).show();
        }else {
            finish();
        }
    }
}