package com.example.pypoh.snapventure.Lesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;
import com.shuhart.stepview.StepView;

public class LessonActivity extends AppCompatActivity {

    private StepView lessonStepView;
    private int step;

    private String lessonName = "";

    private ContentLessonFragment contentLessonFragment = new ContentLessonFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            lessonName = extras.getString("LESSON_NAME_KEY");
        } else {
            lessonName = "";
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(lessonName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        step = 0;
        lessonStepView = findViewById(R.id.lesson_step_view);


        setFragment(contentLessonFragment);

    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, fragment, "MAIN_FRAGMENT");
//        ft.addToBackStack(null);
        ft.commit();
    }

    public void nextStep() {
        step++;
        lessonStepView.go(step, true);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent toMain = new Intent(LessonActivity.this, MainActivity.class);
        startActivity(toMain);
        this.finish();
    }
}
