package com.example.homeexhibition;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {
    private SignInButton btn_google; //구글 로그인 버튼
    private FirebaseAuth auth; //파이어 베이스 인증 객체
    private GoogleApiClient googleApiClient; //구글 API 믈라이언트 객체
    private static final int REQ_SIGN_GOOGLE=100; //구글 로그인 결과 코드

    public EditText et_id,et_pass;
    private Button btn_register;

    private FirebaseAuth mAuth=FirebaseAuth.getInstance();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {//앱이 실행될때 처음 수행
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        hideActionBar();

        GoogleSignInOptions googleSignInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();

        googleApiClient=new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions)
                .build();

        auth=FirebaseAuth.getInstance(); //파이어베이스 인증 객체 초기화

        btn_google=findViewById(R.id.btn_google);
        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,REQ_SIGN_GOOGLE);
            }
        });

        et_id=findViewById(R.id.et_id);
        et_pass=findViewById(R.id.et_pass);
        btn_register=findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login.this,register.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_login).setOnClickListener(this);
    }
    @Override
    protected  void onStart(){
        super.onStart();
        FirebaseUser user =mAuth.getCurrentUser();
        if(user !=null){
            Toast.makeText(this,"자동 로그인 "+user.getUid(),Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View v) {
        String userID=et_id.getText().toString();
        String pass=et_pass.getText().toString();
        mAuth.signInWithEmailAndPassword(userID, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String userID=et_id.getText().toString();
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Login.this, "로그인 성공: "+user.getUid(), Toast.LENGTH_SHORT).show();

                            Intent intent= new Intent(Login.this,Main2Activity.class);
                            intent.putExtra("userID",userID);
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_SIGN_GOOGLE){
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()==true){ //인증결과가 성공적이면...
                GoogleSignInAccount account=result.getSignInAccount();// account 라는 데이터는 구글로그인 정보를 담고 있다.
                resultLogin(account); //로그인 결과 값 출력 메소드
            }
        }
    }

    private void resultLogin(final GoogleSignInAccount account) {
        AuthCredential credential= GoogleAuthProvider.getCredential(account.getIdToken(),null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){// 로그인에 성공할 경우
                            Toast.makeText(getApplicationContext(),"로그인 성공",Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(),Loginresult.class );
                            intent.putExtra("nickname",account.getDisplayName());
                            intent.putExtra("photUrl",String.valueOf(account.getPhotoUrl()));// String.valueOf:특정 자료형 String으로
                            startActivity(intent);
                        }
                        else{//로그인 실패
                            Toast.makeText(getApplicationContext(),"로그인 실패",Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    public  void hideActionBar() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }
    }

}
