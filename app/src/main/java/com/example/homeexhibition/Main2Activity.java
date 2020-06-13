package com.example.homeexhibition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment_home fragmentHome;
    private Fragment_exhibition fragment_exhibition;
    private Fragment_my fragment_my;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        hideActionBar();

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_ex:
                        setFrag(1);
                        break;
                    case R.id.action_my:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        fragmentHome=new Fragment_home();
        fragment_exhibition=new Fragment_exhibition();
        fragment_my=new Fragment_my();
        setFrag(0);
    }

    private void setFrag(int n){
        fm= getSupportFragmentManager();
        ft=fm.beginTransaction();
        Intent intent= getIntent();
        String userID= intent.getStringExtra("userID");
        switch (n){
            case 0:
                ft.replace(R.id.main_frame,fragmentHome);
                ft.commit();
                break;
            case 1:
                Intent intent2= new Intent(this,ExhibitionActivity.class);
                startActivity(intent2);
                break;
            case 2:
                ft.replace(R.id.main_frame,fragment_my);
                ft.commit();
                Bundle bundle=new Bundle();
                bundle.putString("userID",userID);
                fragment_my.setArguments(bundle);
                break;

        }

    }
    public  void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
