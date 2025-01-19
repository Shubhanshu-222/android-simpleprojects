package com.example.temperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private EditText temp1;
    private TextView res;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinnerTemp1);
        spinner2 = findViewById((R.id.spinnerTemp2));
        temp1 = findViewById(R.id.editTemp1);
        res = findViewById(R.id.textResult);
        button = findViewById(R.id.buttonConvert);

        /*String[] temperatureUnits = {"Celcius", "Fahrenheit", "Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temperatureUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);*/


        String[] temperatureUnits = {"Celcius", "Fahrenheit", "Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, temperatureUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertTemperature();
            }
        });

    }

    private void convertTemperature() {
        String temp1Unit = spinner1.getSelectedItem().toString();
        String temp2Unit = spinner2.getSelectedItem().toString();
        String value = temp1.getText().toString();

        if(temp1Unit.isEmpty() || temp2Unit.isEmpty()){
            Toast.makeText(this, "Please select the temperature!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(value.isEmpty()){
            Toast.makeText(this, "Please enter value", Toast.LENGTH_SHORT).show();
            return;
        }

        double temp1 = Double.parseDouble(value);
        double result = 0;

        if(temp1Unit.equals("Celcius")){
            result = temp1;
        } else if (temp1Unit.equals("Fahrenheit")) {
            result = (temp1 - 32) * 5.0/9.0;
        } else if (temp1Unit.equals("Kelvin")) {
            result = temp1 - 273.15;
        }

        if(temp2Unit.equals("Celcius")){
            //no change needed
        } else if (temp2Unit.equals("Fahrenheit")) {
            result = (result * 9.0/5.0) +32;
        } else if (temp2Unit.equals("Kelvin")) {
            result = result + 273.15;
        }

        res.setText("Result: " + String.format("%.2f", result) + " " + temp2Unit);


















        /*String temp1Unit = spinner1.getSelectedItem().toString();
        String temp2Unit = spinner2.getSelectedItem().toString();
        String temp1Value = temp1.getText().toString();

        if(temp1Unit.isEmpty()){
            Toast.makeText(this, "Please select the temperature in spinner", Toast.LENGTH_SHORT).show();
            return;
        }

        if(temp1Value.isEmpty()){
            Toast.makeText(this, "Please enter temperature", Toast.LENGTH_SHORT).show();
            return;
        }

        double temp1 = Double.parseDouble(temp1Value);
        double result = 0;

        if(temp1Unit.equals("Celcius")){
            result = temp1;
        } else if (temp1Unit.equals("Fahrenheit")) {
            result = (temp1-32) * 5.0 / 9.0;
        } else if (temp1Unit.equals("Kelvin")) {
            result = temp1 - 273.15;
        }

        if(temp2Unit.equals("Celcius")){
            //no change needed
        } else if (temp2Unit.equals("Fahrenheit")) {
            result = (result * 9.0 / 5.0) + 32;
        } else if (temp2Unit.equals("Kelvin")){
            result = result + 273.15;
        }

        res.setText("Result: " + String.format("%.2f", result) + " " + temp2Unit);*/
    }

}