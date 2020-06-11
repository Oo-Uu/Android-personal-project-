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


public class FragmentDega0 extends Fragment {
    private ImageView imageView;
    private Button btn_web;

    public FragmentDega0() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_dega0, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%ED%99%94%EA%B0%80%2F%EB%93%9C%EA%B0%80%20%EC%9D%B8%EB%AC%BC.jpeg?alt=media&token=237c80eb-ad12-419f-85e7-c4a420381bff";
        imageView= view.findViewById(R.id.image);
        btn_web=view.findViewById(R.id.web);
        Glide.with(this).load(url).into(imageView);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EC%97%90%EB%93%9C%EA%B0%80_%EB%93%9C%EA%B0%80"));
                startActivity(intent);
            }

        });

        return view;
    }


}
