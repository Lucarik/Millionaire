package com.example.millionaire_sterlingj4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    int mTotal;
    Button button;
    TextView res1;
    TextView res2;
    TextView total;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Get correct answer number from previous activity
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        mTotal = bundle.getInt("total_money");

        button = findViewById(R.id.rStart);
        res1 = findViewById(R.id.rRes1);
        res2 = findViewById(R.id.rRes2);
        total = findViewById(R.id.rTotal);

        // Set correct answer text and text color
        total.setText(Integer.toString(mTotal));
        if (mTotal < 1000000) {
            res1.setText("A wrong answer");
            res2.setText("Try again next time");
        } else {
            res2.setTextColor(Color.parseColor("#6fe890"));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStartPage();
            }
        });
    }

    // Open next activity
    public void openStartPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}