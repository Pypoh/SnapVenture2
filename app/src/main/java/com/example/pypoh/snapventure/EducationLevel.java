package com.example.pypoh.snapventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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

    // Layout
    private RelativeLayout elementaryLayout;
    private RelativeLayout middleLayout;
    private RelativeLayout highLayout;

    // Image
    private ImageView personElementary;
    private ImageView personMiddle;
    private ImageView personHigh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_level);

        // Setup Ids
        setupIds();





    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    private void setupIds() {
        // Setup Expandable Layout
        elementaryView = findViewById(R.id.elementary_level);
        middleView = findViewById(R.id.middle_level);
        highView = findViewById(R.id.high__level);

        // Background
        elementaryLayout = elementaryView.findViewById(R.id.expansion_educational_level_header_layout);
        elementaryLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.elementary_red));
        middleLayout = middleView.findViewById(R.id.expansion_educational_level_header_layout);
        middleLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.middle_blue));
        highLayout = highView.findViewById(R.id.expansion_educational_level_header_layout);
        highLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.grey_high));

        // Image
        personElementary = elementaryView.findViewById(R.id.person_image_educational_level);
        personElementary.setImageResource(R.drawable.edlevel_sd);
        personMiddle = middleView.findViewById(R.id.person_image_educational_level);
        personMiddle.setImageResource(R.drawable.edlevel_smp);
        personHigh = highView.findViewById(R.id.person_image_educational_level);
        personHigh.setImageResource(R.drawable.edlevel_sma);

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
                elementaryButton.setEnabled(false);
                toMain();
            }
        });
        middleButton = middleView.findViewById(R.id.button_educational_level);
        middleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                middleButton.setEnabled(false);
                toMain();
            }
        });
        highButton = highView.findViewById(R.id.button_educational_level);
        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highButton.setEnabled(false);
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
