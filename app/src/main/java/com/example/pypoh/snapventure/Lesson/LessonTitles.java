package com.example.pypoh.snapventure.Lesson;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pypoh.snapventure.Adapter.LessonTitleAdapter;
import com.example.pypoh.snapventure.MainMenu.LessonFragment;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.Model.LessonModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LessonTitles extends Fragment {

    private RecyclerView lessonTitleRecycler;
    private LessonTitleAdapter lessonTitleAdapter;
    private List<LessonModel> lessonsData = new ArrayList<>();

    private LearningObjectiveFragment learningObjectiveFragment = new LearningObjectiveFragment();

    public static LessonModel selectedLesson;


    public LessonTitles() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson_titles, container, false);

        if (lessonsData.isEmpty()) {
            addData();
        }

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).setTitle(LessonFragment.selectedLessonName);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        setupViews(view);

        lessonTitleRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        lessonTitleAdapter = new LessonTitleAdapter(getContext(), lessonsData);
        lessonTitleRecycler.setAdapter(lessonTitleAdapter);

        lessonTitleAdapter.setOnItemClickListener(new LessonTitleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(LessonModel lessonModel) {
                switch (lessonModel.getLessonNames()) {
                    case "Introduction":
                        Toast.makeText(getContext(), "This is an example for completed lesson", Toast.LENGTH_SHORT).show();
                        break;
                    case "Greetings":
                        selectedLesson = lessonModel;
                        changeFragment(learningObjectiveFragment);
                        break;
                    case "Review":
                    case "Final Test":
                        Toast.makeText(getContext(), "Under Development", Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });

        return view;
    }

    private void addData() {
        lessonsData.add(new LessonModel(R.drawable.lessons_getting_started_introduction_on, 1, "Introduction", 100, "Learn how to introduce yourself"));
        lessonsData.add(new LessonModel(R.drawable.lessons_getting_started_greeting_off, 1, "Greetings", 0, "Greet someone"));
        lessonsData.add(new LessonModel(R.drawable.lessons_getting_started_review_off, 1, "Review", 0, "Remember what you have learn"));
        lessonsData.add(new LessonModel(R.drawable.lessons_getting_started_test_off, 1, "Final Test", 0, "Let's see what you got"));
    }

    private void setupViews(View view) {
        lessonTitleRecycler = view.findViewById(R.id.recycler_lesson_title);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }
}
