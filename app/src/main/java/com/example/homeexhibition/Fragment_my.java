package com.example.homeexhibition;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class Fragment_my extends Fragment {
    private final int GET_GALLERY_IMAGE = 200;
    private ImageView imageview;
    private TextView tv_nick;

    private FirebaseAuth mAuth= FirebaseAuth.getInstance();
    private FirebaseFirestore mStore=FirebaseFirestore.getInstance();

    private Button btn_logout;

    private String nick;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        imageview = view.findViewById(R.id.imageView);
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });
        tv_nick=view.findViewById(R.id.tv_nick);
        /*Bundle bundle= getArguments();
        String nick=bundle.getString("userID");
        tv_nick.setText(nick);
        */
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
        tv_nick.setText(nick);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == GET_GALLERY_IMAGE && data != null && data.getData() != null) {

            Uri selectedImageUri = data.getData();
            imageview.setImageURI(selectedImageUri);
        }
    }

}

