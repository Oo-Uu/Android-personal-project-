package com.example.homeexhibition;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;



public class FragmentRuv1 extends Fragment {
    private ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ruv1, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%EB%A3%A8%EB%B2%A4%EC%8A%A41.jpg?alt=media&token=cae1b49a-c37e-4fa9-8f20-aaf314a618d7";
        imageView= view.findViewById(R.id.image);
        Glide.with(this).load(url).into(imageView);

        return view;
    }
}
