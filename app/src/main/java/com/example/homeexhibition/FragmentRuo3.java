package com.example.homeexhibition;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRuo3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRuo3 extends Fragment {


    private String mParam1;
    private String mParam2;

    public FragmentRuo3() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ruo3, container, false);
    }
}
