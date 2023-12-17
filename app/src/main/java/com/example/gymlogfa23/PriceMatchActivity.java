package com.example.gymlogfa23;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PriceMatchActivity extends AppCompatActivity {

    private EditText mItemNameEditText;
    private EditText mCurrentPriceEditText;
    private EditText mCompetitorPriceEditText;
    private TextView mMatchResultTextView;
    private Button mMatchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_match);

        mItemNameEditText = findViewById(R.id.editTextItemName);
        mCurrentPriceEditText = findViewById(R.id.editTextCurrentPrice);
        mCompetitorPriceEditText = findViewById(R.id.editTextCompetitorPrice);
        mMatchResultTextView = findViewById(R.id.textViewMatchResult);
        mMatchButton = findViewById(R.id.buttonPriceMatch);

        mMatchButton.setOnClickListener(view -> performPriceMatch());
    }

    private void performPriceMatch() {
        String itemName = mItemNameEditText.getText().toString().trim();
        String currentPriceStr = mCurrentPriceEditText.getText().toString().trim();
        String competitorPriceStr = mCompetitorPriceEditText.getText().toString().trim();

        if (TextUtils.isEmpty(itemName) || TextUtils.isEmpty(currentPriceStr) || TextUtils.isEmpty(competitorPriceStr)) {
            Toast.makeText(this, "Please enter item name and prices", Toast.LENGTH_SHORT).show();
            return;
        }

        double currentPrice = Double.parseDouble(currentPriceStr);
        double competitorPrice = Double.parseDouble(competitorPriceStr);

        //Perform price match and determine if the competitor price is lower
        boolean isMatchSuccessful = matchPrices(currentPrice, competitorPrice);

        //Display the result of the price match
        if (isMatchSuccessful) {
            mMatchResultTextView.setText("Price Match Approved: Competitor price is lower.");
        } else {
            mMatchResultTextView.setText("Price Match Denied: Competitor price is not lower.");
        }
    }

    private boolean matchPrices(double currentPrice, double competitorPrice) {
        //Check if the competitor price is lower than the current price for price match
        return competitorPrice < currentPrice;
    }
}
