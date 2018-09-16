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

public class SellAddressActivity extends AppCompatActivity {
    private DatabaseReference add_database;
    private TextView name;
    private TextView mobileNo;
    private TextView address;
    private TextView city;
    private TextView state;
    private Button proceed;
    private ProgressDialog aProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_address);
        add_database= FirebaseDatabase.getInstance().getReference().child("Rent_Requests");
        name=(TextView)findViewById(R.id.name);
        mobileNo=(TextView)findViewById(R.id.mobileNo);
        address=(TextView)findViewById(R.id.adress);
        city=(TextView)findViewById(R.id.city);
        state=(TextView)findViewById(R.id.state);
        aProgress=new ProgressDialog(this);

        proceed=(Button)findViewById(R.id.proceed_BUTTON);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveDetails();



            }
        });
    }

    private void saveDetails() {
        String user_name=name.getText().toString();
        String user_address=address.getText().toString();
        String user_mobile=mobileNo.getText().toString();
        String user_city=city.getText().toString();
        String user_state=state.getText().toString();
        if(!TextUtils.isEmpty(user_name) && !TextUtils.isEmpty(user_address)&& !TextUtils.isEmpty(user_mobile)&& !TextUtils.isEmpty(user_city)&& !TextUtils.isEmpty(user_address)  ){
            aProgress.setMessage("Fetching Details..");
            aProgress.show();
            DatabaseReference user_db=add_database.push();
            user_db.child("mobile brand").setValue(getIntent().getExtras().getString("mobile"));
            //user_db.child("model no").setValue(getIntent().getExtras().getString("model"));
            //user_db.child("cell_me price").setValue(getIntent().getExtras().getString("price"));
            user_db.child("user name").setValue(user_name);


            user_db.child("user mobile number").setValue(user_mobile);
            user_db.child("user address").setValue(user_address);
            user_db.child("user city").setValue(user_city);
            user_db.child("user state").setValue(user_state);
            aProgress.dismiss();
            //Toast.makeText(getApplicationContext(),"Your Details Are Saved",Toast.LENGTH_LONG).show();
            //Intent confirm_intent=new Intent(SellAddressActivity.this,ConfirmationActivity.class);
            //confirm_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            //startActivity(confirm_intent);
            AlertDialog.Builder buyAlert=new AlertDialog.Builder(SellAddressActivity.this);
            buyAlert.setTitle("Thank You!");
            buyAlert.setMessage("Thankyou for showing your faith in us.Your item is on the way.");
            buyAlert.setPositiveButton("HOME", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent address_intent=new Intent(SellAddressActivity.this,MainActivity.class);

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
        else
            Toast.makeText(getApplicationContext(),"Fields are Empty",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home){
            startActivity(new Intent(SellAddressActivity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);

    }
}
