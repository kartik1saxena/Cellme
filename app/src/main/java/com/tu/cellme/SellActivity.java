package com.tu.cellme;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SellActivity extends AppCompatActivity {
    private Button fButton;
    private DatabaseReference mSellDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        mAuth = FirebaseAuth.getInstance();
        mSellDatabase= FirebaseDatabase.getInstance().getReference().child("Sell");
        fButton=(Button)findViewById(R.id.feedbackButton);
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedbackIntent= new Intent(SellActivity.this, FeedbackActivity.class);
                feedbackIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(feedbackIntent);
            }
        });
    }

    public void buttonTapped(View view){
        int id=view.getId();
        String ourId="";
        ourId=view.getResources().getResourceEntryName(id);
       // SharedPreferences pref = getApplicationContext().getSharedPreferences("New", Context.MODE_PRIVATE);
        //SharedPreferences.Editor edit = pref.edit();
        //edit.putString("mobileName", ourId);
        //edit.commit();
        //DatabaseReference sell_db=mSellDatabase.push();
        //String mId=mSellDatabase.push().getKey();
        //sell_db.child("Mobile Brand").setValue(ourId);
       // Intent priceIntent= new Intent(SellActivity.this, PriceActivity.class);
        //priceIntent.putExtra("mobileName",ourId);
        //startActivity(priceIntent);
       // priceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       Intent sellSpecIntent=new Intent(SellActivity.this,SellSpecActivity.class);
        sellSpecIntent.putExtra("mobile",ourId);
        startActivity(sellSpecIntent);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home){
            startActivity(new Intent(SellActivity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

}
