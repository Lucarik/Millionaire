package com.example.millionaire_sterlingj4.questions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.millionaire_sterlingj4.R;
import com.example.millionaire_sterlingj4.Results;

public class Question5 extends AppCompatActivity {
    // Saves current answer index
    int ans;
    // Initialize buttons
    Button prev;
    Button confirm;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    TextView currentTotal;
    TextView cWorth;

    int mTotal;
    int mValue = 5000;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        mTotal = bundle.getInt("total_money");

        // Assign ViewText, buttons to respective id's
        button1 = findViewById(R.id.q5a1B);
        button2 = findViewById(R.id.q5a2B);
        button3 = findViewById(R.id.q5a3B);
        button4 = findViewById(R.id.q5a4B);
        confirm = findViewById(R.id.conf5B);

        currentTotal = findViewById(R.id.q5Total);
        cWorth = findViewById(R.id.q5Worth);

        currentTotal.setText("$"+ mTotal);
        cWorth.setText("$"+ mValue);
        // Set button click listeners
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(button1, 1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(button2, 2);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(button3, 3);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAnswer(button4, 4);
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setConfirm();
            }
        });

    }

    // Open next question activity
    public void openQuestion6Page() {
        Intent intent = new Intent(this, Question6.class);
        intent.putExtra("total_money", mTotal);
        startActivity(intent);
    }

    public void openResultsPage() {
        Intent intent = new Intent(this, Results.class);
        intent.putExtra("total_money", mTotal);
        startActivity(intent);
    }

    // For when a multiple choice button is clicked
    public void clickAnswer(Button button, int num) {
        @SuppressLint("UseCompatLoadingForDrawables") Drawable d = getResources().getDrawable(R.drawable.roundedbutton);
        if (prev == null)
            prev = button;
        else if (!prev.equals(button)) {
            prev.setBackground(d);
            prev = button;
        }
        // Set clicked background and save answer
        @SuppressLint("UseCompatLoadingForDrawables") Drawable dc = getResources().getDrawable(R.drawable.roundedbutton_clicked);
        button.setBackground(dc);
        ans = num;

    }

    // Create confirmation dialog, enable next question, disable multiple choice
    public void setConfirm() {
        // If correct answer display so, else display wrong answer text
        Context context = getApplicationContext();
        CharSequence text = "";
        int duration = Toast.LENGTH_SHORT;
        Toast toast;
        if (checkAnswer()) {
            text = "Correct Answer. You earned " + mValue;
            toast = Toast.makeText(context, text, duration);
            toast.show();
            mTotal += mValue;
            openQuestion6Page();
        } else {
            text = "Wrong answer. Try again next time.";
            toast = Toast.makeText(context, text, duration);
            toast.show();
            openResultsPage();
        }

    }

    // Checks if checked answer is correct
    public boolean checkAnswer() {
        return (ans == 3);
    }
}