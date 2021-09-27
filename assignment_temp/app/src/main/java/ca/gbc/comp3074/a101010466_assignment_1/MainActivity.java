package ca.gbc.comp3074.a101010466_assignment_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText numHoursWorked;
    public EditText hourlyRate;
    public Button btnCalc;
    public TextView outputTotal;
    public TextView outputTax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numHoursWorked = findViewById(R.id.id_edit_hoursWorked);
        hourlyRate = findViewById(R.id.id_edit_hourlyRate);

        btnCalc = findViewById(R.id.btn_calc);

        outputTotal = findViewById(R.id.id_output_totalPay);
        outputTax = findViewById(R.id.id_output_tax);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double hours;
                double rate;
                if (numHoursWorked.getText().toString().isEmpty()) {
                    numHoursWorked.setError("Please enter the amount of hours worked before hitting calculate!");
                    hours = 0;
                } else {
                    hours = Double.parseDouble(numHoursWorked.getText().toString());
                }

                if (hourlyRate.getText().toString().isEmpty()) {
                    hourlyRate.setError("Please enter a rate before hitting calculate!");
                    rate = 0;
                } else {
                    rate = Double.parseDouble(hourlyRate.getText().toString());
                }

                double totalPay = calculateTotalPay(hours, rate);
                double tax = calculateTax(totalPay);

                outputTotal.setText(String.valueOf(totalPay));
                outputTax.setText(String.valueOf(tax));
            }
        });
    }

    public double calculateTotalPay(double numHours, double hourlyRate) {
        if (numHours > 40) {
            return (numHours - 40) * hourlyRate * 1.5 + 40 * hourlyRate;
        } else return numHours * hourlyRate;
    }

    public double calculateTax(double pay) {
        return pay * 0.18;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}