package com.example.homeexhibition;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.homeexhibition.R.id.recyclerView;

public class Community extends AppCompatActivity implements View.OnClickListener {
    private FirebaseFirestore mStore=FirebaseFirestore.getInstance();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private MainAdapter mAdapter;
    private List<Board> mBoardList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_commmnity);

         recyclerView=findViewById(R.id.recyclerView);
         recyclerView.setHasFixedSize(true); //리사이클러뷰 기존 성능 강화
         layoutManager = new LinearLayoutManager(this);
         recyclerView.setLayoutManager(layoutManager);




        findViewById(R.id.btn_wrt).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBoardList=new ArrayList<>();
        mStore.collection(FirebaseId.board)
                .orderBy(FirebaseId.timeStamp, Query.Direction.DESCENDING)
               .addSnapshotListener(new EventListener<QuerySnapshot>() {
                   @Override
                   public void onEvent(@javax.annotation.Nullable QuerySnapshot queryDocumentSnapshots, @javax.annotation.Nullable FirebaseFirestoreException e) {
                       if(queryDocumentSnapshots != null){
                           mBoardList.clear();
                           for(DocumentSnapshot snap: queryDocumentSnapshots.getDocuments()){
                               Map<String, Object> shot=snap.getData();
                               String documentId= String.valueOf(shot.get(FirebaseId.documentId));
                               String title= String.valueOf(shot.get(FirebaseId.title));
                               String contents=String.valueOf(shot.get(FirebaseId.contents));
                               String nick=String.valueOf(shot.get(FirebaseId.nick));
                               String time=String.valueOf(shot.get(FirebaseId.timeStamp));
                               Board data=new Board(documentId,title,contents,nick,time);
                               mBoardList.add(data);
                           }
                           mAdapter= new MainAdapter(mBoardList);
                           recyclerView.setAdapter(mAdapter);
                       }
                   }
               });
    }

    @Override
    public void onClick(View v) {
        Intent intent2=new Intent(this,WriteActivity.class);
        startActivity(intent2);
    }



    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        private List<Board> mBoardList;

        private MainAdapter(List<Board> mBoardList){
            this.mBoardList=mBoardList;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
            Board data=mBoardList.get(position);
            holder.mTitleTextView.setText(data.getTitle());
            holder.mContentsTextView.setText(data.getContents());
            holder.mNameTextView.setText(data.getNick());
            holder.mTimeTextView.setText(data.getTime());

        }

        @Override
        public int getItemCount() {
            return mBoardList.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder{
            private TextView mTitleTextView;
            private TextView mNameTextView;
            private TextView mContentsTextView;
            private TextView mTimeTextView;

            public MainViewHolder(View itemView){
                super(itemView);
                mTitleTextView=itemView.findViewById(R.id.item_title_text);
                mNameTextView=itemView.findViewById(R.id.item_Nick_text);
                mContentsTextView= itemView.findViewById(R.id.item_contents_text);
                mTimeTextView=itemView.findViewById(R.id.item_time_text);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos=getAdapterPosition();
                        if(pos!=RecyclerView.NO_POSITION){
                            Intent intent=new Intent(getApplicationContext(),Reply.class);
                            intent.putExtra("Title",mTitleTextView.getText().toString());
                            intent.putExtra("Nick",mNameTextView.getText().toString());
                            intent.putExtra("Contents",mContentsTextView.getText().toString());
                            intent.putExtra("Time",mTimeTextView.getText().toString());
                            startActivity(intent);
                        }

                    }
                });
            }


        }
    }
}



