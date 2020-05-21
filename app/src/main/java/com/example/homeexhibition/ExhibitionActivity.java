package com.example.homeexhibition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ExhibitionActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ExInfo>arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition);

        recyclerview=findViewById(R.id.recyclerView);
        recyclerview.setHasFixedSize(true); //리사이클러뷰 기존 성능 강화
        layoutManager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        arrayList=new ArrayList<>();//전시회 정보 객체 담을 어레이 리스트(어뎁터쪽으로)

        database=FirebaseDatabase.getInstance().getInstance();//파이어베이스 데이터베이스 연동

        databaseReference=database.getReference("ExInfo");//데이터 베이스 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear();//기존 배열리스트가 존재하지않게 초기화
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){//반복문으로 데이터 리스트 추출
                    ExInfo info= snapshot.getValue(ExInfo.class);
                    arrayList.add(info);
                }
                adapter.notifyDataSetChanged();//리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던 중 에러 발생 시
                Log.e("MainActivity",String.valueOf(databaseError.toException()));//에러문 출력
            }
        });

        adapter=new ExhibitionAdapter(arrayList,this);
        recyclerview.setAdapter(adapter);//리사이클러뷰에 어댑터 연결
    }
    public void onClickedHome(View v){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void onClickedVan(View v){
        Intent intent=new Intent(getApplicationContext(),Exhibition_van.class);
        startActivity(intent);
    }
    public void onClickedSearch(View v){
        Intent intent=new Intent(getApplicationContext(),Search.class);
        startActivity(intent);
    }
    public void MY(View v){
        Intent intent=new Intent(getApplicationContext(),My.class);
        startActivity(intent);
    }





}
