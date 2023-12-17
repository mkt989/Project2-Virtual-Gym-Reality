package com.example.gymlogfa23;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class BuyOneGetOneFreeActivity extends AppCompatActivity {

    private EditText mItemNameEditText;
    private EditText mQuantityEditText;
    private TextView mTotalItemsTextView;
    private Button mPurchaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_one_get_one_free);

        mItemNameEditText = findViewById(R.id.editTextItemName);
        mQuantityEditText = findViewById(R.id.editTextQuantity);
        mTotalItemsTextView = findViewById(R.id.textViewTotalItems);
        mPurchaseButton = findViewById(R.id.buttonPurchase);

        mPurchaseButton.setOnClickListener(view -> buyOneGetOneFree());
    }

    private void buyOneGetOneFree() {
        String itemName = mItemNameEditText.getText().toString().trim();
        String quantityStr = mQuantityEditText.getText().toString().trim();

        if (TextUtils.isEmpty(itemName) || TextUtils.isEmpty(quantityStr)) {
            Toast.makeText(this, "Please enter item name and quantity", Toast.LENGTH_SHORT).show();
            return;
        }

        int quantity = Integer.parseInt(quantityStr);

        //Calculate the total items considering the buy one get one free offer
        int totalItems = calculateTotalItems(quantity);

        //Display the total items
        mTotalItemsTextView.setText(String.format("Total Items: %d", totalItems));
    }

    private int calculateTotalItems(int quantity) {
        //Calculate total items (considering buy one get one free offer)
        return quantity + (quantity / 2);
    }
}