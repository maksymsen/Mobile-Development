package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView label;
    public Button btn;
    public EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label = findViewById(R.id.label);
        btn = findViewById(R.id.btn);
        address = findViewById(R.id.address);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
//                label.setText("I refuse to say hello to the world!");
                label.setText(address.getText());
            }
        });

//        Changing the text value of the 'label' id TextView
//        label.setText("I refuse to say hello to the world!");
    }
}