package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityUpdatePwdBinding;

public class UpdatePwdActivity extends AppCompatActivity {

    private ActivityUpdatePwdBinding mBinding;
    String pwd,pwdOk,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityUpdatePwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd = mBinding.updatePwd.getText().toString().trim();
                pwdOk = mBinding.updatePwdOk.getText().toString().trim();
                String toast;
                if(pwd.length()!=6){
                    toast="密码长度必须为6位数";
                }
                else if(!pwd.equals(pwdOk)){
                    toast="请确保密码是否一致";
                }else{
                    SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);
                    phone = getIntent().getStringExtra("phone");
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("pwd_"+phone,pwd);
                    editor.putString("pwdOk_"+phone,pwdOk);
                    editor.apply();
                    toast="密码修改成功！";
                    Intent intent = new Intent(UpdatePwdActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                Toast.makeText(UpdatePwdActivity.this,toast,Toast.LENGTH_LONG).show();
            }
        });
    }
}
