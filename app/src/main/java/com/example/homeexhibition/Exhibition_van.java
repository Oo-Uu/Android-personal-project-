package com.example.homeexhibition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exhibition_van extends AppCompatActivity {
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition_van);

        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        Fragment fragment= new Fragment();
        transaction.replace(R.id.frame,fragment);
        transaction.addToBackStack(null);
        transaction.commit();



        btn_1=findViewById(R.id.btn_1);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1= new Fragment1();
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
                Fragment2 fragment2= new Fragment2();
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
                Fragment3 fragment3= new Fragment3();
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
                Fragment4 fragment4= new Fragment4();
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
