package com.example.searchforblood;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private Button CreateAccountButton;
    private EditText UserEmail,UserPassword;
    private TextView AlreadyHaveAccountLink;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();

        InitializeFields();

        AlreadyHaveAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendUserToLogActivity();

            }
        });

        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateNewAccount();
            }
        });
    }
    private void CreateNewAccount() {
        String email=UserEmail.getText().toString();
        String passward=UserPassword.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this,"please enter email.....",Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(passward))
        {
            Toast.makeText(this,"please enter passward.....",Toast.LENGTH_SHORT).show();
        }
        else
        {
            loadingBar.setTitle("Creating New Account ");
            loadingBar.setMessage("Please wait,while we are creating new account for you... ");
            loadingBar.setCanceledOnTouchOutside(true);
            loadingBar.show();


            mAuth.createUserWithEmailAndPassword(email, passward).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        SendUserToSaveActivity();
                        Toast.makeText(RegisterActivity.this,"Account Created Successfully",Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();

                    }
                    else
                    {
                        String message=task.getException().toString();
                        Toast.makeText(RegisterActivity.this,"Error : "+message,Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();

                    }

                }
            });
        }



    }
    private void InitializeFields() {
        CreateAccountButton=(Button)findViewById(R.id.register_button);
        UserEmail=(EditText)findViewById(R.id.register_email);
        UserPassword=(EditText)findViewById(R.id.register_password);
        AlreadyHaveAccountLink=(TextView)findViewById(R.id.already_have_account_link);
        loadingBar=new ProgressDialog(this);
    }

   private void SendUserToLogActivity() {

        Intent loginIntent=new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(loginIntent);
    }
    private void SendUserToSaveActivity() {

        Intent regIntent=new Intent(RegisterActivity.this,SaveDataActivity.class);
        startActivity(regIntent);
    }
}
