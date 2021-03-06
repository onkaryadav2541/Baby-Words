package com.example.onkar.babywords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText emailId, password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.txtEmail);
        password = findViewById(R.id.txtPwd);
        btnSignUp = findViewById(R.id.btnLogin);
        tvSignIn = findViewById(R.id.lnkRegister);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()){
                    emailId.setError("Please enter email id ");
                    emailId.requestFocus();
                }
                else if (pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if (email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Register.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();

                }
                else if(!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(Register.this,"SignUP Unsuccessful",Toast.LENGTH_SHORT).show();

                            }
                            else {
                                startActivity(new Intent(Register.this,Home.class));
                            }
                        }
                    });

                }
                else {
                    Toast.makeText(Register.this,"Error Ocurred!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this,Babylogin.class);
                startActivity(i);
            }
        });
    }
}