package com.example.homeexhibition;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exhibiton_Mat extends AppCompatActivity {

    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibiton__mat);
        hideActionBar();


        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        final FragmentMat0 fragment= new FragmentMat0();
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
                Fragment_Mat1 fragment1= new Fragment_Mat1();
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
                Fragment_Mat2 fragment2= new Fragment_Mat2();
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
                Fragment_Mat3 fragment3= new Fragment_Mat3();
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
                Fragment_Mat4 fragment4= new Fragment_Mat4();
                transaction.replace(R.id.frame,fragment4);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        btn_5=findViewById(R.id.btn_5);

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),Board_Mat.class);
                startActivity(intent);
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
