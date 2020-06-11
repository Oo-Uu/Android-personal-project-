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


public class FragmentGo0 extends Fragment {
    private ImageView imageView;
    private Button btn_web;

    public FragmentGo0() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_go0, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%ED%99%94%EA%B0%80%2F%EA%B3%A0%ED%9D%90%20%EC%9D%B8%EB%AC%BC.jpeg?alt=media&token=2449ba64-b2c9-4efb-9677-9b5883f5c9c3";
        imageView= view.findViewById(R.id.image);
        btn_web=view.findViewById(R.id.web);
        Glide.with(this).load(url).into(imageView);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EB%B9%88%EC%84%BC%ED%8A%B8_%EB%B0%98_%EA%B3%A0%ED%9D%90"));
                startActivity(intent);
            }

        });

        return view;
    }


}
