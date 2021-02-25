package com.hfad.bitsandpizza;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.hfad.bitsandpizza.data.Pizza;

public class PizzaDetailActivity extends AppCompatActivity {

    public static final String PIZZA_DETAIL_ID  = "PizzaDetailActivity/PizzaDetailID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int pizzaId = (int) getIntent().getExtras().get(PIZZA_DETAIL_ID);

        TextView textView = findViewById(R.id.pizza_detail_name);
        textView.setText(Pizza.pizzas[pizzaId].getName());

        ImageView imageView = findViewById(R.id.pizza_detail_img);
        imageView.setImageDrawable(ContextCompat.getDrawable(this,
                Pizza.pizzas[pizzaId].getImage()));
        imageView.setContentDescription(Pizza.pizzas[pizzaId].getName());
    }
}