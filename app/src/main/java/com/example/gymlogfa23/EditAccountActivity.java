package com.example.gymlogfa23;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditAccountActivity extends AppCompatActivity {

    private EditText mUserNameEditText;
    private EditText mPasswordEditText;
    private Button mSaveButton;

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        // Initialize views
        mUserNameEditText = findViewById(R.id.editTextUserName);
        mPasswordEditText = findViewById(R.id.editTextPassword);
        mSaveButton = findViewById(R.id.buttonSave);

        //Retrieve user details
        mUser = getIntent().getParcelableExtra("USER_DETAILS");

        //Populate EditText fields with user details for editing
        mUserNameEditText.setText(mUser.getUserName());
        mPasswordEditText.setText(mUser.getPassword());

        mSaveButton.setOnClickListener(view -> saveChanges());
    }

    private void saveChanges() {
        String newUserName = mUserNameEditText.getText().toString().trim();
        String newPassword = mPasswordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(newUserName) || TextUtils.isEmpty(newPassword)) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        //Update user details with the new information
        mUser.setUserName(newUserName);
        mUser.setPassword(newPassword);

        //update logic?

        Toast.makeText(this, "Account details updated successfully", Toast.LENGTH_SHORT).show();

        finish();
    }
}
