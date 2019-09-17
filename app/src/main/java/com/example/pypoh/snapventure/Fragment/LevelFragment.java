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
    public static List<LevelModel> tempGardenDataset = new ArrayList<>();

    public static LevelAdapter levelAdapter;


    public LevelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level, container, false);

        if (tempGardenDataset.isEmpty()) {
            riddleSetup();
        }

        levelRecycler = view.findViewById(R.id.levelRecycler);

        levelAdapter = new LevelAdapter(getContext(), tempGardenDataset);
        levelRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        levelRecycler.setAdapter(levelAdapter);

        return view;
    }

    private void riddleSetup() {
//        List<String[]> riddles = new ArrayList<>();
//        List<String[]> answers = new ArrayList<>();
//        List<int[]> starsStatus = new ArrayList<>();

        List<List<String[]>> riddles = new ArrayList<>();
        List<List<String[]>> answers = new ArrayList<>();
        List<List<int[]>> starsStatus = new ArrayList<>();

        // Level 1
        List<String[]> level1Riddle = new ArrayList<>();
        List<String[]> level1Answer = new ArrayList<>();
        List<Boolean[]> level1Status = new ArrayList<>();
        // Riddles
        level1Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level1Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level1Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level1Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level1Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level1Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level1Status.add(new Boolean[]{false, false, false});
        level1Status.add(new Boolean[]{false, false, false});
        level1Status.add(new Boolean[]{false, false, false});
        tempGardenDataset.add(new LevelModel("id0", 1, 9, level1Riddle, level1Answer, level1Status, 1, "Garden", 1));


    }

    @Override
    public void onResume() {
        super.onResume();
        this.levelAdapter.notifyDataSetChanged();
    }
}
