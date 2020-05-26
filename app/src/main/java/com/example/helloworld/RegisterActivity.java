package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding mBinding;
    String name,sex = "",pwd,pwdOK,phone;
    boolean sms=false,protocol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mBinding.editName.getText().toString().trim();
                pwd = mBinding.editPwd.getText().toString().trim();
                pwdOK = mBinding.editPwdOk.getText().toString().trim();
                phone = mBinding.editPhone.getText().toString().trim();
                sms = mBinding.switchSms.isChecked();
                protocol = mBinding.checkProtocal.isChecked();
                String toast;
                if(name.equals("")){
                    toast="请填写昵称";
                }
                else if(phone.equals("")){
                    toast="请填写手机号码";
                }
                else if(sex.equals("")){
                    toast="请选择性别";
                }
                else if(pwd.length()!=6){
                    toast="密码长度必须为6位数";
                }
                else if(!pwd.equals(pwdOK)){
                    toast="请确保密码是否一致";
                }
                else if(phone.length()!=11){
                    toast="请使用正确的中国大陆手机号码";
                }
                else if(!protocol){
                    toast = "请同意本软件的相关协议和策略，否则无法注册";
                }
                else {
                    toast="注册成功！";
                }
                Toast.makeText(RegisterActivity.this,toast,Toast.LENGTH_LONG).show();
            }
        });

        mBinding.radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radio_man){
                    sex = mBinding.radioMan.getText().toString();
                }
                else sex = mBinding.radioWoman.getText().toString();
            }
        });
    }
}
