package com.example.pypoh.snapventure.MainMenu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

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
import com.example.pypoh.snapventure.Model.BattleModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;

public class BattleFragment extends Fragment {

    private Button playRandomBtn;
    private Button playFriendBtn;

    private List<BattleModel> onGoingData = new ArrayList<>();
    private RecyclerView onGoingRecycler;
    private BattleAdapter onGoingBattleAdapter;

    private List<BattleModel> endedData = new ArrayList<>();
    private RecyclerView endedRecycler;
    private BattleAdapter endedBattleAdapter;


    public BattleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle, container, false);

        setupView(view);

        onGoingData.add(new BattleModel(0, null, "Snappy", "3:1", "Win"));
        onGoingData.add(new BattleModel(0, null, "Snappy", "3:1", "Win"));

        endedData.add(new BattleModel(0, null, "Snappy", "2:1", "Win"));
        endedData.add(new BattleModel(0, null, "Snappy", "2:1", "Win"));

        onGoingRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        onGoingBattleAdapter = new BattleAdapter(getContext(), onGoingData);
        onGoingRecycler.setAdapter(onGoingBattleAdapter);

        endedRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        endedBattleAdapter = new BattleAdapter(getContext(), endedData);
        endedRecycler.setAdapter(endedBattleAdapter);


        return view;
    }

    private void setupView(View view) {
        playRandomBtn = view.findViewById(R.id.button_random_opponent);
        playFriendBtn = view.findViewById(R.id.button_friend_opponent);

        onGoingRecycler = view.findViewById(R.id.recycler_ongoing);
        endedRecycler = view.findViewById(R.id.recycler_ended);

    }
}
