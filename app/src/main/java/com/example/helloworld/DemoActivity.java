package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener , RatingBar.OnRatingBarChangeListener {
    private TextView mTextView;
    private Button mButtonLeft, mButtonRight, mButtonOk;
    private Switch mSwitch;
    private ProgressBar mProgressBar;
    private EditText mEditText;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonAndroid, mRadioButtonAplle;
    private ImageView mImageView;
    private SeekBar mSeekBar;
    private CheckBox mCheckBoxAndroid, mCheckBoxApple, mCheckBoxSQL;
    private String android = "", apple = "", sql = "";
    private RatingBar mRatingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        mTextView = findViewById(R.id.text_view);
        mButtonLeft = findViewById(R.id.button_left);
        mButtonRight = findViewById(R.id.button_rigth);
        mButtonOk = findViewById(R.id.button_ok);
        mSwitch = findViewById(R.id.switch_ok);
        mProgressBar = findViewById(R.id.progress_bar);
        mEditText = findViewById(R.id.edit_number);
        mRadioGroup = findViewById(R.id.radioGroup);
        mImageView = findViewById(R.id.image_view);
        mSeekBar = findViewById(R.id.seek_bar);

        mCheckBoxAndroid = findViewById(R.id.check_android);
        mCheckBoxApple = findViewById(R.id.check_apple);
        mCheckBoxSQL = findViewById(R.id.check_sql);
        mRatingBar = findViewById(R.id.rating_bar);


        mRadioButtonAndroid = findViewById(R.id.radio_android);
        mRadioButtonAplle = findViewById(R.id.radio_apple);


        mButtonLeft.setOnClickListener(this);
        mButtonRight.setOnClickListener(this);
        mButtonOk.setOnClickListener(this);
        mSwitch.setOnCheckedChangeListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        mSeekBar.setOnSeekBarChangeListener(this);

        mCheckBoxAndroid.setOnCheckedChangeListener(this);
        mCheckBoxApple.setOnCheckedChangeListener(this);
        mCheckBoxSQL.setOnCheckedChangeListener(this);
        mRatingBar.setOnRatingBarChangeListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_left:
                mTextView.setText(getResources().getString(R.string.left));
                break;
            case R.id.button_rigth:
                mTextView.setText(getResources().getString(R.string.right));
                break;
            case R.id.button_ok:
                String s = mEditText.getText().toString();//获取编辑框中的字符串
//                int a = Integer.parseInt(s);//转换为整型数
//                mProgressBar.setProgress(a);//设置进度
//                mProgressBar.setProgress(Integer.parseInt(mEditText.getText().toString()));
                int temp;
                try {
                    temp = Integer.parseInt(mEditText.getText().toString());//转换为整数型
                } catch (NumberFormatException e) {
                    temp = 100;
                }
//                int temp = Integer.parseInt(mEditText.getText().toString());
//                if (temp>100){
//                    temp = 100;
//                }
                mProgressBar.setProgress(temp);//设置进度
                mSeekBar.setProgress(temp);
                mTextView.setText(s);
                if (temp <= 50) {
//                    mImageView.setImageResource(R.drawable.android);
                    mRadioButtonAndroid.setChecked(true);
                } else {
//                    mImageView.setImageResource(R.drawable.apple);
                    mRadioButtonAplle.setChecked(true);
                }

                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mTextView.setText(isChecked ? getResources().getString(R.string.open) : getResources().getString(R.string.close));

//        boolean ? true :false三目预算符
//        if (isChecked){
//            mTextView.setText(getResources().getString(R.string.open));
//        }else{
//            mTextView.setText(getResources().getString(R.string.close));
//        }
        switch (buttonView.getId()) {
            case R.id.switch_ok:
                mTextView.setText(isChecked ? getResources().getString(R.string.open) : getResources().getString(R.string.close));
                break;
            case R.id.check_android:
                if (isChecked) {
                    android = getResources().getString(R.string.android);
                } else {
                    android = "";
                }
                mTextView.setText(android + apple + sql);
                break;
            case R.id.check_apple:
                if (isChecked) {
                    apple = getResources().getString(R.string.apple);
                } else {
                    apple = "";
                }
                mTextView.setText(android + apple + sql);
                break;
            case R.id.check_sql:
                if (isChecked) {
                    sql = getResources().getString(R.string.sql);
                } else {
                    sql = "";
                }
                mTextView.setText(android + apple + sql);
                break;


//            case R.id.check_android:mTextView.setText(isChecked ? getResources().getString(R.string.android) :"");
//            case R.id.check_apple:mTextView.setText(isChecked ?"java":"");
//            case R.id.check_sql:mTextView.setText(isChecked ? "SQl" :"");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_android:
                mImageView.setImageResource(R.drawable.android);
                break;
            case R.id.radio_apple:
                mImageView.setImageResource(R.drawable.apple);
                break;
            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        //当进度发生变化时调用该方法
        mTextView.setText(String.valueOf(progress));
        mEditText.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //当开始触摸该控件时发生
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //当结束触摸该控件时是发生
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Toast.makeText(getApplicationContext(), rating + getResources().getString(R.string.star_rating),Toast.LENGTH_SHORT).show();
    }
}
