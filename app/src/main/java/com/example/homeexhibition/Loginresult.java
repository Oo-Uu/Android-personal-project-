package com.example.homeexhibition;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Loginresult extends AppCompatActivity {
    private TextView nickname; //닉네임
    private ImageView profile;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultactivity);

        Intent intent= getIntent();
        String nickName= intent.getStringExtra("nickName");// login 창으로부터 닉네임 전달받음
        String photoUrl= intent.getStringExtra("photoUrl");//프로필사진 전달받음

        nickname=findViewById(R.id.loginresult);
        nickname.setText(nickName);// 닉네임 text를 텍스트 뷰에 세팅

        profile=findViewById(R.id.lg_profile);
        Glide.with(this).load(photoUrl).into(profile); // 프로필 url을 이미지 뷰에 세팅

    }
}
