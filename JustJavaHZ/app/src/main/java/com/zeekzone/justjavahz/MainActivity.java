package com.zeekzone.justjavahz;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
    int quantity = 0;
    int unitPrice = 5;
    public void submitOrder(View view){
        int price = calculatePrice(quantity, unitPrice);
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

    /**
     * Creates an order summary string and returns it
     * @param price
     * @return
     */
    private String createOrderSummary(int price){
        String s = "Name : Hassan Zekkouri\nQuantity : " + quantity + "\nTotal: $" + price + "\nThank you!";
        return s;
    }

    /**
     * This Method is called when the button + is clicked
     * @param view
     */
    public void increment(View view){
        quantity = quantity +1;
        displayQuantity(quantity);
    }

    /**
     * This Method is called when the button - is clicked
     * @param view
     */
    public void decrement(View view){
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method changes the quantity text to display number
     * @param number
     */
    private void displayQuantity(int number){
        TextView textView = (TextView) findViewById(R.id.quantity_text_view);
        textView.setText("" + number);
    }


    /**
     * This method changes the price to display the message
     * @param message
     */
    private void displayMessage(String message){
        TextView textView = (TextView) findViewById(R.id.order_summary_text_view);
        textView.setText(message);
    }

    /**
     * Calculates yhr price base on the quantity specified!
     * @param quantity of cups ordered
     * @param unitPrice is thge price of one cup  of coffee
     * @return
     */
    private int calculatePrice(int quantity, int unitPrice){
        int price;
        price = quantity * unitPrice;
        return price;
    }

}