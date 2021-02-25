package com.zeekzone.justjavahz;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    int quantity = 0;
    int unitPrice = 5;
    boolean hasWhippedCream = false;
    boolean hasChocolate = false;

    /**
     * This Method is called when the button Order is clicked
     * @param view
     */

    public void submitOrder(View view){
        int price = calculatePrice(quantity, unitPrice);
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

    /**
     *
     * @param view
     * @return
     */
    public void addWhippedCream(View view){
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_chekcbox);
        hasWhippedCream = whippedCreamCheckBox.isChecked();
    }

    /**
     *
     * @param view
     * @return
     */
    public void addChocolate(View view){
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        hasChocolate = chocolateCheckBox.isChecked();
    }

    /**
     *
     * Creates an order summary string and returns it
     * @param price
     * @return
     */
    private String createOrderSummary(int price){
        String name = getClientNAme();
        String message = "Name : "+ name;
        message += "\nAdd whipped cream? " + hasWhippedCream;
        message += "\nAdd chocolate? " + hasChocolate;
        message += "\nQuantity : " + quantity + "\nTotal: $" + price + "\nThank you!";
        return message;
    }

    private String getClientNAme(){
        EditText nameEditText = findViewById(R.id.name_view);
        return nameEditText.getText().toString();
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