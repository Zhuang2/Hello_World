package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityHomeBinding;

import java.util.Objects;

public class home extends AppCompatActivity {

    private ActivityHomeBinding mBinding;
    private long exitTime = 0;
    public static final String EXIT_HOME = "exit_home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        //获取传过来的Intent对象
        Intent intent = getIntent();
        //接收传过来的封装数据包
        UserInfo userInfo = (UserInfo) intent.getSerializableExtra("userInfo");
        //取出对应的值
        String phone = Objects.requireNonNull(userInfo).getPhone();
        String userName = userInfo.getUserName();
        String userSex = userInfo.getSex();
        String userSms = userInfo.getSms();
        //将值设置到界面
        mBinding.userPhone.setText(phone);
        mBinding.userName.setText(userName);
        mBinding.userSex.setText(userSex);

        //接受信息推送：接送/拒绝
        String temp = mBinding.userSms.getText().toString()+":"+userSms;
        mBinding.userSms.setText(temp);
        //返回数据
        intent.putExtra(EXIT_HOME,"你已退出账号");
        setResult(RESULT_OK,intent);
    }

    /**
     * 对外提供公开静态的启动本Activity的方法
     * @param activity 启动方的上下文
     * @param userName 用户昵称
     * @param pwd 用户密码
     * @param userSex 用户性别
     * @param phone 用户手机号
     * @param userSms  用户是否接受消息推送
     * @param resultCode 请求代码
     */
    public static void actionStart(Activity activity,String userName,String pwd,
                                   String userSex,String phone,String userSms,int resultCode){
        Intent intent = new Intent(activity,home.class);
        Bundle bundle = new Bundle();
        UserInfo userInfo = new UserInfo(userName,pwd,userSex,phone,userSms);
        bundle.putSerializable("userInfo",userInfo);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent,resultCode);

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