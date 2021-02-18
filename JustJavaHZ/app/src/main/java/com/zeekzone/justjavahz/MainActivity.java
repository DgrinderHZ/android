package com.zeekzone.justjavahz;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This Method is called when the button Order is clicked
     * @param view
     */
    int quantity = 2;
    public void submitOrder(View view){
        display(quantity);
        displayPrice(quantity*2);
    }

    /**
     * This Method is called when the button + is clicked
     * @param view
     */
    public void increment(View view){
        quantity = quantity +1;
        display(quantity);
    }

    /**
     * This Method is called when the button - is clicked
     * @param view
     */
    public void decrement(View view){
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method changes the quantity text to display number
     * @param number
     */
    private void display(int number){
        TextView textView = (TextView) findViewById(R.id.quantity_text_view);
        textView.setText("" + number);
    }

    /**
     * This method changes the price to display number
     * @param number
     */
    private void displayPrice(int number){
        TextView textView = (TextView) findViewById(R.id.price_text_view);
        textView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
}