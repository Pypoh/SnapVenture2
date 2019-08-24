package com.example.pypoh.snapventure.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pypoh.snapventure.R;

public class AdventureFragment extends Fragment {

    public AdventureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adventure, container, false);

        // TODO: Name and Level

        // TODO: Energy, Total Stars

        // TODO: Stage Chooser


        return view;
    }


}
