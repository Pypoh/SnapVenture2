package com.example.pypoh.snapventure.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Adapter.LevelAdapter;
import com.example.pypoh.snapventure.Fragment.MainFragment.AdventureFragment;
import com.example.pypoh.snapventure.Model.LevelModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;

public class LevelFragment extends Fragment {

    private RecyclerView levelRecycler;
    public static List<LevelModel> tempGardenDataset = new ArrayList<>();
    public static List<LevelModel> tempKitchenDataset = new ArrayList<>();
    public static List<LevelModel> tempClassroomDataset = new ArrayList<>();
    public static List<LevelModel> tempStreetDataset = new ArrayList<>();

    public static LevelAdapter levelAdapter;


    public LevelFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level, container, false);

        if (tempGardenDataset.isEmpty()) {
            riddleGardenSetup();
        }
        if (tempKitchenDataset.isEmpty()) {
            riddleKitchenSetup();
        }
        if (tempClassroomDataset.isEmpty()) {
            riddleClassroomSetup();
        }
        if (tempStreetDataset.isEmpty()) {
            riddleStreetSetup();
        }

        levelRecycler = view.findViewById(R.id.levelRecycler);
        switch (AdventureFragment.currentPlace) {
            case 0:
                levelAdapter = new LevelAdapter(getContext(), tempGardenDataset);
                break;
            case 1:
                levelAdapter = new LevelAdapter(getContext(), tempKitchenDataset);
                break;
            case 2:
                levelAdapter = new LevelAdapter(getContext(), tempClassroomDataset);
                break;
            case 3:
                levelAdapter = new LevelAdapter(getContext(), tempStreetDataset);
                break;
        }

        levelRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        levelRecycler.setAdapter(levelAdapter);

        return view;
    }

    private void riddleGardenSetup() {
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
//        tempGardenDataset.add(new LevelModel("id0", 1, 9, level1Riddle, level1Answer, level1Status, 1, "Garden", 1, true));

        // Level 2
        List<String[]> level2Riddle = new ArrayList<>();
        List<String[]> level2Answer = new ArrayList<>();
        List<Boolean[]> level2Status = new ArrayList<>();
        // Riddles
        level2Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level2Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level2Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level2Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level2Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level2Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
//        tempGardenDataset.add(new LevelModel("id0", 2, 9, level2Riddle, level2Answer, level2Status, 1, "Garden", 2, true));

        // Level 3
        List<String[]> level3Riddle = new ArrayList<>();
        List<String[]> level3Answer = new ArrayList<>();
        List<Boolean[]> level3Status = new ArrayList<>();
        // Riddles
        level3Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level3Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level3Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level3Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level3Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level3Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
//        tempGardenDataset.add(new LevelModel("id0", 3, 9, level3Riddle, level3Answer, level3Status, 1, "Garden", 3, false));

        // Level 4
        List<String[]> level4Riddle = new ArrayList<>();
        List<String[]> level4Answer = new ArrayList<>();
        List<Boolean[]> level4Status = new ArrayList<>();
        // Riddles
        level4Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level4Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level4Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level4Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level4Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level4Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
//        tempGardenDataset.add(new LevelModel("id0", 1, 9, level4Riddle, level4Answer, level4Status, 2, "Garden", 4, false));
    }

    private void riddleKitchenSetup() {
        // Level 1
        List<String[]> level1Riddle = new ArrayList<>();
        List<String[]> level1Answer = new ArrayList<>();
        List<String[]> level1Pronounce = new ArrayList<>();
        List<Boolean[]> level1Status = new ArrayList<>();
        // Riddles
        level1Riddle.add(new String[]{"This gets filled with water\n" +
                "But it’s not a glass or jug\n" +
                "It’s in your kitchen though\n" +
                "At the bottom there’s a hole", "This is something in your kitchen\n" +
                "Meat, milk and yogurt it does hold\n" +
                "The reason you put them in this\n" +
                "Is because it helps keep them cold", "I am a piece of furniture\n" +
                "At a table I’m often found\n" +
                "When I’m there then I have four legs\n" +
                "But at a desk I swivel round"});
        level1Riddle.add(new String[]{"I’m something in your kitchen\n" +
                "Although I am not a cup, I have a handle\n" +
                "I’m dangerous\n" +
                "But I'm also useful", "I'm something in your kitchen\n" +
                "I have four legs but I'm not an animal\n" +
                "I can carry a lot of stuff\n" +
                "What am I?", "I'm flat and sometimes I'm fragile. But you still use me to put your food. What am I?"});
        level1Riddle.add(new String[]{"You put me in your mouth but never eats me. What am I?", "I have a friend that's almost always with me on the table. I have multiple tips, but I'm not that sharp. What am I?", "I'm hot, I'm on fire. Sometimes I run on gas, sometime electricity, and even kerosene. What am I?"});
        // Answers
        level1Answer.add(new String[]{"Sink", "Refrigerator", "Chair"});
        level1Answer.add(new String[]{"Knife", "Table", "Plate"});
        level1Answer.add(new String[]{"Spoon", "Fork", "Stove"});
        // Pronounce
        level1Pronounce.add(new String[]{"/sɪŋk/", "/rɪˈfrɪdʒəreɪtə/", "/tʃer/"});
        level1Pronounce.add(new String[]{"/naɪf/", "/ˈteɪ.bəl/", "/pleɪt/"});
        level1Pronounce.add(new String[]{"/spuːn/", "/fɔːrk/", "/stoʊv/"});
        // Status
        level1Status.add(new Boolean[]{false, false, false});
        level1Status.add(new Boolean[]{false, false, false});
        level1Status.add(new Boolean[]{false, false, false});
        tempKitchenDataset.add(new LevelModel("id0", 1, 9, level1Riddle, level1Answer, level1Pronounce, level1Status, 1, "Kitchen", 1, true));

        // Level 2
        List<String[]> level2Riddle = new ArrayList<>();
        List<String[]> level2Answer = new ArrayList<>();
        List<String[]> level2Pronounce = new ArrayList<>();
        List<Boolean[]> level2Status = new ArrayList<>();
        // Riddles
        level2Riddle.add(new String[]{"This gets filled with water\n" +
                "But it’s not a glass or jug\n" +
                "It’s in your kitchen though\n" +
                "At the bottom there’s a hole", "This is something in your kitchen\n" +
                "Meat, milk and yogurt it does hold\n" +
                "The reason you put them in this\n" +
                "Is because it helps keep them cold", "I am a piece of furniture\n" +
                "At a table I’m often found\n" +
                "When I’m there then I have four legs\n" +
                "But at a desk I swivel round"});
        level2Riddle.add(new String[]{"I’m something in your kitchen\n" +
                "Although I am not a cup, I have a handle\n" +
                "I’m dangerous\n" +
                "But I'm also useful", "I'm something in your kitchen\n" +
                "I have four legs but I'm not an animal\n" +
                "I can carry a lot of stuff\n" +
                "What am I?", "I'm flat and sometimes I'm fragile. But you still use me to put your food. What am I?"});
        level2Riddle.add(new String[]{"You put me in your mouth but never eats me. What am I?", "I have a friend that's almost always with me on the table. I have multiple tips, but I'm not that sharp. What am I?", "I'm hot, I'm on fire. Sometimes I run on gas, sometime electricity, and even kerosene. What am I?"});
        // Answers
        level2Answer.add(new String[]{"Sink", "Refrigerator", "Chair"});
        level2Answer.add(new String[]{"Knife", "Table", "Plate"});
        level2Answer.add(new String[]{"Spoon", "Fork", "Stove"});
        // Pronounce
        level2Pronounce.add(new String[]{"/sɪŋk/", "/rɪˈfrɪdʒəreɪtə/", "/tʃer/"});
        level2Pronounce.add(new String[]{"/naɪf/", "/ˈteɪ.bəl/", "/pleɪt/"});
        level2Pronounce.add(new String[]{"/spuːn/", "/fɔːrk/", "/stoʊv/"});
        // Status
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
        tempKitchenDataset.add(new LevelModel("id0", 2, 9, level2Riddle, level2Answer, level2Pronounce, level2Status, 1, "Kitchen", 2, true));

        // Level 3
        List<String[]> level3Riddle = new ArrayList<>();
        List<String[]> level3Answer = new ArrayList<>();
        List<String[]> level3Pronounce = new ArrayList<>();
        List<Boolean[]> level3Status = new ArrayList<>();
        // Riddles
        level3Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level3Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level3Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level3Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level3Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level3Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        tempKitchenDataset.add(new LevelModel("id0", 3, 9, level3Riddle, level3Answer, level3Pronounce, level3Status, 1, "Kitchen", 3, false));

        // Level 4
        List<String[]> level4Riddle = new ArrayList<>();
        List<String[]> level4Answer = new ArrayList<>();
        List<String[]> level4Pronounce = new ArrayList<>();
        List<Boolean[]> level4Status = new ArrayList<>();
        // Riddles
        level4Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level4Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level4Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level4Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level4Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level4Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        tempKitchenDataset.add(new LevelModel("id0", 1, 9, level4Riddle, level4Answer, level4Pronounce, level4Status, 2, "Kitchen", 4, false));
    }

    private void riddleClassroomSetup() {
        // Level 1
        List<String[]> level1Riddle = new ArrayList<>();
        List<String[]> level1Answer = new ArrayList<>();
        List<String[]> level1Pronounce = new ArrayList<>();
        List<Boolean[]> level1Status = new ArrayList<>();
        // Riddles
        level1Riddle.add(new String[]{"I’m something that you can write with\n" +
                "When I’ve been used I’m not as long\n" +
                "I often have an eraser\n" +
                "In case you write down something wrong", "This might have a back and legs\n" +
                "But never has an armpit\n" +
                "But it can come after arm\n" +
                "For something on which you’d sit", "When you are feeling hungry\n" +
                "Then you will often eat at this\n" +
                "When you are playing ping pong\n" +
                "It comes before the word ‘tennis’"});
        level1Riddle.add(new String[]{"This thing has a cover\n" +
                "But it is not a bed\n" +
                "It has many pages\n" +
                "And is something that’s read", "I'm white, but some black\n" +
                "Some marker may scratch me\n" +
                "Or if you like you can use a chalk\n" +
                "Don't forget to clean me up", "I’m not a razor\n" +
                "But have a blade\n" +
                "I unblunt items\n" +
                "That have a grade"});
        level1Riddle.add(new String[]{"I’m something that is often round\n" +
                "But I’m not a pizza base\n" +
                "I have hands but don’t have fingers\n" +
                "And have numbers on my face", "I sometimes have lines on me\n" +
                "And other times I am blank\n" +
                "I’m made from a cut down tree\n" +
                "Although I am not a plank", "These are things that have tongues\n" +
                "But don’t have any faces\n" +
                "You wear them on your feet\n" +
                "And they’re done up with laces"});
        // Answers
        level1Answer.add(new String[]{"Pencil", "Chair", "Table"});
        level1Answer.add(new String[]{"Book", "Whiteboard", "Sharpener"});
        level1Answer.add(new String[]{"Clock", "Paper", "Shoes"});
        // Pronounce
        level1Pronounce.add(new String[]{"/ˈpen.səl/", "/tʃer/", "/ˈteɪ.bəl/"});
        level1Pronounce.add(new String[]{"/bʊk/", "/ˈwaɪt.bɔːrd/", "/ˈʃɑːr.pən.ɚ/"});
        level1Pronounce.add(new String[]{"/klɑːk/", "/ˈpeɪ.pɚ/", "/ʃuː/"});
        // Status
        level1Status.add(new Boolean[]{false, false, false});
        level1Status.add(new Boolean[]{false, false, false});
        level1Status.add(new Boolean[]{false, false, false});
        tempClassroomDataset.add(new LevelModel("id0", 1, 9, level1Riddle, level1Answer, level1Pronounce, level1Status, 1, "Classroom", 1, true));

        // Level 2
        List<String[]> level2Riddle = new ArrayList<>();
        List<String[]> level2Answer = new ArrayList<>();
        List<String[]> level2Pronounce = new ArrayList<>();
        List<Boolean[]> level2Status = new ArrayList<>();
        // Riddles
        level2Riddle.add(new String[]{"I’m something that you can write with\n" +
                "When I’ve been used I’m not as long\n" +
                "I often have an eraser\n" +
                "In case you write down something wrong", "This might have a back and legs\n" +
                "But never has an armpit\n" +
                "But it can come after arm\n" +
                "For something on which you’d sit", "When you are feeling hungry\n" +
                "Then you will often eat at this\n" +
                "When you are playing ping pong\n" +
                "It comes before the word ‘tennis’"});
        level2Riddle.add(new String[]{"This thing has a cover\n" +
                "But it is not a bed\n" +
                "It has many pages\n" +
                "And is something that’s read", "I'm white, but some black\n" +
                "Some marker may scratch me\n" +
                "Or if you like you can use a chalk\n" +
                "Don't forget to clean me up", "I’m not a razor\n" +
                "But have a blade\n" +
                "I unblunt items\n" +
                "That have a grade"});
        level2Riddle.add(new String[]{"I’m something that is often round\n" +
                "But I’m not a pizza base\n" +
                "I have hands but don’t have fingers\n" +
                "And have numbers on my face", "I sometimes have lines on me\n" +
                "And other times I am blank\n" +
                "I’m made from a cut down tree\n" +
                "Although I am not a plank", "These are things that have tongues\n" +
                "But don’t have any faces\n" +
                "You wear them on your feet\n" +
                "And they’re done up with laces"});
        // Answers
        level2Answer.add(new String[]{"Mouse", "Cup", "Clock"});
//        level2Answer.add(new String[]{"Pencil", "Chair", "Table"});
        level2Answer.add(new String[]{"Book", "Whiteboard", "Sharpener"});
        level2Answer.add(new String[]{"Clock", "Paper", "Shoes"});
        // Pronounce
        level2Pronounce.add(new String[]{"/ˈpen.səl/", "/tʃer/", "/ˈteɪ.bəl/"});
        level2Pronounce.add(new String[]{"/bʊk/", "/ˈwaɪt.bɔːrd/", "/ˈʃɑːr.pən.ɚ/"});
        level2Pronounce.add(new String[]{"/klɑːk/", "/ˈpeɪ.pɚ/", "/ʃuː/"});
        // Status
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
        tempClassroomDataset.add(new LevelModel("id0", 2, 9, level2Riddle, level2Answer, level2Pronounce, level2Status, 1, "Classroom", 2, true));

        // Level 3
        List<String[]> level3Riddle = new ArrayList<>();
        List<String[]> level3Answer = new ArrayList<>();
        List<String[]> level3Pronounce = new ArrayList<>();
        List<Boolean[]> level3Status = new ArrayList<>();
        // Riddles
        level3Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level3Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level3Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level3Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level3Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level3Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        tempClassroomDataset.add(new LevelModel("id0", 3, 9, level3Riddle, level3Answer, level3Pronounce, level3Status, 1, "Classroom", 3, false));

        // Level 4
        List<String[]> level4Riddle = new ArrayList<>();
        List<String[]> level4Answer = new ArrayList<>();
        List<String[]> level4Pronounce = new ArrayList<>();
        List<Boolean[]> level4Status = new ArrayList<>();
        // Riddles
        level4Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level4Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level4Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level4Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level4Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level4Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        tempClassroomDataset.add(new LevelModel("id0", 1, 9, level4Riddle, level4Answer, level4Pronounce, level4Status, 2, "Classroom", 4, false));
    }

    private void riddleStreetSetup() {
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
//        tempStreetDataset.add(new LevelModel("id0", 1, 9, level1Riddle, level1Answer, level1Status, 1, "Street", 1, true));

        // Level 2
        List<String[]> level2Riddle = new ArrayList<>();
        List<String[]> level2Answer = new ArrayList<>();
        List<Boolean[]> level2Status = new ArrayList<>();
        // Riddles
        level2Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level2Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level2Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level2Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level2Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level2Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
//        tempStreetDataset.add(new LevelModel("id0", 2, 9, level2Riddle, level2Answer, level2Status, 1, "Street", 2, true));

        // Level 3
        List<String[]> level3Riddle = new ArrayList<>();
        List<String[]> level3Answer = new ArrayList<>();
        List<Boolean[]> level3Status = new ArrayList<>();
        // Riddles
        level3Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level3Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level3Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level3Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level3Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level3Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
//        tempStreetDataset.add(new LevelModel("id0", 3, 9, level3Riddle, level3Answer, level3Status, 1, "Street", 3, false));

        // Level 4
        List<String[]> level4Riddle = new ArrayList<>();
        List<String[]> level4Answer = new ArrayList<>();
        List<Boolean[]> level4Status = new ArrayList<>();
        // Riddles
        level4Riddle.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level4Riddle.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level4Riddle.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level4Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level4Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level4Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
//        tempStreetDataset.add(new LevelModel("id0", 1, 9, level4Riddle, level4Answer, level4Status, 2, "Street", 4, false));
    }

    @Override
    public void onResume() {
        super.onResume();
        this.levelAdapter.notifyDataSetChanged();
    }
}
