package com.example.pypoh.snapventure.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
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
        riddleSetup();

        levelRecycler = view.findViewById(R.id.levelRecycler);

        levelAdapter = new LevelAdapter(getContext(), tempDataset);
        levelRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        levelRecycler.setAdapter(levelAdapter);

        return view;
    }

    private void riddleSetup() {
        List<String[]> riddles = new ArrayList<>();
        List<String[]> answers = new ArrayList<>();
        List<int[]> starsStatus = new ArrayList<>();

        // Riddles 1
        riddles.add(new String[]{"My name is very similar with an animal, I usually used for pointing at monitor. Who am i?", "Subject 2", "Subject 3", "Subject 4", "Subject 5"});
        answers.add(new String[]{"Mouse", "Mouse", "Mouse", "Mouse", "Mouse"});
        starsStatus.add(new int[]{3, 3, 3, 2, 1});
        tempDataset.add(new LevelModel("0", 1, 15, riddles.get(0), answers.get(0), starsStatus.get(0), 1));

        // Riddles 2
        riddles.add(new String[]{"My name is very similar with an animal, I usually used for pointing at monitor. Who am i?", "Subject 2", "Subject 3", "Subject 4", "Subject 5"});
        answers.add(new String[]{"Mouse", "Mouse", "Mouse", "Mouse", "Mouse"});
        starsStatus.add(new int[]{3, 3, 3, 2, 1});
        tempDataset.add(new LevelModel("0", 1, 15, riddles.get(1), answers.get(1), starsStatus.get(1), 1));

        // Riddles 3
        riddles.add(new String[]{"My name is very similar with an animal, I usually used for pointing at monitor. Who am i?", "Subject 2", "Subject 3", "Subject 4", "Subject 5"});
        answers.add(new String[]{"Mouse", "Mouse", "Mouse", "Mouse", "Mouse"});
        starsStatus.add(new int[]{3, 3, 3, 2, 1});
        tempDataset.add(new LevelModel("0", 1, 15, riddles.get(2), answers.get(2), starsStatus.get(2), 2));

        // Riddles 4
        riddles.add(new String[]{"My name is very similar with an animal, I usually used for pointing at monitor. Who am i?", "Subject 2", "Subject 3", "Subject 4", "Subject 5"});
        answers.add(new String[]{"Mouse", "Mouse", "Mouse", "Mouse", "Mouse"});
        starsStatus.add(new int[]{3, 3, 3, 2, 1});
        tempDataset.add(new LevelModel("0", 1, 15, riddles.get(3), answers.get(3), starsStatus.get(3), 1));

        // Riddles 5
        riddles.add(new String[]{"My name is very similar with an animal, I usually used for pointing at monitor. Who am i?", "Subject 2", "Subject 3", "Subject 4", "Subject 5"});
        answers.add(new String[]{"Mouse", "Mouse", "Mouse", "Mouse", "Mouse"});
        starsStatus.add(new int[]{3, 3, 3, 2, 1});
        tempDataset.add(new LevelModel("0", 1, 15, riddles.get(4), answers.get(4), starsStatus.get(4), 2));

        // Riddles 6
        riddles.add(new String[]{"My name is very similar with an animal, I usually used for pointing at monitor. Who am i?", "Subject 2", "Subject 3", "Subject 4", "Subject 5"});
        answers.add(new String[]{"Mouse", "Mouse", "Mouse", "Mouse", "Mouse"});
        starsStatus.add(new int[]{3, 3, 3, 2, 1});
        tempDataset.add(new LevelModel("0", 1, 15, riddles.get(5), answers.get(5), starsStatus.get(5), 1));


    }


}
