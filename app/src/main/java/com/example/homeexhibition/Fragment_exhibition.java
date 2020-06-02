package com.example.homeexhibition;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fragment_exhibition extends Fragment {
    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ExInfo>arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_exhibition, container, false);
        recyclerview= recyclerview.findViewById(R.id.recyclerView);
        recyclerview.setHasFixedSize(true); //리사이클러뷰 기존 성능 강화
        layoutManager = new LinearLayoutManager(getActivity());
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
                Log.e("Main2Activity",String.valueOf(databaseError.toException()));//에러문 출력
            }
        });

        adapter=new ExhibitionAdapter(arrayList,getActivity());
        recyclerview.setAdapter(adapter);//리사이클러뷰에 어댑터 연결


        return view;
    }
}
