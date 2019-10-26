package com.example.pypoh.snapventure.Lesson;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pypoh.snapventure.R;

import java.util.Objects;

public class LessonFillBlank extends Fragment {

    private Button nextBtn;
    private LessonListenRepeat lessonListenRepeat = new LessonListenRepeat();

    public LessonFillBlank() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson_fill_blank, container, false);

        nextBtn = view.findViewById(R.id.bottom_next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(lessonListenRepeat);
            }
        });


        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((LessonActivity) Objects.requireNonNull(getActivity())).setFragment(fragment);
        ((LessonActivity) Objects.requireNonNull(getActivity())).nextStep();
    }

}
