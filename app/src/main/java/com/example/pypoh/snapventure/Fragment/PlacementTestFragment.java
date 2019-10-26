package com.example.pypoh.snapventure.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pypoh.snapventure.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PlacementTestFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;

    public PlacementTestFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_placement_test, container, false);


        getActivity().getWindow().setStatusBarColor(getContext().getResources().getColor(R.color.colorPrimary));
        bottomNavigationView = getActivity().findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.GONE);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().getWindow().setStatusBarColor(getContext().getResources().getColor(R.color.white));
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}
