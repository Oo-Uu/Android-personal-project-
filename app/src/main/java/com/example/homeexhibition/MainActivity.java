package com.example.homeexhibition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickedEx(View v) {
        Intent intent = new Intent(MainActivity.this, ExhibitionActivity.class);
        startActivity(intent);
    }
    public void onClickedSearch(View v) {
        Intent intent = new Intent(MainActivity.this,Search.class);
        startActivity(intent);
    }
    public void onClickedToday(View v){
        Intent intent=new Intent(MainActivity.this,Exhibition_van.class);
        startActivity(intent);
    }


}
