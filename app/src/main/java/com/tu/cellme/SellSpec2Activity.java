package com.tu.cellme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class SellSpec2Activity extends AppCompatActivity {
    ArrayList<String> specChecked=new ArrayList<String>();
    private CheckBox c1;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;
    private CheckBox c5;
    private CheckBox c6;
    private Button nextButton;

    //private CheckBox c7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_spec2);
        c1=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById(R.id.checkBox2);
        c3=(CheckBox)findViewById(R.id.checkBox3);
        c4=(CheckBox)findViewById(R.id.checkBox4);
        c5=(CheckBox)findViewById(R.id.checkBox5);
        c6=(CheckBox)findViewById(R.id.checkBox6);
        nextButton=(Button)findViewById(R.id.nextButton);


        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int base_price=0;
                String mob_name=getIntent().getExtras().getString("mobileName");
                //String model_no=getIntent().getStringExtra("modelNo");
               // if(mob_name=="asus" && model_no=="ze500kl")
                //   base_price=3500;
              //  if(mob_name=="asus" && model_no=="ze550ml")
                  //  base_price=4000;
                if(mob_name.equals("asus") )

                {
                    mob_name="Microsoft";
                    base_price = 7000;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-500;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-600;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-1000;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-1050;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-1500;
                    }
                }
                if(mob_name.equals("blackberry"))

                {
                    base_price=3000;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-300;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-200;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-100;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-250;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-600;
                    }
                }
                if(mob_name.equals("samsung"))

                {
                    base_price=5000;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-300;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-200;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-100;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-250;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-600;
                    }
                }
                if(mob_name.equals("mi"))


                {
                    base_price=4000;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-300;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-200;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-100;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-250;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-600;
                    }
                }
                if(mob_name.equals("oppo"))

                {
                    base_price=5500;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-300;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-200;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-100;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-250;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-600;
                    }
                }
                if(mob_name.equals("vivo"))

                {
                    base_price=5500;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-300;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-200;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-100;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-250;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-600;
                    }
                }
                if(mob_name.equals("micromax"))

                {
                    base_price=2000;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-300;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-200;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-100;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-250;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-600;
                    }
                }
                if(mob_name.equals("oneplus"))

                {

                    base_price=14000;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-300;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-200;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-100;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-250;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-600;
                    }
                }
                if(mob_name.equals("lenovo"))

                {
                    base_price=2000;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-300;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-200;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-100;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-250;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-600;
                    }
                }
                if(mob_name.equals("nokia"))

                {
                    base_price=4000;
                    if(c1.isChecked()){
                        specChecked.add("Display/Touchpad Issue/Decolouration");
                        base_price=base_price-300;

                    }
                    if(c2.isChecked()){
                        specChecked.add("Front Camera Not Working");
                        base_price=base_price-200;
                    }
                    if(c3.isChecked()){
                        specChecked.add("Back Camera Not Workingor Faulty");
                        base_price=base_price-100;
                    }
                    if(c4.isChecked()){
                        specChecked.add("Volume Button Defect");
                        base_price=base_price-100;
                    }
                    if(c5.isChecked()){
                        specChecked.add("Power Button Faulty/Not Working");
                        base_price=base_price-250;
                    }
                    if(c6.isChecked()){
                        specChecked.add("Faulty Battery");
                        base_price=base_price-600;
                    }
                }


                String k=String.valueOf(base_price);

                Intent priceIntent=new Intent(SellSpec2Activity.this,PriceActivity.class);
                priceIntent.putStringArrayListExtra("result1",specChecked);
                //priceIntent.putExtra("mobileName",getIntent().getExtras().getString("mobileName"));
                priceIntent.putExtra("mobileName",mob_name);
                priceIntent.putExtra("modelNo",getIntent().getExtras().getString("modelNo"));
                priceIntent.putExtra("price",k);
                priceIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(priceIntent);

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
            startActivity(new Intent(SellSpec2Activity.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

}
