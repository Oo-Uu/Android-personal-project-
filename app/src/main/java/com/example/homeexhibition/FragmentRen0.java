package com.example.homeexhibition;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class FragmentRen0 extends Fragment {
    private ImageView imageView;
    private Button btn_web;

    public FragmentRen0() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ren0, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%ED%99%94%EA%B0%80%2F%EB%A5%B4%EB%88%84%EC%95%84%EB%A5%B4%20%EC%9D%B8%EB%AC%BC.jpeg?alt=media&token=7f22a091-8137-4b4e-a310-2b11204f0f33";
        imageView= view.findViewById(R.id.image);
        btn_web=view.findViewById(R.id.web);
        Glide.with(this).load(url).into(imageView);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EC%98%A4%EA%B7%80%EC%8A%A4%ED%8A%B8_%EB%A5%B4%EB%88%84%EC%95%84%EB%A5%B4"));
                startActivity(intent);
            }

        });

        return view;
    }


}
