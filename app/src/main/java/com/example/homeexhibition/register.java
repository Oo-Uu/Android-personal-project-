package com.example.homeexhibition;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class register extends AppCompatActivity {
    private EditText et_id,et_pass,et_name,et_nick;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);
        et_name=findViewById(R.id.et_name);
        //et_nick=findViewById(R.id.et_nick);
       //회원가입 버튼 클릭 시 수행
        hideActionBar();
        btn_register=findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID=et_id.getText().toString();
                String userpPass=et_pass.getText().toString();
                String userName=et_name.getText().toString();
               // String userNick=et_nick.getText().toString();

                Response.Listener<String> responseListener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            boolean success= jsonObject.getBoolean("success");
                            if(success){// 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원 가입이 완료되었습니다",Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(register.this,Login.class);
                                startActivity(intent);
                            }
                            else{//회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(),"회원 가입에 실패하였습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest=new RegisterRequest(userID,userpPass,userName,"",responseListener);
                RequestQueue queue= Volley.newRequestQueue(register.this);
                queue.add(registerRequest);

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
