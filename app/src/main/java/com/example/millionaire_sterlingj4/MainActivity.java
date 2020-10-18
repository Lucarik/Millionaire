package com.example.millionaire_sterlingj4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.millionaire_sterlingj4.questions.Question1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.beginB);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openQuestion1();
            }
        });

    }

    // Open next activity
    public void openQuestion1() {
        Intent intent = new Intent(this, Question1.class);
        startActivity(intent);
    }
}