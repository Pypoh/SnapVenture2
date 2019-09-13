package com.example.pypoh.snapventure;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pypoh.snapventure.MainMenu.MainActivity;

public class EducationLevel extends AppCompatActivity {

    // View
    private View elementaryView;
    private View middleView;
    private View highView;

    // Header
    private TextView elementaryLevelHeader;
    private TextView middleLevelHeader;
    private TextView highLevelHeader;

    // Button
    private Button elementaryButton;
    private Button middleButton;
    private Button highButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_level);

        // Setup Ids
        setupIds();





    }

    @SuppressLint("SetTextI18n")
    private void setupIds() {
        // Setup Expandable Layout
        elementaryView = findViewById(R.id.elementary_level);
        middleView = findViewById(R.id.middle_level);
        highView = findViewById(R.id.high__level);

        // Text
        elementaryLevelHeader = elementaryView.findViewById(R.id.text_educational_level_header);
        elementaryLevelHeader.setText("Elementary School");
        middleLevelHeader = middleView.findViewById(R.id.text_educational_level_header);
        middleLevelHeader.setText("Middle School");
        highLevelHeader = highView.findViewById(R.id.text_educational_level_header);
        highLevelHeader.setText("High School");

        // Button
        elementaryButton = elementaryView.findViewById(R.id.button_educational_level);
        elementaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMain();
            }
        });
        middleButton = middleView.findViewById(R.id.button_educational_level);
        middleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMain();
            }
        });
        highButton = highView.findViewById(R.id.button_educational_level);
        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMain();
            }
        });
    }

    private void toMain() {
        Intent toMain = new Intent(EducationLevel.this, MainActivity.class);
        startActivity(toMain);
        finish();
    }


}
