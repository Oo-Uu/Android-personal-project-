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


public class FragmentRaf0 extends Fragment {
    private ImageView imageView;
    private Button btn_web;

    public FragmentRaf0() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_raf0, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%ED%99%94%EA%B0%80%2F%EB%9D%BC%ED%8C%8C%20%EC%9D%B8%EB%AC%BC.jpeg?alt=media&token=6458a04d-2c5f-483d-940e-3008b9ba93a7";
        imageView= view.findViewById(R.id.image);
        btn_web=view.findViewById(R.id.web);
        Glide.with(this).load(url).into(imageView);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EB%9D%BC%ED%8C%8C%EC%97%98%EB%A1%9C_%EC%82%B0%EC%B9%98%EC%98%A4"));
                startActivity(intent);
            }

        });

        return view;
    }


}
