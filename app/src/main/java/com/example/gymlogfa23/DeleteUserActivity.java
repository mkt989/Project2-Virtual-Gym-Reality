package com.example.gymlogfa23;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class DeleteUserActivity extends AppCompatActivity {

    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int userIdToDelete = getIntent().getIntExtra("USER_ID", -1); // Get user ID from intent

        mUserViewModel = new ViewModelProvider(this).get(UserViewModel.class); // Assuming you have a ViewModel

        if (userIdToDelete != -1) {
            //Delete the user with the provided ID
            mUserViewModel.deleteUserById(userIdToDelete);

            Toast.makeText(this, "User deleted successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Unable to delete user", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}