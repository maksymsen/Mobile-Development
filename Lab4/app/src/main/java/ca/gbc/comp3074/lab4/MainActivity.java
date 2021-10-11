package ca.gbc.comp3074.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView userGreeting;
    Button saveButton;
    EditText editUserName;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String userValue = "User";
    public final String greeting = "Greetings, ";

    private String userLoadedUser = "Greetings, User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUserName = (EditText) findViewById(R.id.editUserName);
        saveButton = (Button) findViewById(R.id.saveBtn);
        userGreeting = (TextView) findViewById(R.id.userGreeting);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = greeting + editUserName.getText().toString();
                userGreeting.setText(temp);

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(userValue, userGreeting.getText().toString());
                editor.apply();

                Toast.makeText(MainActivity.this, "User saved", Toast.LENGTH_SHORT).show();
            }
        });
        loadData();
        onLoad();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        userLoadedUser = sharedPreferences.getString(userValue, "");
    }

    public void onLoad() {
        userGreeting.setText(userLoadedUser);
    }
}