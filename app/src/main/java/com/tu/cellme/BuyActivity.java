package com.tu.cellme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BuyActivity extends AppCompatActivity {
   // private Button fButton;
    private Button mButton;
    private Button mpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        //fButton=(Button)findViewById(R.id.feedbackButton);
        mButton=(Button)findViewById(R.id.mobileButton);
        mpButton=(Button)findViewById(R.id.mobilepart);
       /* fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent feedbackIntent= new Intent(BuyActivity.this, FeedbackActivity.class);
                feedbackIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(feedbackIntent);
            }
        });*/
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mobileIntent=new Intent(BuyActivity.this,BuyMobileActivity.class);
                mobileIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mobileIntent);
            }
        });
        mpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mobilepartIntent=new Intent(BuyActivity.this,BuyMobilePartActivity.class);
                mobilepartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mobilepartIntent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home){
            startActivity(new Intent(BuyActivity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

}
