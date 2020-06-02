package com.example.homeexhibition;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exhibition_Ruv extends AppCompatActivity {
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition__ruv);

        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        final FragmentRuv0 fragment= new FragmentRuv0();
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



        btn_1=findViewById(R.id.btn_1);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                FragmentRuv1 fragment1= new FragmentRuv1();
                transaction.replace(R.id.frame,fragment1);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        btn_2=findViewById(R.id.btn_2);

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                FragmentRuv2 fragment2= new FragmentRuv2();
                transaction.replace(R.id.frame,fragment2);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        btn_3=findViewById(R.id.btn_3);

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                FragmentRuv3 fragment3= new FragmentRuv3();
                transaction.replace(R.id.frame,fragment3);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        btn_4=findViewById(R.id.btn_4);

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                FragmentRuv4 fragment4= new FragmentRuv4();
                transaction.replace(R.id.frame,fragment4);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }







    public void onClickExit(View v){
        Intent intent=new Intent(getApplicationContext(),ExhibitionActivity.class);
        startActivity(intent);
    }
}
