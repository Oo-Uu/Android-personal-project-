package com.example.homeexhibition;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRuv3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRuv3 extends Fragment {
    private ImageView imageView;

    public FragmentRuv3() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ruv3, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%EB%A3%A8%EB%B2%A4%EC%8A%A43.%20%EC%82%BC%EC%86%90%EA%B3%BC%20%EB%8D%B8%EB%A6%B4%EB%9D%BC.jpg?alt=media&token=30198fa0-3acc-40e3-975c-bba0bddf118a";
        imageView= view.findViewById(R.id.image);
        Glide.with(this).load(url).into(imageView);

        return view;
    }
}
