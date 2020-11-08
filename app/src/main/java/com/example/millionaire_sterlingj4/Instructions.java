package com.example.millionaire_sterlingj4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// This activity shows the instruction page
public class Instructions extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        button = findViewById(R.id.returnB);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStartPage();
            }
        });
    }

    // Open next activity(main menu)
    public void openStartPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}