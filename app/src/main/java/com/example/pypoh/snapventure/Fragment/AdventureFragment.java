package com.example.pypoh.snapventure.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;
import com.github.florent37.expansionpanel.ExpansionLayout;

public class AdventureFragment extends Fragment {

    private Button button;
    private LevelFragment levelFragment = new LevelFragment();


    public AdventureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adventure, container, false);

//        ExpansionLayout expansionLayout =

        button = view.findViewById(R.id.go_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).setFragment(levelFragment);
            }
        });

        // TODO: Name and Level

        // TODO: Energy, Total Stars

        // TODO: Stage Chooser


        return view;
    }


}
