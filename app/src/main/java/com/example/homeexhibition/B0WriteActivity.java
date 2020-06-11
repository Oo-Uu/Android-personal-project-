package com.example.homeexhibition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class B0WriteActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private EditText mWriteTitleText;
    private EditText mWriteContentsText;
    private String nick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b0_write);
        hideActionBar();
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
            String postId= mStore.collection(FirebaseId.board0).document().getId();
            Map<String, Object> data = new HashMap<>();
            data.put(FirebaseId.documentId, mAuth.getCurrentUser().getUid());
            data.put(FirebaseId.title, mWriteTitleText.getText().toString());
            data.put(FirebaseId.contents, mWriteContentsText.getText().toString());
            data.put(FirebaseId.timeStamp, FieldValue.serverTimestamp());
            data.put(FirebaseId.nick,nick);
            mStore.collection(FirebaseId.board0).document(postId).set(data, SetOptions.merge());
            finish();
        }


    }

    public  void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }
    }

}