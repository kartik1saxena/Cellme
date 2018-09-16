package com.tu.cellme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class NoButtonActivity extends AppCompatActivity {
    private Button sellAnotherButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_button);
        sellAnotherButton=(Button)findViewById(R.id.mButton);
        sellAnotherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_activity=new Intent(NoButtonActivity.this,SellActivity.class);
                main_activity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main_activity);
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
            startActivity(new Intent(NoButtonActivity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
