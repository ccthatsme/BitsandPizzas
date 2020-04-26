package com.hfad.bitsandpizzas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class PizzaDetailActivity extends AppCompatActivity {

    public static final String Extra_PIZZA_ID = "pizzaId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        //set the toolbar as the activitys app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //display details of the pizza
        int pizaId = (Integer) getIntent().getExtras().get(Extra_PIZZA_ID);
        String pizzaName = Pizza.pizzas[pizaId].getName();
        TextView tv = (TextView) findViewById(R.id.pizza_text);
        tv.setText(pizzaName);
        int pizzaImage = Pizza.pizzas[pizaId].getImageResourceId();
        ImageView iv = (ImageView) findViewById(R.id.pizza_image);

        iv.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage));
        iv.setContentDescription(pizzaName);
    }


}
