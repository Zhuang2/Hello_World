package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class AliActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ali);
        Toast.makeText(getApplicationContext(),getResources().getString(R.string.app_name),Toast.LENGTH_LONG).show();
        //Toast,弹出式通知
        //makeText(),构建通知,三个参数（context,字符串资源，时长）
        //context,上下文
        //getApplicationContext(),获取当前Context
        //show(),显示出来
        //getResources().getString().获取资源.获取字符串资源（资源id）
    }
}
