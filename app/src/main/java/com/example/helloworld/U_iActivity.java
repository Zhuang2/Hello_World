package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

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

import com.example.helloworld.databinding.ActivityUIBinding;

public class U_iActivity extends AppCompatActivity {
   private ActivityUIBinding mUIBinding;
//    private TextView mTextView;
//    private Button mButtonLeft, mButtonRight, mButtonOk;
//    private Switch mSwitch;
//    private ProgressBar mProgressBar;
//    private EditText mEditText;
//    private RadioGroup mRadioGroup;
//    private RadioButton mRadioButtonAndroid, mRadioButtonAplle;
//    private ImageView mImageView;
//    private SeekBar mSeekBar;
//    private CheckBox mCheckBoxAndroid, mCheckBoxApple, mCheckBoxSQL;
//    private RatingBar mRatingBar;
    private String android = "", apple = "", sql = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUIBinding = ActivityUIBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_u_i);
        setContentView(mUIBinding.getRoot());

//        mTextView = findViewById(R.id.text_view);
//        mButtonLeft = findViewById(R.id.button_left);
//        mButtonRight = findViewById(R.id.button_rigth);
//        mButtonOk = findViewById(R.id.button_ok);
//        mSwitch = findViewById(R.id.switch_ok);
//        mProgressBar = findViewById(R.id.progress_bar);
//        mEditText = findViewById(R.id.edit_number);
//        mRadioGroup = findViewById(R.id.radioGroup);
//        mImageView = findViewById(R.id.image_view);
//        mSeekBar = findViewById(R.id.seek_bar);
//        mCheckBoxAndroid = findViewById(R.id.check_android);
//        mCheckBoxApple = findViewById(R.id.check_apple);
//        mCheckBoxSQL = findViewById(R.id.check_sql);
//        mRatingBar = findViewById(R.id.rating_bar);
//        mRadioButtonAndroid = findViewById(R.id.radio_android);
//        mRadioButtonAplle = findViewById(R.id.radio_apple);

        //mButtonLeft控件设置点击事件监听器接口
        //setOnClickListener(接受一个监听器的实现类)
        mUIBinding.buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUIBinding.textView.setText(getResources().getString(R.string.left));
            }
        });
        mUIBinding.buttonRigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUIBinding.textView.setText(getResources().getString(R.string.right));
            }
        });
        mUIBinding.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mUIBinding.editNumber.getText().toString();
                int temp;
                try {
                    temp = Integer.parseInt(mUIBinding.editNumber.getText().toString());//转换为整数型
                } catch (NumberFormatException e) {
                    temp = 100;
                }
                mUIBinding.progressBar.setProgress(temp);//设置进度
                mUIBinding.seekBar.setProgress(temp);
                mUIBinding.textView.setText(s);
                if (temp <= 50) {
                    mUIBinding.radioAndroid.setChecked(true);
                } else {
                    mUIBinding.radioApple.setChecked(true);
                }
            }
        });
        mUIBinding.switchOk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mUIBinding.textView.setText(isChecked ? getResources().getString(R.string.open) : getResources().getString(R.string.close));
//                if (isChecked){
//                    mTextView.setText(getResources().getString(R.string.open));
//                }else{
//                    mTextView.setText(getResources().getString(R.string.close));
            }
        });
       mUIBinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               if (checkedId==0){
                   mUIBinding.imageView.setImageResource(R.drawable.android);
               }else{
                   mUIBinding.imageView.setImageResource(R.drawable.apple);
               }
           }
       });
       mUIBinding.checkAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                   android = getResources().getString(R.string.android);
               } else {
                   android = "";
               }
               mUIBinding.textView.setText(android + apple + sql);
           }
       });
       mUIBinding.checkApple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                   apple = getResources().getString(R.string.apple);
               } else {
                   apple = "";
               }
               mUIBinding.textView.setText(android + apple + sql);
           }
       });
       mUIBinding.checkSql.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                   sql = getResources().getString(R.string.sql);
               } else {
                   sql = "";
               }
               mUIBinding.textView.setText(android + apple + sql);

           }
       });
       mUIBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               mUIBinding.textView.setText(String.valueOf(progress));
               mUIBinding.editNumber.setText(String.valueOf(progress));
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });
       mUIBinding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
           @Override
           public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
               Toast.makeText(getApplicationContext(), rating + getResources().getString(R.string.star_rating),Toast.LENGTH_SHORT).show();
           }
       });
    }
}
