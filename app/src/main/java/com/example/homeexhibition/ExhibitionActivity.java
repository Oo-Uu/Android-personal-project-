package com.example.homeexhibition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ExhibitionActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private ExhibitionAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<ExInfo> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Fragment_home fragmentHome;
    private Fragment_exhibition fragment_exhibition;
    private Fragment_my fragment_my;

    private SearchView searchView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition);


        recyclerview = findViewById(R.id.recyclerView);
        recyclerview.setHasFixedSize(true); //리사이클러뷰 기존 성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();//전시회 정보 객체 담을 어레이 리스트(어뎁터쪽으로)

        database = FirebaseDatabase.getInstance().getInstance();//파이어베이스 데이터베이스 연동

        databaseReference = database.getReference("ExInfo");//데이터 베이스 테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스의 데이터를 받아오는 곳
                arrayList.clear();//기존 배열리스트가 존재하지않게 초기화
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {//반복문으로 데이터 리스트 추출
                    ExInfo info = snapshot.getValue(ExInfo.class);
                    arrayList.add(info);
                }
                adapter.notifyDataSetChanged();//리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비를 가져오던 중 에러 발생 시
                Log.e("MainActivity", String.valueOf(databaseError.toException()));//에러문 출력
            }
        });

        adapter = new ExhibitionAdapter(arrayList, this);
        recyclerview.setAdapter(adapter);//리사이클러뷰에 어댑터 연결

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
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
        fragmentHome = new Fragment_home();
        fragment_my = new Fragment_my();
        setFrag(1);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchfile,menu);
        final MenuItem myActionMenuitem=menu.findItem(R.id.search);
        searchView=(SearchView)myActionMenuitem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(!searchView.isIconified()){
                    searchView.setIconified(true);
                }
                myActionMenuitem.collapseActionView();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {// arraylist랑 adapter랑 연결
                final ArrayList<ExInfo> filtermodeList=filter(arrayList,newText);
                adapter.setfilter(filtermodeList);
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }


    private ArrayList<ExInfo> filter(ArrayList<ExInfo> ar,String query) { //Arraylist에 검색ㅎ서 나오는거 넣어주고 return
        query=query.toLowerCase();
        final ArrayList<ExInfo> filterModeList= new ArrayList<>();
        for(ExInfo info:ar){
            final String painter=info.getPainter().toLowerCase();
            if(painter.startsWith(query)){
                filterModeList.add(info);
            }
        }
        return filterModeList;
    }


    private void setFrag(int n){
        switch (n) {
            case 0:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                break;
            case 1:
                break;
        }
    }

}








