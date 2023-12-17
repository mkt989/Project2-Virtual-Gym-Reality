package com.example.gymlogfa23;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class AddUserActivity extends AppCompatActivity {

    private EditText mUserNameEditText;
    private EditText mPasswordEditText;
    private Button mAddUserButton;

    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        // Initialize views
        mUserNameEditText = findViewById(R.id.editTextUserName);
        mPasswordEditText = findViewById(R.id.editTextPassword);
        mAddUserButton = findViewById(R.id.buttonAddUser);

        mUserViewModel = new ViewModelProvider(this).get(UserViewModel.class); // Assuming you have a ViewModel

        mAddUserButton.setOnClickListener(view -> addUser());
    }

    private void addUser() {
        String userName = mUserNameEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        //Create a new User object and add it to the database
        User newUser = new User(userName, password, false); // Adjust parameters based on your User class

        mUserViewModel.insert(newUser);

        Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show();

        finish();
    }
}