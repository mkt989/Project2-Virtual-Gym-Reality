package com.example.gymlogfa23;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReturnItemActivity extends AppCompatActivity {

    private EditText mReturnReasonEditText;
    private Button mReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_item);

        // Initialize views
        mReturnReasonEditText = findViewById(R.id.editTextReturnReason);
        mReturnButton = findViewById(R.id.buttonReturn);

        mReturnButton.setOnClickListener(view -> returnItem());
    }

    private void returnItem() {
        String returnReason = mReturnReasonEditText.getText().toString().trim();

        if (TextUtils.isEmpty(returnReason)) {
            Toast.makeText(this, "Please enter a return reason", Toast.LENGTH_SHORT).show();
            return;
        }

        //return logic?

        Toast.makeText(this, "Item returned successfully", Toast.LENGTH_SHORT).show();

        finish();
    }
}