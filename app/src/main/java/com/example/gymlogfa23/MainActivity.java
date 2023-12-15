package com.example.gymlogfa23;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.SharedPreferences;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.gymlogfa23.db.AppDatabase;
import com.example.gymlogfa23.db.GymLogDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String USER_ID_KEY = "com.example.gymlogfa23.userIdKey";
    private static final String PREFENCES_KEY = "com.example.gymlogfa23.PREFENCES_KEY";
    private TextView mMainDisplay;
    private EditText mExercise;
    private EditText mWeight;
    private EditText mReps;
    private Button mSubmitButton;

    private GymLogDAO mGymLogDAO;

    private List<GymLog> mGymLogs;
    private int mUserId = -1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {  //menu logout button
        int id=item.getItemId();
        if(id==R.id.logout) {
            Toast.makeText(this, "You have pressed logout", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.aboutUS) {
            Toast.makeText(this, "You have pressed About Us", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.share) {
            Toast.makeText(this, "You have pressed share", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDatabase();

        checkForUser();

        mMainDisplay = findViewById(R.id.mainGymLogDisplay);
        mMainDisplay.setMovementMethod(new ScrollingMovementMethod());

        mExercise = findViewById(R.id.mainExerciseEditText);
        mWeight = findViewById(R.id.mainWeightEditText);
        mReps = findViewById(R.id.mainRepsEditText);

        mSubmitButton = findViewById(R.id.mainSubmitButton);

        refreshDisplay();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GymLog log = getValuesFromDisplay();

                mGymLogDAO.insert(log);

                refreshDisplay();
            }
        });
    }

    private void getDatabase() {
        mGymLogDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getGymLogDAO();
    }

    private void checkForUser() {
        mUserId = getIntent().getIntExtra(USER_ID_KEY, -1);

        if(mUserId != -1) {
            return;
        }

        SharedPreferences preferences = this.getSharedPreferences(PREFENCES_KEY, Context.MODE_PRIVATE);

        mUserId = preferences.getInt(USER_ID_KEY, -1);

        if(mUserId != -1) {
            return;
        }

        //do we have any users at all?
        List<User> users = mGymLogDAO.getAllUsers();
        if(users.size() <= 0) {
            User defaultUser = new User("Deb", "Deb");
            mGymLogDAO.insert(defaultUser);
        }

        Intent intent = LoginActivity.intentFactory(this);
        startActivity(intent);
    }


    private GymLog getValuesFromDisplay() {
        String exercise = "No record found";
        double weight = 0.0;
        int reps = 0;

        exercise = mExercise.getText().toString();

        try {
            weight = Double.parseDouble(mWeight.getText().toString());
        } catch (NumberFormatException e){
            Log.d("GYMLOG", "Couldn't convert weight");
        }

        try {
            reps = Integer.parseInt(mReps.getText().toString());
        } catch (NumberFormatException e){
            Log.d("GYMLOG", "Couldn't convert reps");
        }

        GymLog log = new GymLog(exercise, reps, weight, mUserId);

        return log;
    }

    private void refreshDisplay() {
        mGymLogs = mGymLogDAO.getGymLogsById(mUserId);

        if(mGymLogs.size() >= 0) {
            mMainDisplay.setText(R.string.noLogsMessage);
        }

        StringBuilder sb = new StringBuilder();
        for(GymLog log : mGymLogs) {
            sb.append(log);
            sb.append("\n");
            sb.append("=-=-=-=-=-=-=-=-=");
            sb.append("\n");
        }
        mMainDisplay.setText(sb.toString());
    }

    public static Intent intentFactory(Context context, int userId) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(USER_ID_KEY, userId);

        return intent;
    }
}