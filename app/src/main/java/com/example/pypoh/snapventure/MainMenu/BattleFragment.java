package com.example.pypoh.snapventure.MainMenu;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.pypoh.snapventure.Adapter.BattleAdapter;
import com.example.pypoh.snapventure.BattlePages.MatchingFragment;
import com.example.pypoh.snapventure.Model.BattleModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BattleFragment extends Fragment {

    private Button playRandomBtn;
    private Button playFriendBtn;

    private List<BattleModel> onGoingData = new ArrayList<>();
    private RecyclerView onGoingRecycler;
    private BattleAdapter onGoingBattleAdapter;

    private List<BattleModel> endedData = new ArrayList<>();
    private RecyclerView endedRecycler;
    private BattleAdapter endedBattleAdapter;

    private MatchingFragment matchingFragment = new MatchingFragment();


    public BattleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle, container, false);

        setupView(view);

        if (onGoingData.isEmpty()) {
            setupDummyDataOnGoing();
        }
        if (endedData.isEmpty()) {
            setupDummyDataEnded();
        }

        onGoingRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        onGoingBattleAdapter = new BattleAdapter(getContext(), onGoingData);
        onGoingRecycler.setAdapter(onGoingBattleAdapter);

        endedRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        endedBattleAdapter = new BattleAdapter(getContext(), endedData);
        endedRecycler.setAdapter(endedBattleAdapter);


        return view;
    }

    private void setupDummyDataEnded() {
        endedData.add(new BattleModel(1, null, "Snappy", 2, 1, "Win"));
        endedData.add(new BattleModel(2, null, "Snappy", 1, 3, "Lose"));
    }

    private void setupDummyDataOnGoing() {
        onGoingData.add(new BattleModel(0, null, "Snappy", 3, 0, "None"));
        onGoingData.add(new BattleModel(0, null, "Snappy", 0, 2, "None"));
    }

    private void setupView(View view) {
        playRandomBtn = view.findViewById(R.id.button_random_opponent);
        playRandomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(matchingFragment);
            }
        });

        playFriendBtn = view.findViewById(R.id.button_friend_opponent);
        playFriendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        onGoingRecycler = view.findViewById(R.id.recycler_ongoing);
        endedRecycler = view.findViewById(R.id.recycler_ended);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }
}
