package com.tu.cellme;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FeedbackActivity extends AppCompatActivity {
    private TextView mFeedback;
    private Button mSubmit;
   // private StorageReference mStorage;
    private ProgressDialog mProgress;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Feedback");
        mFeedback=(TextView)findViewById(R.id.editText);
        mSubmit=(Button)findViewById(R.id.submitButton);
        mProgress=new ProgressDialog(this);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFeedback();
            }
        });
    }

    private void startFeedback() {

        String feedback=mFeedback.getText().toString();
        if(!TextUtils.isEmpty(feedback)){
            mProgress.setMessage("Posting..");
            mProgress.show();
            DatabaseReference feedback_db=mDatabase.push();
            feedback_db.child("feedback").setValue(feedback);
            mProgress.dismiss();
            AlertDialog.Builder buyAlert=new AlertDialog.Builder(FeedbackActivity.this);
            buyAlert.setTitle("Thank You For Your Feedback!");
            //buyAlert.setMessage("Your device seem to have very little value due to its condition.We will not be able to offer you a resale quote for it.Please consider recycling it.");
            buyAlert.setIcon(R.drawable.cell_icon);
            buyAlert.setPositiveButton("Home", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent address_intent=new Intent(FeedbackActivity.this,MainActivity.class);

                    address_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(address_intent);
                }
            });

            buyAlert.show();
        }
        else
            Toast.makeText(getApplicationContext(),"Fields are Empty!",Toast.LENGTH_SHORT).show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home){
            startActivity(new Intent(FeedbackActivity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
