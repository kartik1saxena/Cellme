package com.tu.cellme;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SellSpecActivity extends AppCompatActivity {
    private AutoCompleteTextView mModel;
    private Button yesButton;
    private Button noButton;
    private DatabaseReference mSellSpecDatabase;
    String[] model_asus;
    String[] model_lenovo;
    String[] model_onePlus;
    String[] model_samsung;
    String[] model_oppo;
    String[] model_vivo;
    String[] model_microsoft;
    String[] model_micromax;
    String[] model_mi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_spec);
        mModel=(AutoCompleteTextView)findViewById(R.id.modelText);
        yesButton=(Button)findViewById(R.id.nextButton);
        noButton=(Button)findViewById(R.id.noButton);
        model_lenovo=getResources().getStringArray(R.array.model_lenovo);
        model_onePlus=getResources().getStringArray(R.array.model_oneplus);
        model_samsung=getResources().getStringArray(R.array.model_samsung);
        model_oppo=getResources().getStringArray(R.array.model_oppo);
        model_vivo=getResources().getStringArray(R.array.model_vivo);
        model_microsoft=getResources().getStringArray(R.array.model_microsoft);
        model_mi=getResources().getStringArray(R.array.model_mi);
        //model_apple=getResources().getStringArray(R.array.model_apple);
        model_micromax=getResources().getStringArray(R.array.model_micromax);
       // final ArrayAdapter<String> model_asus1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_asus);

        final   ArrayAdapter<String> model_oneplus1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_onePlus);
        final ArrayAdapter<String> model_lenovo1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_lenovo);
        final ArrayAdapter<String> model_samsung1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_samsung);

        final ArrayAdapter<String> model_oppo1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_oppo);
        final ArrayAdapter<String> model_vivo1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_vivo);
        final ArrayAdapter<String> model_microsoft1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_microsoft);
        final ArrayAdapter<String> model_mi1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_mi);
      //  final ArrayAdapter<String> model_apple1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_apple);
        final ArrayAdapter<String> model_micromax1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_micromax);


        mSellSpecDatabase= FirebaseDatabase.getInstance().getReference().child("Sell");
       noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent noButtonIntent=new Intent(SellSpecActivity.this,NoButtonActivity.class);
                noButtonIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(noButtonIntent);
                AlertDialog.Builder buyAlert=new AlertDialog.Builder(SellSpecActivity.this);
                buyAlert.setTitle("Sorry!!");
                buyAlert.setMessage("Your device seem to have very little value due to its condition.We will not be able to offer you a resale quote for it.Please consider recycling it.");
                buyAlert.setIcon(R.drawable.cell_icon);
                buyAlert.setPositiveButton("Sell Another device?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent address_intent=new Intent(SellSpecActivity.this,SellActivity.class);

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
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelNext();
            }
        });

    }

    private void modelNext() {
        String modelNo=mModel.getText().toString();
        if(!TextUtils.isEmpty(modelNo)){
           // String mobile=getIntent().getExtras().getString("MobileName");
           // DatabaseReference model_db=mSellSpecDatabase.push();
            //model_db.child("Model No").setValue(modelNo);
            //model_db.child("Mobile").setValue(mobile);


            Intent spec2_Intent=new Intent(SellSpecActivity.this,SellSpec2Activity.class);
            spec2_Intent.putExtra("modelNo",modelNo);
            spec2_Intent.putExtra("mobileName",getIntent().getExtras().getString("mobileName"));
            spec2_Intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(spec2_Intent);



        }
        else Toast.makeText(getApplicationContext(),"Enter Your Model!",Toast.LENGTH_LONG).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home){
            startActivity(new Intent(SellSpecActivity.this,MainActivity.class));
        }
       // if(item.getItemId()==R.id.action_logout)
         //   logout();
        return super.onOptionsItemSelected(item);
    }
}
