package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private Button add, subtract, divide, multiply;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.editNum1);
        num2 = findViewById(R.id.editNum2);
        add = findViewById(R.id.buttonAdd);
        subtract = findViewById(R.id.buttonSubtract);
        divide = findViewById(R.id.buttonDivide);
        multiply = findViewById(R.id.buttonMultiply);
        result = findViewById(R.id.textResult);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("Add");
            }
        });

        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("Subtract");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("Divide");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("Multiply");
            }
        });

    }

    private void calculate(String operation) {
        String input1 = num1.getText().toString();
        String input2 = num2.getText().toString();

        if(input1.isEmpty() || input2.isEmpty()){
            Toast.makeText(this, "Please check input fields!", Toast.LENGTH_SHORT).show();
            return;
        }

        double digit1 = Double.parseDouble(input1);
        double digit2 = Double.parseDouble(input2);
        double res = 0;

        if(operation == "Add"){
            res = digit1 + digit2;
        } else if (operation == "Subtract") {
            res = digit1 - digit2;
        } else if (operation == "Divide") {
            if(digit2 == 0){
                Toast.makeText(this, "Invalid input in number 2", Toast.LENGTH_SHORT).show();
                return;
            }
            res = digit1/digit2;
        } else if (operation == "Multiply") {
            res = digit1*digit2;
        }

        result.setText("Result is: " + res);
    }
}