package com.tu.cellme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Buy2Activity extends AppCompatActivity {
   private TextView t1;
    private TextView t2;
    private Button b1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy2);
        t1=(TextView)findViewById(R.id.item_id22);
        t2=(TextView)findViewById(R.id.spec_id3);
        b1=(Button)findViewById(R.id.price_button1);
    }
}
