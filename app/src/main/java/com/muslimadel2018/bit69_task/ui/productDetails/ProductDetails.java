package com.muslimadel2018.bit69_task.ui.productDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.muslimadel2018.bit69_task.R;

public class ProductDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        TextView product_name=findViewById(R.id.product_name);
        Intent mIntent=getIntent();
        product_name.setText(mIntent.getStringExtra("NAME"));
    }
}
