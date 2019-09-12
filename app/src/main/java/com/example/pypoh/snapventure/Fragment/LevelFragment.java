package com.example.pypoh.snapventure.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Adapter.LevelAdapter;
import com.example.pypoh.snapventure.Model.LevelModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;

public class LevelFragment extends Fragment {

    private RecyclerView levelRecycler;
    private List<LevelModel> tempDataset = new ArrayList<>();

    private LevelAdapter levelAdapter;


    public LevelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level, container, false);

        tempDataset.add(new LevelModel());
        tempDataset.add(new LevelModel());

        levelRecycler = view.findViewById(R.id.levelRecycler);


        levelAdapter = new LevelAdapter(getContext(), tempDataset);
        levelRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        levelRecycler.setAdapter(levelAdapter);

        return view;
    }


}
