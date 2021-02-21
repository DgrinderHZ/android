package com.zeekzone.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView firstTextView = findViewById(R.id.menu_item_1);
        Log.i("EnterpriseActivity.java", " *******1******* " + firstTextView.getText());

        // Find second menu item TextView and print the text to the logs
        TextView secondTextView = findViewById(R.id.menu_item_2);
        Log.i("EnterpriseActivity.java", " ******2******** " + secondTextView.getText());
        // Find third menu item TextView and print the text to the logs
        TextView thirdTextView = findViewById(R.id.menu_item_3);
        Log.i("EnterpriseActivity.java", " ******3******** " + thirdTextView.getText());
    }
}