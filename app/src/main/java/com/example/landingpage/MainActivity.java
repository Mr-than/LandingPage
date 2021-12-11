package com.example.landingpage;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class MainActivity extends AppCompatActivity {

    int num=1;
    int a;
    TextView text3;
    TextView text4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      a =getResources().getColor(R.color.text1);

        //任务栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                View decorView = window.getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                decorView.setSystemUiVisibility(option);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else {
                Window window = getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int flagTranslucentStatus = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                attributes.flags |= flagTranslucentStatus;
                window.setAttributes(attributes);
            }
        }

      //将任务栏字体设置为黑色（不设置的话为白色，那确实是看不见。）
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//设置状态栏黑色字体



        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        text3=findViewById(R.id.text_view3);
        text4=findViewById(R.id.text_view4);
        setText();


        LottieAnimationView lottieAnimationView=findViewById(R.id.lottie_layer);

        lottieAnimationView.setProgress(0.5f);

        lottieAnimationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (num == 1) {
                    lottieAnimationView.playAnimation();
                    num=2;
                }else if(num==2) {
                   // lottieAnimationView.playAnimation();
                    lottieAnimationView.setProgress(0.5f);
                    num=1;
                }
            }
        });

    }

    public void setText(){

        SpannableStringBuilder spannableStringBuilder=new SpannableStringBuilder("同意《用户协议》和《隐私权政策》 ");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        spannableStringBuilder.setSpan(colorSpan,2,8, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableStringBuilder.setSpan(colorSpan1,9,16,Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        text3.setText(spannableStringBuilder);


        SpannableStringBuilder spannableStringBuilder1=new SpannableStringBuilder("没有学号么？游客模式吧 ");
        ForegroundColorSpan colorSpan2=new ForegroundColorSpan(Color.parseColor("#ABBCD8"));
        ForegroundColorSpan colorSpan3=new ForegroundColorSpan(a);

        spannableStringBuilder1.setSpan(colorSpan2,0,6,Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannableStringBuilder1.setSpan(colorSpan3,6,11,Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        text4.setText(spannableStringBuilder1);
    }

}