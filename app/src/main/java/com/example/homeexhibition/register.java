package com.example.homeexhibition;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity implements View.OnClickListener {
    private EditText et_id,et_pass;
    private EditText et_nick;

    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private FirebaseFirestore mStore= FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_nick=findViewById(R.id.et_name);
        hideActionBar();

        findViewById(R.id.btn_register).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
         String id= et_id.getText().toString();
         String pass=et_pass.getText().toString();

        mAuth.createUserWithEmailAndPassword(id, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String id= et_id.getText().toString();
                            String pass=et_pass.getText().toString();
                            String nick=et_nick.getText().toString();

                            FirebaseUser user = mAuth.getCurrentUser();
                            Map<String,Object>userMap=new HashMap<>();
                            userMap.put(FirebaseId.documentId,user.getUid());
                            userMap.put(FirebaseId.nick,nick);
                            userMap.put(FirebaseId.email,id);
                            userMap.put(FirebaseId.password,pass);
                            mStore.collection(FirebaseId.user).document(user.getUid()).set(userMap, SetOptions.merge());
                            finish();
                            Toast.makeText(register.this, "회원가입 성공", Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(register.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    public void onClickedback(View v){
        Intent intent=new Intent(getApplicationContext(),Login.class);
        startActivity(intent);
    }
    public  void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }
    }

}
