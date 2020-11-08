package com.example.millionaire_sterlingj4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Lose extends AppCompatActivity {

    int mTotal;
    Button button;
    TextView total;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        // Get final total from previous activity
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        mTotal = bundle.getInt("total_money");

        button = findViewById(R.id.rStart2);
        total = findViewById(R.id.rTotalL);

        // Set correct answer text and text color
        total.setText("$"+ mTotal);

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