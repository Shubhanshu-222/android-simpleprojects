package com.example.simpleanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Interpolator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the TextView

        View animatedView = findViewById(R.id.textAnimate);
        ObjectAnimator animator = ObjectAnimator.ofFloat(animatedView, "translationX", 0f, 1000f);
        animator.setDuration(2000);
        animator.setRepeatCount(Animation.INFINITE);
        animator.start();

      /*  View animatedTextView = findViewById(R.id.animatedTextView);

        // Create an ObjectAnimator to animate the TextView
       ObjectAnimator animator = ObjectAnimator.ofFloat(animatedTextView, "translationX", 0f, 1000f);
       animator.setDuration(2000);
       animator.setRepeatCount(Animation.INFINITE);
       animator.setRepeatMode(ValueAnimator.RESTART);
       animator.setInterpolator(new LinearInterpolator());
       animator.start();*/
    }
}