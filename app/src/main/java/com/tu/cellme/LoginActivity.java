package com.tu.cellme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private EditText mLoginEmailField;
    private EditText mLoginPasswordField;
    private Button mLoginBtn;
    private Button mNewAccountBtn;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseUsers;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        mDatabaseUsers= FirebaseDatabase.getInstance().getReference().child("Users");
        mDatabaseUsers.keepSynced(true);

        mLoginEmailField=(EditText)findViewById(R.id.loginEmailField);
        mLoginPasswordField=(EditText)findViewById(R.id.loginPasswordField);
        mNewAccountBtn=(Button)findViewById(R.id.newAccountBtn);
        mProgress=new ProgressDialog(this);



        mNewAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent= new Intent(LoginActivity.this, RegisterActivity.class);
                registerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(registerIntent);
            }
        });
        mLoginBtn=(Button)findViewById(R.id.loginButton);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkLogin();
            }
        });
    }

    private void checkLogin() {
        String email=mLoginEmailField.getText().toString();
        String password=mLoginPasswordField.getText().toString();
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            mProgress.setMessage("Checking Login..");
            mProgress.show();
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        mProgress.dismiss();
                       /* mAuthListener=new FirebaseAuth.AuthStateListener() {
                            @Override
                            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                FirebaseUser currentUser = mAuth.getCurrentUser();

                                if(currentUser!=null){
                                    Intent mainIntent= new Intent(LoginActivity.this, MainActivity.class);
                                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    startActivity(mainIntent);

                                }
                            }
                        };*/
                        checkUserExist();

                    }else {
                        mProgress.dismiss();

                        Toast.makeText(LoginActivity.this,"Error Login! Need Account?",Toast.LENGTH_LONG).show();
                        Intent registerIntent= new Intent(LoginActivity.this, RegisterActivity.class);
                        registerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(registerIntent);

                    }
                }
            });
        }
        else if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            mProgress.dismiss();
            Toast.makeText(LoginActivity.this,"Error Login! Need Account?",Toast.LENGTH_LONG).show();
            Intent registerIntent= new Intent(LoginActivity.this, RegisterActivity.class);
            registerIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(registerIntent);
        }
    }


    private void checkUserExist() {
      final String user_id=mAuth.getCurrentUser().getUid();
        mDatabaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(user_id)){
                    Intent mainIntent= new Intent(LoginActivity.this, MainActivity.class);
                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(mainIntent);

                }else{
                    Toast.makeText(LoginActivity.this,"Account required",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
