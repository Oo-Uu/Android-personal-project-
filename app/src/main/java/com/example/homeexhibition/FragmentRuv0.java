package com.example.homeexhibition;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class FragmentRuv0 extends Fragment {
    private ImageView imageView;
    private Button btn_web;

    public FragmentRuv0() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ruv0, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%EB%A3%A8%EB%B2%A4%EC%8A%A4%20%EC%9D%B8%EB%AC%BC.jpg?alt=media&token=88f98990-9e19-4f54-9606-f9e9813a3b31";
        imageView= view.findViewById(R.id.image);
        btn_web=view.findViewById(R.id.web);
        Glide.with(this).load(url).into(imageView);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%ED%8E%98%ED%85%8C%EB%A5%B4_%ED%8C%8C%EC%9A%B8_%EB%A3%A8%EB%B2%A4%EC%8A%A4"));
                startActivity(intent);
            }

        });

        return view;
    }


}
