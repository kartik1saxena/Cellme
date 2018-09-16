package com.tu.cellme;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class BuyMobilePartActivity extends AppCompatActivity {
    private Button price_button;
    private AutoCompleteTextView brand;
    private AutoCompleteTextView model;
    private AutoCompleteTextView part;
    String[] brand_names;
    String[] model_asus;
    String[] model_lenovo;
    String[] model_onePlus;
    String[] model_samsung;
    String[] mob_part;
    String[] model_oppo;
    String[] model_vivo;
    String[] model_microsoft;
    String[] model_micromax;
    String[] model_mi;
    String[] model_apple;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_mobile_part);
        brand=(AutoCompleteTextView)findViewById(R.id.mob_brand);
        model=(AutoCompleteTextView)findViewById(R.id.model_num);
        part=(AutoCompleteTextView)findViewById(R.id.mob_part);
        price_button=(Button)findViewById(R.id.price_button1);
        brand_names=getResources().getStringArray(R.array.brand_names);

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



        mob_part=getResources().getStringArray(R.array.mob_parts);

        ArrayAdapter<String> brand_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,brand_names);
        brand.setAdapter(brand_adapter);


        final ArrayAdapter<String> model_asus1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_asus);
        final   ArrayAdapter<String> model_oneplus1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_onePlus);
        final ArrayAdapter<String> model_lenovo1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_lenovo);
        final ArrayAdapter<String> model_oppo1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_oppo);
        final ArrayAdapter<String> model_vivo1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_vivo);
        final ArrayAdapter<String> model_microsoft1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_microsoft);
        final ArrayAdapter<String> model_mi1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_mi);
        final ArrayAdapter<String> model_apple1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_apple);
        final ArrayAdapter<String> model_micromax1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_micromax);
        final ArrayAdapter<String> model_samsung1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,model_samsung);


        brand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s1=brand.getText().toString();

                if(s1.equals("Asus"))
                    model.setAdapter(model_asus1);

                if(s1.equals("One Plus"))
                    model.setAdapter(model_oneplus1);
                if(s1.equals("Lenovo"))
                    model.setAdapter(model_lenovo1);
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
                if(s1.equals("Samsung"))
                    model.setAdapter(model_samsung1);


            }
        });
        ArrayAdapter<String> mob_part1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,mob_part);
        part.setAdapter(mob_part1);
        price_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price=database();

               // String p_string=String.valueOf(price);
                final String mob_brand = brand.getText().toString();
                final String mob_model = model.getText().toString();
                final String mob_part=part.getText().toString();
                if(price!=0){
                    //Toast.makeText(getApplicationContext(),"Price is"+ Integer.toString(price),Toast.LENGTH_LONG).show();
                    AlertDialog.Builder buyAlert=new AlertDialog.Builder(BuyMobilePartActivity.this);
                    buyAlert.setTitle("Confirm Buy?");
                    buyAlert.setMessage("Price is "+price);
                    buyAlert.setIcon(R.drawable.cell_bg);
                    buyAlert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent address_intent=new Intent(BuyMobilePartActivity.this,BuyMobileAddressActivity.class);
                            address_intent.putExtra("brand",mob_brand);
                            address_intent.putExtra("model",mob_model);
                            address_intent.putExtra("part",mob_part);

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
                    Toast.makeText(getApplicationContext(),"Required Part Not Found",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(),"Try Another Phone/Model/Part Combination",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private int database() {
        int price=0;
        try {
            String mob_brand = brand.getText().toString();
            String mob_model = model.getText().toString();
            String mob_part=part.getText().toString();
            Log.i("brand", mob_brand);
            Log.i("model", mob_model);
            Log.i("part",mob_part);

            SQLiteDatabase buy_part_Database = this.openOrCreateDatabase("Buy_Mobile_Part1", MODE_PRIVATE, null);
            buy_part_Database.execSQL("CREATE TABLE IF NOT EXISTS buy_mobile_part1 (mobile_brand STRING, model_no STRING, part STRING, price INT(5))");

            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Asus','Zenfone2 Ze551ml','battery',3500)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Asus','Zenfone2 Ze550ml','charger',3000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Asus','Zenfone3 Ze551ml','mother board',4500)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Asus','Zenfone3 Ze551ml','screen',4500)");


            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Lenovo','K4 note','battery',4000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Lenovo','K3 note','charger',2000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Lenovo','K5 note','mother board',6000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Lenovo','K3 note','screen',2000)");




            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('One Plus','oneplus 1','battery',5000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('One Plus','oneplus 2','charger',13000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('One Plus','oneplus 3','ram',1000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('One Plus','oneplus 4','mother board',15000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('One Plus','oneplus 4','screen',5000)");



            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Vivo','Vivo V5s','battery',5000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Vivo','Vivo V55s','charger',6000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Vivo','Vivo V5','mother board',7000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Vivo','Vivo V55s','screen',6000)");

            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Mi','Redmi 4i','battery',2000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Mi','Redmi Note 4i','charger',1000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Mi','Redmi 4','mother board',2000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Mi','Redmi Note 4i','screen',800)");



            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Oppo','Oppo A57','battery',2000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Oppo','Oppo A37 ','charger',3000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Oppo','Oppo ',' mother board',7000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Oppo','Oppo A37 ','screen',2000)");



            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Micromax','Canvas1','battery',1000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Micromax','Canvas2','charger',500)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Micromax','Canvas3','mother board',2000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Micromax','Canvas2','screen',500)");



            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Microsoft','Lumia 650','battery',1000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Microsoft','Lumia 950 XL Dual SIM','charger',1500)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Microsoft','Lumia 950 XL','mother board',2000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Microsoft','Lumia 650','screen',1000)");



            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Apple','iPhone 5S','battery',5000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Apple','iPhone 6s','charger',6000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Apple','iPhone 7s','mother board',10000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Apple','iPhone 6s','screen',4000)");



            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Samsung','S2 ','battery',5000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Samsung','S3 ','charger',6000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Samsung','S4 ','mother board',7000)");
            buy_part_Database.execSQL("INSERT INTO buy_mobile_part1 (mobile_brand, model_no,part, price) VALUES('Samsung','S3 ','screen',2000)");








            Cursor c = buy_part_Database.rawQuery("SELECT * FROM buy_mobile_part1 WHERE mobile_brand='" + mob_brand + "' AND model_no ='" + mob_model + "'AND part='" + mob_part + "'", null);

            int priceIndex = c.getColumnIndex("price");

            c.moveToFirst();

            while (c != null) {
                price=c.getInt(priceIndex);


               // Toast.makeText(getApplicationContext(),"Price is"+ Integer.toString(c.getInt(priceIndex)),Toast.LENGTH_LONG).show();
                c.moveToNext();
                //Toast.makeText(getApplicationContext(),c.getInt(priceIndex),Toast.LENGTH_LONG).show();
            }
            if(!TextUtils.isEmpty(mob_brand) &&!TextUtils.isEmpty(mob_model) && !TextUtils.isEmpty(mob_model)){
                return price;
            }
            else return 0;

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
            startActivity(new Intent(BuyMobilePartActivity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
