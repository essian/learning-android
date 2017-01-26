package com.example.essian.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 99;
    int cost = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream);
        Boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate);
        Boolean hasChocolate = chocolateCheckbox.isChecked();

        EditText nameText = (EditText) findViewById(R.id.name_text);
        String name = nameText.getText().toString();

        Log.i("main activity", name.toString());
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, name);
        displayMessage(priceMessage);
//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
//        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }

    public void increment(View view) {
        if (quantity >= 100) {
            Toast.makeText(this, "You cannot order more than 100 cups", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(this, "You must order at least 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int itemCost = cost;
        if (hasChocolate) {
            itemCost += 2;
        }
        if (hasWhippedCream) {
            itemCost += 1;
        }
        return quantity * itemCost;
    }

    /**
     * generates an order summary
     *
     * @param price           is the total cost of the order
     * @param hasWhippedCream defines whether the customer wants whipped cream
     * @return the order summary
     */

    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name) {
        String orderSummary = getString(R.string.order_name, name);
        orderSummary += getString(R.string.order_has_cream, hasWhippedCream);
        orderSummary += getString(R.string.order_has_choc, hasChocolate);
        orderSummary += getString(R.string.order_quantity, quantity);
        orderSummary += getString(R.string.order_total, price);
        orderSummary += getString(R.string.thank_you);
        return orderSummary;
    }

}