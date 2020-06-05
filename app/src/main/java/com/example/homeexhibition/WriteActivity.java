package com.example.homeexhibition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {


    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();


    private EditText mWriteTitleText;
    private EditText mWriteContentsText;
    private String nick;


    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);


        mWriteTitleText = findViewById(R.id.write_title_text);
        mWriteContentsText = findViewById(R.id.write_contents_text);

        findViewById(R.id.write_upload_button).setOnClickListener(this);

        if(mAuth.getCurrentUser() != null){
            mStore.collection(FirebaseId.user).document(mAuth.getCurrentUser().getUid())
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.getResult() != null){
                                nick=(String)task.getResult().getData().get(FirebaseId.nick);
                            }
                        }
                    });
        }


    }

    @Override
    public void onClick(View v) {
        if (mAuth.getCurrentUser() != null) {
            String postId= mStore.collection(FirebaseId.board).document().getId();
            Map<String, Object> data = new HashMap<>();
            data.put(FirebaseId.documentId, mAuth.getCurrentUser().getUid());
            data.put(FirebaseId.title, mWriteTitleText.getText().toString());
            data.put(FirebaseId.contents, mWriteContentsText.getText().toString());
            data.put(FirebaseId.timeStamp, FieldValue.serverTimestamp());
            data.put(FirebaseId.nick,nick);
            mStore.collection(FirebaseId.board).document(postId).set(data, SetOptions.merge());
            finish();
        }


    }
}

       /* Intent intent= getIntent();
        String userID= intent.getStringExtra("userID");

        id=userID;
        Map<String, Object> post= new HashMap<>();
        post.put("id",id);
        post.put("title",mWriteTitleText.getText().toString());
        post.put("Contents",mWriteContentsText.getText().toString());
       // post.put("name",id);

        mStore.collection("board").add(post)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(WriteActivity.this,"업로드 성공",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(WriteActivity.this,"업로드 실패",Toast.LENGTH_SHORT).show();
                    }
                });

    }*/

