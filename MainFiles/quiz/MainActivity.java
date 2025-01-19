package com.example.simplequiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView, scoreTextView;
    private RadioGroup answersRadioGroup;
    private Button nextButton;

    private String[] questions = {
            "What is the capital of France?",
            "Which planet is known as the Red Planet?",
            "Who wrote 'Hamlet'?"
    };

    private String[][] options = {
            {"Paris", "Berlin", "Madrid", "Rome"},
            {"Earth", "Mars", "Jupiter", "Saturn"},
            {"Shakespeare", "Dickens", "Hemingway", "Austen"}
    };

    private String[] correctAnswers = {"Paris", "Mars", "Shakespeare"};

    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Views
        questionTextView = findViewById(R.id.questionTextView);
        answersRadioGroup = findViewById(R.id.answersRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        scoreTextView = findViewById(R.id.scoreTextView);

        // Load the first question
        loadQuestion();

        nextButton.setOnClickListener(v -> {
            // Check if an answer is selected
            int selectedId = answersRadioGroup.getCheckedRadioButtonId();

            //Check if the answer is not selected and button is pressed
            if(selectedId == -1){
                Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (selectedId != -1) {
                RadioButton selectedAnswer = findViewById(selectedId);
                String answerText = selectedAnswer.getText().toString();

                // Check if the answer is correct
                if (answerText.equals(correctAnswers[currentQuestionIndex])) {
                    score++;
                }

                // Move to the next question or show score
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.length) {
                    loadQuestion();
                } else {
                    showScore();
                }
            }
        });
    }

    private void loadQuestion() {
        // Load the current question and options
        questionTextView.setText(questions[currentQuestionIndex]);
        answersRadioGroup.clearCheck();

        ((RadioButton) findViewById(R.id.option1)).setText(options[currentQuestionIndex][0]);
        ((RadioButton) findViewById(R.id.option2)).setText(options[currentQuestionIndex][1]);
        ((RadioButton) findViewById(R.id.option3)).setText(options[currentQuestionIndex][2]);
        ((RadioButton) findViewById(R.id.option4)).setText(options[currentQuestionIndex][3]);
    }

    private void showScore() {
        // Hide the quiz elements and display the score
        questionTextView.setVisibility(View.GONE);
        answersRadioGroup.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

        scoreTextView.setText("Your Score: " + score + "/" + questions.length);
        scoreTextView.setVisibility(View.VISIBLE);
    }
}
