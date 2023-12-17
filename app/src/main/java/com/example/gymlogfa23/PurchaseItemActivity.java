package com.example.gymlogfa23;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PurchaseItemActivity extends AppCompatActivity {

    private EditText mCardNumberEditText;
    private EditText mCvvEditText;
    private Button mPurchaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_item);

        // Initialize views
        mCardNumberEditText = findViewById(R.id.editTextCardNumber);
        mCvvEditText = findViewById(R.id.editTextCVV);
        mPurchaseButton = findViewById(R.id.buttonPurchase);

        mPurchaseButton.setOnClickListener(view -> purchaseItem());
    }

    private void purchaseItem() {
        String cardNumber = mCardNumberEditText.getText().toString().trim();
        String cvv = mCvvEditText.getText().toString().trim();

        if (TextUtils.isEmpty(cardNumber) || TextUtils.isEmpty(cvv)) {
            Toast.makeText(this, "Please enter card details", Toast.LENGTH_SHORT).show();
            return;
        }

        //purchase logic?

        Toast.makeText(this, "Item purchased successfully", Toast.LENGTH_SHORT).show();

        finish();
    }
}