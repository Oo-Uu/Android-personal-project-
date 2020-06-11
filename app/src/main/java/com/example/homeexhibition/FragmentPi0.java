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


public class FragmentPi0 extends Fragment {
    private ImageView imageView;
    private Button btn_web;

    public FragmentPi0() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_pi0, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%ED%99%94%EA%B0%80%2F%ED%94%BC%EC%B9%B4%EC%86%8C%20%EC%9D%B8%EB%AC%BC.jpeg?alt=media&token=623c1e9c-4673-4c3c-bc99-5309f1d26d47";
        imageView= view.findViewById(R.id.image);
        btn_web=view.findViewById(R.id.web);
        Glide.with(this).load(url).into(imageView);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%ED%8C%8C%EB%B8%94%EB%A1%9C_%ED%94%BC%EC%B9%B4%EC%86%8C"));
                startActivity(intent);
            }

        });

        return view;
    }


}
