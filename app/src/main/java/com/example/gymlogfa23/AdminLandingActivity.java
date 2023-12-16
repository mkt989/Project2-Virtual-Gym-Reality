package com.example.gymlogfa23;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLandingActivity extends AppCompatActivity {

    private static final String USER_ID_KEY = "com.example.gymlogfa23.userIdKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlanding);


    }

    public static Intent intentFactory(Context context, int userId) {
        Intent intent = new Intent(context, AdminLandingActivity.class);
        intent.putExtra(USER_ID_KEY, userId);
        return intent;
    }
}