package com.example.homeexhibition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reply extends AppCompatActivity implements View.OnClickListener {
    private FirebaseFirestore mStore=FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth=FirebaseAuth.getInstance();

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ReplyAdapter mAdapter;
    private List<Re> mReplyList;

    private TextView titleview, contentsview, nickview;

    private EditText et_reply;

    private String Nick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true); //리사이클러뷰 기존 성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        et_reply=findViewById(R.id.et_reply);

        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");
        String contents = intent.getStringExtra("Contents");
        String nick = intent.getStringExtra("Nick");

        titleview = findViewById(R.id.item_title_text);
        contentsview = findViewById(R.id.item_contents_text);
        nickview = findViewById(R.id.item_Nick_text);

        titleview.setText(title);
        contentsview.setText(contents);
        nickview.setText(nick);

        findViewById(R.id.btn_enterText).setOnClickListener(this);

        if(mAuth.getCurrentUser() != null){
            mStore.collection(FirebaseId.user).document(mAuth.getCurrentUser().getUid())
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.getResult() != null){
                                Nick=(String)task.getResult().getData().get(FirebaseId.nick);
                            }
                        }
                    });
        }


    }



    @Override
    public void onClick(View v) {
        if (mAuth.getCurrentUser() != null) {
            String postId= mStore.collection(FirebaseId.re).document().getId();
            Map<String, Object> data = new HashMap<>();
            data.put(FirebaseId.documentId, mAuth.getCurrentUser().getUid());
            data.put(FirebaseId.reply, et_reply.getText().toString());
            data.put(FirebaseId.nick,Nick);
            data.put(FirebaseId.timeStamp, FieldValue.serverTimestamp());
            mStore.collection(FirebaseId.re).document(postId).set(data, SetOptions.merge());
            et_reply.setText(null);
            //finish();
        }
        }


    private class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.ReplyViewHolder> {
           private List<Re> replyList;

           private ReplyAdapter(List<Re> replyList){
               this.replyList=replyList;
           }


           @NonNull
        @Override
        public ReplyAdapter.ReplyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ReplyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.replyitem,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ReplyAdapter.ReplyViewHolder holder, int position) {
            Re data=replyList.get(position);
            holder.mNickTextView.setText(data.getNick());
            holder.mReplyTextView.setText(data.getReply());
           }

        @Override
        public int getItemCount() {
            return replyList.size();
        }

        public class ReplyViewHolder extends RecyclerView.ViewHolder {
            private TextView mNickTextView;
            private TextView mReplyTextView;


            public ReplyViewHolder(@NonNull View itemView) {
                super(itemView);
                mNickTextView=findViewById(R.id.item_Nick_text);
                mReplyTextView=findViewById(R.id.item_Reply_text);
            }
        }
    }
}
