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
 * Use the {@link FragmentRuv4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRuv4 extends Fragment {
    private ImageView imageView;

    public FragmentRuv4() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ruv4, container, false);
        String url="https://firebasestorage.googleapis.com/v0/b/homeexhibition-c467f.appspot.com/o/%EB%A3%A8%EB%B2%A4%EC%8A%A4.jpg?alt=media&token=45224ce3-839d-47f2-85af-46796d19090d";
        imageView= view.findViewById(R.id.image);
        Glide.with(this).load(url).into(imageView);

        return view;
    }
}
