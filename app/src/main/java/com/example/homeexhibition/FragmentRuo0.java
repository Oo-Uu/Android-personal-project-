package com.example.homeexhibition;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentRuo0 extends Fragment {
   private Button btn_web;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ruo0,container, false);
        btn_web=view.findViewById(R.id.web);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EC%A1%B0%EB%A5%B4%EC%A3%BC_%EB%A3%A8%EC%98%A4"));
                startActivity(intent);
            }

        });
        return view;
    }
}
