package com.example.onkar.babywords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    ImageButton myImageButton;
    ImageButton myImageButtonone;
    ImageButton myImageButtontwo;
    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        myImageButton = findViewById(R.id.imagealphbtn);
        myImageButtonone = findViewById(R.id.imagenumbtn);
        myImageButtontwo = findViewById(R.id.imagenurbtn);


        myImageButtonone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Numbers.class);
            }
        });


        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Alfabets.class);
            }
        });

        myImageButtontwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Nurcery.class);
            }
        });

        btnLogout  = findViewById(R.id.logout);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(Home.this,Register.class);
                startActivity(intToMain);
            }
        });


    }
}