package com.example.pypoh.snapventure.Lesson;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pypoh.snapventure.Adapter.ContentAdapter;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContentLessonFragment extends Fragment {

    private RecyclerView contentRecycler;
    private ContentAdapter contentAdapter;
    private List<String> words = new ArrayList<>();

    private Button next;
    private TextView exampleContentText;

    private LessonQuiz lessonQuiz = new LessonQuiz();

    public ContentLessonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content_lesson, container, false);

        words.add("Hello");
        words.add("How are you?");
        words.add("How are you doing?");
        words.add("Nice to meet you");
        words.add("It is a pleasure to meet you");

        contentRecycler = view.findViewById(R.id.recycler_content);
        contentRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        contentAdapter = new ContentAdapter(getContext(), words);
        contentRecycler.setAdapter(contentAdapter);
        contentRecycler.setNestedScrollingEnabled(false);

        exampleContentText = view.findViewById(R.id.example_content);
        exampleContentText.setText("Me: How are you Snappy?\nSnappy: I am fine, thank you");

        next = view.findViewById(R.id.bottom_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(lessonQuiz);
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
