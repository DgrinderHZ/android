package com.zeekzone.justjavahz;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    int quantity = 1;
    int unitPrice = 5;

    /**
     * This Method is called when the button Order is clicked
     * @param view
     */

    public void submitOrder(View view){

        // Check if the whipped cream is included.
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_chekcbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Check if the chocolate is included.
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        int price = calculatePrice(quantity, unitPrice, hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate);
        composeEmail("Android testing", priceMessage);
    }


    /**
     *
     * Creates an order summary string and returns it
     * @param price
     * @return
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate){
        String name = getClientNAme();
        String message = "Name : "+ name;
        message += "\nAdd whipped cream? " + hasWhippedCream;
        message += "\nAdd chocolate? " + hasChocolate;
        message += "\nQuantity : " + quantity + "\nTotal: $" + price;
        message += "\n" + getResources().getString(R.string.thank_you);
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
        if (quantity >= 100){
            popUpAtoast("You can not have more than 100 cups!");
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This Method is called when the button - is clicked
     * @param view
     */
    public void decrement(View view){
        if (quantity <= 1){
            popUpAtoast("You can not have less than 1 cup!");
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private void popUpAtoast(String toastMessage){
        Context context = getApplicationContext();
        CharSequence text = toastMessage;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    /**
     * This method changes the quantity text to display number
     * @param number
     */
    private void displayQuantity(int number){
        TextView textView = findViewById(R.id.quantity_text_view);
        textView.setText("" + number);
    }




    /**
     * Calculates yhr price base on the quantity specified!
     * @param quantity of cups ordered
     * @param unitPrice is thge price of one cup  of coffee
     * @return
     */
    private int calculatePrice(int quantity, int unitPrice, boolean hasWhippedCream, boolean hasChocolate){
        int price = unitPrice;
        // Check if the whipped cream is included.
        if (hasWhippedCream) price++;
        // Check if the chocolate is included.
        if(hasChocolate) price++;
        price = quantity * price ;
        return price;
    }

    public void composeEmail( String subject, String body) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}