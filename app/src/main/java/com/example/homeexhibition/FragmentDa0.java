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


public class FragmentDa0 extends Fragment {
    private ImageView imageView;
    private Button btn_web;

    public FragmentDa0() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_da0, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%ED%99%94%EA%B0%80%2F%EB%8B%A4%EB%B9%88%EC%B9%98%20%EC%9D%B8%EB%AC%BC.jpeg?alt=media&token=0fc72ac7-34a5-4c2d-bd4a-3b5d25280588";
        imageView= view.findViewById(R.id.image);
        btn_web=view.findViewById(R.id.web);
        Glide.with(this).load(url).into(imageView);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EB%A0%88%EC%98%A4%EB%82%98%EB%A5%B4%EB%8F%84_%EB%8B%A4_%EB%B9%88%EC%B9%98"));
                startActivity(intent);
            }

        });

        return view;
    }


}
