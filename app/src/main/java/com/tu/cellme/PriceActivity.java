package com.tu.cellme;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PriceActivity extends AppCompatActivity {
    private TextView mobile_name;
    private TextView model;
    private TextView specs;
    private TextView price;
    private Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        mobile_name=(TextView)findViewById(R.id.mobileName);
        model=(TextView)findViewById(R.id.spec_id3);
        proceed=(Button)findViewById(R.id.proceed_button);

        price=(TextView)findViewById(R.id.price);
        price.setText(getIntent().getExtras().getString("price"));


        //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
       mobile_name.setText(getIntent().getExtras().getString("mobileName"));
        model.setText(getIntent().getExtras().getString("modelNo"));
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder buyAlert=new AlertDialog.Builder(PriceActivity.this);
                buyAlert.setTitle("Confirm sell..");
                buyAlert.setMessage("Are you sure to sell your cell?");
                buyAlert.setIcon(R.drawable.cell_icon);
                buyAlert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent address_intent=new Intent(PriceActivity.this,SellAddressActivity.class);
                        address_intent.putExtra("price",price.getText().toString());
                        address_intent.putExtra("model",model.getText().toString());
                        address_intent.putExtra("mobile",mobile_name.getText().toString());

                        address_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(address_intent);
                    }
                });
                buyAlert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                buyAlert.show();
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
            startActivity(new Intent(PriceActivity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
