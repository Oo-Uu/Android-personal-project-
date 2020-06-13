package com.example.homeexhibition;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class Fragment_Mat4 extends Fragment {
    private ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment__mat4, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%EB%A7%88%ED%8B%B0%EC%8A%A4%2F%EB%A7%88%ED%8B%B0%EC%8A%A44.jpg?alt=media&token=edbe19b4-f775-4365-b285-c408b18e68fc";
        imageView= view.findViewById(R.id.image);
        Glide.with(this).load(url).into(imageView);

        return view;
    }
}
