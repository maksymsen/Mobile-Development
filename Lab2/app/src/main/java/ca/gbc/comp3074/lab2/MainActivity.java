package ca.gbc.comp3074.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView output;
    Button add;
    Button minus;
    Button step;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.labelOutput);

        // This may be redundant as the default value for this label should be "0", but just in case, we set it to "0" onCreate anyway.
        output.setText("0");

        add = findViewById(R.id.btnAdd);
        minus = findViewById(R.id.btnMinus);
        step = findViewById(R.id.btnStep);
        reset = findViewById(R.id.btnReset);
    }
}