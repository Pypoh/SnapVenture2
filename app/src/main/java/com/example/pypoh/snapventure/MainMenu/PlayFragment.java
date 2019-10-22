package com.example.pypoh.snapventure.MainMenu;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pypoh.snapventure.Auth.AuthActivity;
import com.example.pypoh.snapventure.Fragment.MainFragment.AdventureFragment;
import com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment;
import com.example.pypoh.snapventure.R;

import java.util.Objects;

public class PlayFragment extends Fragment {

    private LinearLayout snapModeBtn, pronounceModeBtn, quizModeBtn;

    private AdventureFragment adventureFragment = new AdventureFragment();
    private PronounceFragment pronounceFragment = new PronounceFragment();

    public PlayFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_play, container, false);

        setupViews(view);

        return view;
    }

    private void setupViews(View view) {
        snapModeBtn = view.findViewById(R.id.snap_mode);
        snapModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(adventureFragment);
            }
        });
        pronounceModeBtn = view.findViewById(R.id.pronounce_mode);
        pronounceModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(pronounceFragment);
            }
        });
        quizModeBtn = view.findViewById(R.id.quiz_mode);
        quizModeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Under Development", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }
}
