package com.example.pypoh.snapventure.Lesson;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;

public class LessonArrange extends Fragment {

    private Button nextBtn;

    private Button are, you, how;

    private LinearLayout answerLayout;
    private LinearLayout answerOption;

    public LessonArrange() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_lesson_arrange, container, false);

        answerLayout = view.findViewById(R.id.answer_layout);
        answerOption = view.findViewById(R.id.answer_options_layout);

        nextBtn = view.findViewById(R.id.bottom_next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMain();
            }
        });

//        are = view.findViewById(R.id.arrage_are_text);
//        are.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (are.getParent() == answerLayout) {
//                    answerOption.removeView(are);
//                    answerLayout.addView(are);
//                } else {
//                    answerLayout.removeView(are);
//                    answerOption.addView(are);
//                }
//            }
//        });
//
//        you = view.findViewById(R.id.arrage_you_text);
//        you.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                answerOption.removeView(you);
//                answerLayout.addView(you);
//
//            }
//        });
//
//        how = view.findViewById(R.id.arrage_how_text);
//        how.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                answerOption.removeView(how);
//                answerLayout.addView(how);
//            }
//        });


        return view;
    }

    private void toMain() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

}
