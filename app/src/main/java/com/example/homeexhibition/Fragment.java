package com.example.homeexhibition;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Fragment extends androidx.fragment.app.Fragment {
    private Button btn_web;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,container, false);
        btn_web=view.findViewById(R.id.web);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://ko.wikipedia.org/wiki/%EC%97%90%EB%93%9C%EB%B0%94%EB%A5%B4_%EB%AD%89%ED%81%AC"));
                startActivity(intent);
            }

        });
        return view;
    }
}
