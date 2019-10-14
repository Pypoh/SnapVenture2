package com.example.pypoh.snapventure.Fragment.MainFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pypoh.snapventure.Adapter.LeaderboardAdapter;
import com.example.pypoh.snapventure.Model.LeaderboardModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;

public class LeaderboardFragment extends Fragment {

    private RecyclerView leaderboardRecycler;
    private LeaderboardAdapter leaderboardAdapter;

    private List<LeaderboardModel> dataSet = new ArrayList<>();

    public LeaderboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);

        // Input data
        dataSet.add(new LeaderboardModel(1, "Naufal Afif", 54));
        dataSet.add(new LeaderboardModel(2, "Bunyamin Naufal", 53));
        dataSet.add(new LeaderboardModel(3, "Farassulthana", 51));
        dataSet.add(new LeaderboardModel(4, "Audi Azzura", 50));
        dataSet.add(new LeaderboardModel(5, "Azahra", 48));

        leaderboardRecycler = view.findViewById(R.id.recycler_leaderboard);
        leaderboardRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        leaderboardAdapter = new LeaderboardAdapter(getContext(), dataSet);
        leaderboardRecycler.setAdapter(leaderboardAdapter);

        return view;
    }


}
