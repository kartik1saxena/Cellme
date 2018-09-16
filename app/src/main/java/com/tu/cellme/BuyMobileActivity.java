package com.tu.cellme;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class BuyMobileActivity extends AppCompatActivity {
    //private TextView brand;
   // private TextView model;
    private Button price_button;
    private AutoCompleteTextView brand;
    private AutoCompleteTextView model;
    String[] brand_names;
    String[] model_asus;
    String[] model_lenovo;
    String[] model_onePlus;
    String[] model_samsung;
    String[] model_oppo;
    String[] model_vivo;
    String[] model_microsoft;
    String[] model_micromax;
    String[] model_mi;
    String[] model_apple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_mobile);
        brand=(AutoCompleteTextView) findViewById(R.id.item_id22);
        brand_names=getResources().getStringArray(R.array.brand_names);

        model=(AutoCompleteTextView) findViewById(R.id.spec_id3);
        model_asus=getResources().getStringArray(R.array.model_asus);
        model_lenovo=getResources().getStringArray(R.array.model_lenovo);
        model_onePlus=getResources().getStringArray(R.array.model_oneplus);
        model_samsung=getResources().getStringArray(R.array.model_samsung);
        model_oppo=getResources().getStringArray(R.array.model_oppo);
        model_vivo=getResources().getStringArray(R.array.model_vivo);
        model_microsoft=getResources().getStringArray(R.array.model_microsoft);
        model_mi=getResources().getStringArray(R.array.model_mi);
        model_apple=getResources().getStringArray(R.array.model_apple);
        model_micromax=getResources().getStringArray(R.array.model_micromax);




        ArrayAdapter<String> brand_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,brand_names);
        brand.setAdapter(brand_adapter);

       final ArrayAdapter<String> model_asus1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_asus);

      final   ArrayAdapter<String> model_oneplus1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_onePlus);
        final ArrayAdapter<String> model_lenovo1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_lenovo);
        final ArrayAdapter<String> model_samsung1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_samsung);

        final ArrayAdapter<String> model_oppo1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_oppo);
        final ArrayAdapter<String> model_vivo1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_vivo);
        final ArrayAdapter<String> model_microsoft1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_microsoft);
        final ArrayAdapter<String> model_mi1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_mi);
        final ArrayAdapter<String> model_apple1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_apple);
        final ArrayAdapter<String> model_micromax1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_micromax);

        brand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s1=brand.getText().toString();

                if(s1.equals("Asus")){

                    model.setAdapter(model_asus1);

                }

                if(s1.equals("One Plus")){
                    model.setAdapter(model_oneplus1);

                }
                if(s1.equals("Lenovo")){
                    model.setAdapter(model_lenovo1);

                }
                if(s1.equals("Apple"))
                    model.setAdapter(model_apple1);
                if(s1.equals("Oppo"))
                    model.setAdapter(model_oppo1);
                if(s1.equals("Vivo"))
                    model.setAdapter(model_vivo1);
                if(s1.equals("Micromax"))
                    model.setAdapter(model_micromax1);
                if(s1.equals("Microsoft"))
                    model.setAdapter(model_microsoft1);
                if(s1.equals("Mi"))
                    model.setAdapter(model_mi1);




            }
        });




        price_button=(Button) findViewById(R.id.price_button1);
        price_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               int price=database();
               final String mob_brand = brand.getText().toString();
               final String mob_model = model.getText().toString();
                if(price!=0){
                    //Toast.makeText(getApplicationContext(),"Price is"+ Integer.toString(price),Toast.LENGTH_LONG).show();
                    AlertDialog.Builder buyAlert=new AlertDialog.Builder(BuyMobileActivity.this);
                    buyAlert.setTitle("Confirm Buy?");
                    buyAlert.setMessage("Price is "+price);
                    buyAlert.setIcon(R.drawable.cell_bg);
                    buyAlert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent address_intent=new Intent(BuyMobileActivity.this,BuyMobileAddressActivity.class);
                            address_intent.putExtra("brand",mob_brand);
                            address_intent.putExtra("model",mob_model);

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
                {
                    Toast.makeText(getApplicationContext(),"Required Mobile Found",Toast.LENGTH_SHORT).show();
                   // Toast.makeText(getApplicationContext(),"Try Another Phone/Model/Part Combination",Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

    private int database() {
        int price=0;
        try {
            String mob_brand = brand.getText().toString();
            String mob_model = model.getText().toString();
            Log.i("brand", mob_brand);
            Log.i("model", mob_model);
            SQLiteDatabase buyDatabase = this.openOrCreateDatabase("Buy_Mobile", MODE_PRIVATE, null);
            buyDatabase.execSQL("CREATE TABLE IF NOT EXISTS buy_mobile (mobile_brand STRING, model_no STRING, price INT(5))");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Asus','Zenfone2 Ze551ml',3500)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Asus','Zenfone2 Ze550ml',3000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Asus','Zenfone3 Ze551ml',4500)");


            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Lenovo','K4 note ',4000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Lenovo','K3 note',2000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Lenovo','K5 note ',6000)");



            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('One Plus','oneplus 1',10000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('One Plus','oneplus 2',13000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('One Plus','oneplus 3',13000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('One Plus','oneplus 4',15000)");


            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Samsung','S1 ',4000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Samsung','S2 ',5000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Samsung','S3 ',6000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Samsung','S4 ',7000)");


            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Mi','Redmi 4i',3500)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Mi','Redmi Note 4',3000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Mi','Redmi 3s',4500)");


            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Oppo','Oppo A57',3500)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Oppo','Oppo A37',3000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Oppo','Oppo F5',4500)");


            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Vivo','Vivo V5s',3500)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Vivo','Vivo V55s',3000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Vivo','Vivo V5',4500)");


            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Micromax','Canvas1',1500)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Micromax','Canvas2',2000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Micromax','Canvas3',3500)");


            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Microsoft','Lumia 650',3000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Microsoft','Lumia 950 XL Dual SIM',4000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Microsoft','Lumia 950 XL',4500)");

            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Apple','iPhone 5S',10000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Apple','iPhone 7S',15000)");
            buyDatabase.execSQL("INSERT INTO buy_mobile (mobile_brand, model_no, price) VALUES('Apple','iPhone 6S',17000)");



            Cursor c = buyDatabase.rawQuery("SELECT * FROM buy_mobile WHERE mobile_brand='" + mob_brand + "' AND model_no ='" + mob_model + "' ", null);

            int priceIndex = c.getColumnIndex("price");

            c.moveToFirst();

            while (c != null) {
                 price=c.getInt(priceIndex);
                //Toast.makeText(getApplicationContext(),"Price is"+ Integer.toString(c.getInt(priceIndex)),Toast.LENGTH_LONG).show();
                c.moveToNext();
                //Toast.makeText(getApplicationContext(),c.getInt(priceIndex),Toast.LENGTH_LONG).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home){
            startActivity(new Intent(BuyMobileActivity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
