package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox WhippedCreamCheckBox= (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = WhippedCreamCheckBox.isChecked();
        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_cream_checkbox);
        boolean hasChocolate = ChocolateCheckBox.isChecked();
        EditText NameEditText = (EditText)findViewById(R.id.name_field);
        String value = NameEditText.getText().toString();
        createOrderSummary(quantity,10,hasWhippedCream,hasChocolate,value);
    }
    int quantity=0;
    public void increment(View view){
        display(++quantity);
    }

    public void decrement(View view){
        if(quantity>0)
        display(--quantity);
        else
            display(0);
    }

    public void createOrderSummary(int no,int pricePerCup,boolean addWhippedCream,boolean addChocolate,String name){
        String priceMessage="Name: "+name;
        priceMessage=priceMessage+"\nQuantity: "+no;
        priceMessage=priceMessage+"\nWhipped Cream Added?"+addWhippedCream;
        priceMessage=priceMessage+"\nChocolate Added?"+addChocolate;
        int total=no*pricePerCup;
        if(addWhippedCream)
        {
            total+=5;
        }
        if(addChocolate)
        {
            total+=5;
        }
        priceMessage=priceMessage+"\nTotal: Rs."+(total)+".00\nThank You!";
        displayMessage(priceMessage);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}