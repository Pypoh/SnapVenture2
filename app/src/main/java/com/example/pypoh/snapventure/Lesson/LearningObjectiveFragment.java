package com.example.pypoh.snapventure.Lesson;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pypoh.snapventure.Lesson.LessonActivity;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;


public class LearningObjectiveFragment extends Fragment {

    private TextView learningObjectiveText;
    private Button startLessonBtn;
    public LearningObjectiveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_learning_objective, container, false);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).setTitle(LessonTitles.selectedLesson.getLessonNames());
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        String learningObjective = "- Learn how to greet someone\n- Learn how to greet someone depending on the time\n- Learn how to respond to a greeting";

        learningObjectiveText = view.findViewById(R.id.text_learning_objective);
        learningObjectiveText.setText(learningObjective);

        startLessonBtn = view.findViewById(R.id.start_lesson_button);
        startLessonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toLesson();
            }
        });

        return view;
    }

    private void toLesson() {
        Intent toLesson = new Intent(getContext(), LessonActivity.class);
        toLesson.putExtra("LESSON_NAME_KEY", LessonTitles.selectedLesson.getLessonNames());
        startActivity(toLesson);
        getActivity().finish();
    }
}
