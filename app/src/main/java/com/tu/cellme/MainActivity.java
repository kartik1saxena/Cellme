package com.tu.cellme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
   /* private EditText mEmail;
    private EditText mPassword;
    private Button mLogin;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
*/
   private FirebaseAuth mAuth;
   private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mDatabaseUsers;
    private Button mSell;
    private Button mBuy;
    private Button fButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSell=(Button)findViewById(R.id.sellButton);
        mBuy=(Button)findViewById(R.id.buyButton);
        fButton=(Button)findViewById(R.id.feedbackButton);
        mSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sellIntent= new Intent(MainActivity.this, RentActivity.class);

                sellIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sellIntent);
            }
        });
        mBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buyIntent= new Intent(MainActivity.this, SellActivity.class);
                buyIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(buyIntent);
            }
        });
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedbackIntent= new Intent(MainActivity.this, FeedbackActivity.class);
                feedbackIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(feedbackIntent);
            }
        });


        mAuth = FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()==null){
                    Intent loginIntent= new Intent(MainActivity.this, LoginActivity.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);


                }
            }
        };
       /* mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSignIn();
            }
        });*/

   // mDatabaseUsers= FirebaseDatabase.getInstance().getReference().child("Users");
     //   mDatabaseUsers.keepSynced(true);
    }
    /*private void checkUserExist() {
        if(mAuth.getCurrentUser()!=null){
            final String user_id=mAuth.getCurrentUser().getUid();
            mDatabaseUsers.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.hasChild(user_id)){
                        Intent mainIntent= new Intent(MainActivity.this, MainActivity.class);
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(mainIntent);

                    }else{
                        Toast.makeText(MainActivity.this,"Account required",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

    }
*/

    @Override
    protected void onStart() {
        super.onStart();
        //checkUserExist();
        mAuth.addAuthStateListener(mAuthListener);
    }




    /* private void startSignIn() {
        String mail = mEmail.getText().toString();
        String password = mPassword.getText().toString();
        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(password)){
            Toast.makeText(MainActivity.this, "Fields Are Empty", Toast.LENGTH_LONG).show();
        }

        else {
            mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Sign In Problem", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       // if(item.getItemId()==R.id.action_add){
         //   startActivity(new Intent(MainActivity.this,RegisterActivity.class));
        //}
        if(item.getItemId()==R.id.action_logout)
            logout();
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        mAuth.signOut();
    }
}