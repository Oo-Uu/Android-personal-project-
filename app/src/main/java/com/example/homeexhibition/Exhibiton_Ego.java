package com.example.homeexhibition;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exhibiton_Ego extends AppCompatActivity {

    private Button btn_0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibiton__ego);
        hideActionBar();


        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        final FragmentEgo0 fragment= new FragmentEgo0();
        transaction.replace(R.id.frame,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        btn_0=findViewById(R.id.btn_0);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }
    public void onClickExit(View v){
        Intent intent=new Intent(getApplicationContext(),ExhibitionActivity.class);
        startActivity(intent);
    }
    public  void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
