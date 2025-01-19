package com.example.calendar;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.Month;
import java.time.Year;

public class MainActivity extends AppCompatActivity {

    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener((CalendarView calendarView1, int year, int month, int dayOfMonth) -> {
                String selectedDate = dayOfMonth + "/" + (month +1) + "/" + year;
                Toast.makeText(this, "Selected date is: " + selectedDate, Toast.LENGTH_SHORT).show();
                });

        /*calendarView.setOnDateChangeListener((CalendarView calendarView1, int year, int month, int dayOfMonth) -> {
                String selectedDate = dayOfMonth + "/" + (month+1) + "/" + year;
                Toast.makeText(this, "Selected date is: " + selectedDate, Toast.LENGTH_SHORT).show();
                });*/
    }
}