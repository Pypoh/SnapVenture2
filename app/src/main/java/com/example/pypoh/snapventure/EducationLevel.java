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
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.github.florent37.expansionpanel.ExpansionLayout;

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

    // Main Scroll View
    private ScrollView mainScrollView;

    // TextView
    private TextView tvElementary1, tvElementary2, tvElementary3;
    private TextView tvMiddle1, tvMiddle2, tvMiddle3;
    private TextView tvHigh1, tvHigh2, tvHigh3;


    // Expansion Layout
    private ExpansionLayout highExpansionLayout;


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
        tvElementary1 = elementaryView.findViewById(R.id.text_educational_level1);
        tvElementary1.setText("\u25CF Elementary School level of difficulty");
        tvElementary2 = elementaryView.findViewById(R.id.text_educational_level2);
        tvElementary2.setText("\u25CF Translations are free");
        tvElementary3 = elementaryView.findViewById(R.id.text_educational_level3);
        tvElementary3.setText("\u25CF Added silhouette for riddle");
        middleLayout = middleView.findViewById(R.id.expansion_educational_level_header_layout);
        middleLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.middle_blue));
        tvMiddle1 = middleView.findViewById(R.id.text_educational_level1);
        tvMiddle1.setText("\u25CF Junior High School level of difficulty");
        tvMiddle2 = middleView.findViewById(R.id.text_educational_level2);
        tvMiddle2.setText("\u25CF Riddle will be shown as a text");
        tvMiddle3 = middleView.findViewById(R.id.text_educational_level3);
        tvMiddle3.setText("\u25CF Limited Hints");
        highLayout = highView.findViewById(R.id.expansion_educational_level_header_layout);
        highLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.grey_high));
        tvHigh1 = highView.findViewById(R.id.text_educational_level1);
        tvHigh1.setText("\u25CF Senior High School level of difficulty");
        tvHigh2 = highView.findViewById(R.id.text_educational_level2);
        tvHigh2.setText("\u25CF Snappy will only sends voice message");
        tvHigh3 = highView.findViewById(R.id.text_educational_level3);
        tvHigh3.setText("\u25CF Extra Limited Hints");

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

        // Main Scroll View
        mainScrollView = findViewById(R.id.main_scroll_view);

        highExpansionLayout = highView.findViewById(R.id.expansionLayout);
        highExpansionLayout.addListener(new ExpansionLayout.Listener() {
            @Override
            public void onExpansionChanged(ExpansionLayout expansionLayout, boolean expanded) {
                if (expanded) {
                    mainScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }
            }
        });


                // Button
        elementaryButton = elementaryView.findViewById(R.id.button_educational_level);
        elementaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elementaryButton.setEnabled(false);
                Toast.makeText(EducationLevel.this, "Under Development, Available: Middle", Toast.LENGTH_SHORT).show();
//                toMain();
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
                Toast.makeText(EducationLevel.this, "Under Development, Available: Middle", Toast.LENGTH_SHORT).show();
//                toMain();
            }
        });

    }

    private void toMain() {
        Intent toMain = new Intent(EducationLevel.this, MainActivity.class);
        startActivity(toMain);
        finish();
    }


}
