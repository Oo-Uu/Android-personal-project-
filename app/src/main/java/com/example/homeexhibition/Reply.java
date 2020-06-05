package com.example.homeexhibition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Reply extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private TextView titleview, contentsview,nickview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        /*recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); //리사이클러뷰 기존 성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        */


        Intent intent=getIntent();
        String title= intent.getStringExtra("Title");
        String contents=intent.getStringExtra("Contents");
        String nick=intent.getStringExtra("Nick");

        titleview=findViewById(R.id.item_title_text);
        contentsview=findViewById(R.id.item_contents_text);
        nickview=findViewById(R.id.item_Nick_text);

        titleview.setText(title);
        contentsview.setText(contents);
        nickview.setText(nick);


    }
}
