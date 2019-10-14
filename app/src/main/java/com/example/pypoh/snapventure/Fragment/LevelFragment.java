package com.example.pypoh.snapventure.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pypoh.snapventure.Adapter.LevelAdapter;
import com.example.pypoh.snapventure.Fragment.MainFragment.AdventureFragment;
import com.example.pypoh.snapventure.Fragment.MainFragment.LeaderboardFragment;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.Model.LevelModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LevelFragment extends Fragment {

    private RecyclerView levelRecycler;
    public static List<LevelModel> tempGardenDataset = new ArrayList<>();
    public static List<LevelModel> tempKitchenDataset = new ArrayList<>();
    public static List<LevelModel> tempClassroomDataset = new ArrayList<>();
    public static List<LevelModel> tempStreetDataset = new ArrayList<>();

    public static LevelAdapter levelAdapter;

    private ImageView leaderboardIcon;


    public LevelFragment() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level, container, false);

        leaderboardIcon = view.findViewById(R.id.leaderboard_icon);
        leaderboardIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new LeaderboardFragment());
            }
        });

        // Setup Riddle and Insert Data to ArrayList
        switch (AdventureFragment.currentPlace) {
            case 0:
                if (tempGardenDataset.isEmpty()) {
                    riddleGardenSetup();
                }
                levelAdapter = new LevelAdapter(getContext(), tempGardenDataset);
                break;
            case 1:
                if (tempKitchenDataset.isEmpty()) {
                    riddleKitchenSetup();
                }
                levelAdapter = new LevelAdapter(getContext(), tempKitchenDataset);
                break;
            case 2:
                if (tempClassroomDataset.isEmpty()) {
                    riddleClassroomSetup();
                }
                levelAdapter = new LevelAdapter(getContext(), tempClassroomDataset);
                break;
            case 3:
                if (tempStreetDataset.isEmpty()) {
                    riddleStreetSetup();
                }
                levelAdapter = new LevelAdapter(getContext(), tempStreetDataset);
                break;
        }

        // Setup RecyclerView
        levelRecycler = view.findViewById(R.id.levelRecycler);
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
        List<String[]> level1RiddleEn = new ArrayList<>();
        List<String[]> level1RiddleId = new ArrayList<>();
        List<String[]> level1Answer = new ArrayList<>();
        List<String[]> level1Pronounce = new ArrayList<>();
        List<Boolean[]> level1Status = new ArrayList<>();

        // Riddles
        level1RiddleEn.add(new String[]{"This gets filled with water\n" +
                "But it’s not a glass or jug\n" +
                "It’s in your kitchen though\n" +
                "At the bottom there’s a hole", "This is something in your kitchen\n" +
                "Meat, milk and yogurt it does hold\n" +
                "The reason you put them in this\n" +
                "Is because it helps keep them cold", "I am a piece of furniture\n" +
                "At a table I’m often found\n" +
                "When I’m there then I have four legs\n" +
                "But at a desk I swivel round"});
        level1RiddleId.add(new String[]{"Aku terisi dengan air\n" +
                "Tetapi aku bukan gelas ataupun kendi\n" +
                "Aku berada di dapurmu\n" +
                "Dibawah aku, terdapat sebuah lubang", "Aku berada di dapur\n" +
                "Aku menampung daging, susu, dan yogurt\n" +
                "Alasan kamu menaruh mereka padaku\n" +
                "Untuk menjaga agar mereka tetap dingin", "Aku merupakan sebuah mebel\n" +
                "Aku sering ditemukan dekat meja makan\n" +
                "Ketika aku disana, aku punya empat kaki\n" +
                "Tetapi di meja kantor, aku bisa beruputar-putar"

        });
        level1RiddleEn.add(new String[]{"I’m something in your kitchen\n" +
                "Although I am not a cup, I have a handle\n" +
                "I’m dangerous\n" +
                "But I'm also useful", "I'm something in your kitchen\n" +
                "I have four legs but I'm not an animal\n" +
                "I can carry a lot of stuff\n" +
                "What am I?", "I'm flat and sometimes I'm fragile. But you still use me to put your food. What am I?"});
        level1RiddleId.add(new String[]{
                "Aku sering berada di dapur\n" +
                        "Aku bukan cangkir tetapi aku punya gagang\n" +
                        "Aku berbahaya\n" +
                        "Tetapi aku sangat berguna", "Aku sering berada di dapur\n" +
                "Aku punya empat kaki tetapi aku bukan hewan\n" +
                "Aku bisa menampung banyak barang\n" +
                "Siapakah aku?", "Aku datar, terkadang aku mudah pecah. Tetapi kamu masih menggunakanku untuk menaruh makananmu, Siapakah aku?"
        });
        level1RiddleEn.add(new String[]{"You put me in your mouth but never eats me. What am I?",
                "I have a friend that's almost always with me on the table. Aku mempunyai beberapa ujung lancip, Tetapi aku tidak tajam. Siapakah aku?",
                "I'm hot, I'm on fire. Sometimes I run on gas, sometime electricity, and even kerosene. What am I?"});
        level1RiddleId.add(new String[]{
                "Kamu menaruh diriku dimulutmu, tetapi kamu tidak pernah memakan aku, Siapakah Aku?",
                "Aku mempunyai teman yang sering bersamaku diatas meja, Aku memiliki ujung?",
                "Aku panas, Aku terbakar, terkadang aku menggunakan gas, terkadang listrik, bahkan minyak tanah, Siapakah aku?"
        });
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
        tempKitchenDataset.add(new LevelModel("id0", 1, 9, level1RiddleEn, level1RiddleId, level1Answer, level1Pronounce, level1Status, 1, "Kitchen", 1, true));

        // Level 2
        List<String[]> level2RiddleEn = new ArrayList<>();
        List<String[]> level2RiddleId = new ArrayList<>();
        List<String[]> level2Answer = new ArrayList<>();
        List<String[]> level2Pronounce = new ArrayList<>();
        List<Boolean[]> level2Status = new ArrayList<>();
        // Riddles
        level2RiddleEn.add(new String[]{"This gets filled with water\n" +
                "But it’s not a glass or jug\n" +
                "It’s in your kitchen though\n" +
                "At the bottom there’s a hole", "This is something in your kitchen\n" +
                "Meat, milk and yogurt it does hold\n" +
                "The reason you put them in this\n" +
                "Is because it helps keep them cold", "I am a piece of furniture\n" +
                "At a table I’m often found\n" +
                "When I’m there then I have four legs\n" +
                "But at a desk I swivel round"});
        level2RiddleId.add(new String[]{"Aku terisi dengan air\n" +
                "Tetapi aku bukan gelas ataupun kendi\n" +
                "Aku berada di dapurmu\n" +
                "Dibawah aku, terdapat sebuah lubang", "Aku berada di dapur\n" +
                "Aku menampung daging, susu, dan yogurt\n" +
                "Alasan kamu menaruh mereka padaku\n" +
                "Untuk menjaga agar mereka tetap dingin", "Aku merupakan sebuah mebel\n" +
                "Aku sering ditemukan dekat meja makan\n" +
                "Ketika aku disana, aku punya empat kaki\n" +
                "Tetapi di meja kantor, aku bisa beruputar-putar"

        });
        level2RiddleEn.add(new String[]{"I’m something in your kitchen\n" +
                "Although I am not a cup, I have a handle\n" +
                "I’m dangerous\n" +
                "But I'm also useful", "I'm something in your kitchen\n" +
                "I have four legs but I'm not an animal\n" +
                "I can carry a lot of stuff\n" +
                "What am I?", "I'm flat and sometimes I'm fragile. But you still use me to put your food. What am I?"});
        level2RiddleId.add(new String[]{
                "Aku sering berada di dapur\n" +
                        "Aku bukan cangkir tetapi aku punya gagang\n" +
                        "Aku berbahaya\n" +
                        "Tetapi aku sangat berguna", "Aku sering berada di dapur\n" +
                "Aku punya empat kaki tetapi aku bukan hewan\n" +
                "Aku bisa menampung banyak barang\n" +
                "Siapakah aku?", "Aku datar, terkadang aku mudah pecah. Tetapi kamu masih menggunakanku untuk menaruh makananmu, Siapakah aku?"
        });

        level2RiddleEn.add(new String[]{"You put me in your mouth but never eats me. What am I?", "I have a friend that's almost always with me on the table. I have multiple tips, but I'm not that sharp. What am I?", "I'm hot, I'm on fire. Sometimes I run on gas, sometime electricity, and even kerosene. What am I?"});
        level2RiddleId.add(new String[]{
                "Kamu menaruh diriku dimulutmu, tetapi kamu tidak pernah memakan aku, Siapakah Aku?",
                "Aku mempunyai teman yang sering bersamaku diatas meja, Aku memiliki ujung?",
                "Aku panas, Aku terbakar, terkadang aku menggunakan gas, terkadang listrik, bahkan minyak tanah, Siapakah aku?"
        });

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
        tempKitchenDataset.add(new LevelModel("id0", 2, 9, level2RiddleEn, level2RiddleId, level2Answer, level2Pronounce, level2Status, 1, "Kitchen", 2, true));

        // Level 3
        List<String[]> level3RiddleEn = new ArrayList<>();
        List<String[]> level3RiddleId = new ArrayList<>();
        List<String[]> level3Answer = new ArrayList<>();
        List<String[]> level3Pronounce = new ArrayList<>();
        List<Boolean[]> level3Status = new ArrayList<>();
        // Riddles
        level3RiddleEn.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level3RiddleEn.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level3RiddleEn.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level3Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level3Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level3Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        tempKitchenDataset.add(new LevelModel("id0", 3, 9, level3RiddleEn, level3RiddleId, level3Answer, level3Pronounce, level3Status, 1, "Kitchen", 3, false));

        // Level 4
        List<String[]> level4RiddleEn = new ArrayList<>();
        List<String[]> level4RiddleId = new ArrayList<>();
        List<String[]> level4Answer = new ArrayList<>();
        List<String[]> level4Pronounce = new ArrayList<>();
        List<Boolean[]> level4Status = new ArrayList<>();
        // Riddles
        level4RiddleEn.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level4RiddleEn.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level4RiddleEn.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level4Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level4Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level4Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        tempKitchenDataset.add(new LevelModel("id0", 1, 9, level4RiddleEn, level4RiddleId, level4Answer, level4Pronounce, level4Status, 2, "Kitchen", 4, false));
    }

    private void riddleClassroomSetup() {
        // Level 1
        List<String[]> level1RiddleEn = new ArrayList<>();
        List<String[]> level1RiddleId = new ArrayList<>();
        List<String[]> level1Answer = new ArrayList<>();
        List<String[]> level1Pronounce = new ArrayList<>();
        List<Boolean[]> level1Status = new ArrayList<>();
        // Riddles
        level1RiddleEn.add(new String[]{"I’m something that you can write with\n" +
                "When I’ve been used I’m not as long\n" +
                "I often have an eraser\n" +
                "In case you write down something wrong", "This might have a back and legs\n" +
                "But never has an armpit\n" +
                "But it can come after arm\n" +
                "For something on which you’d sit", "When you are feeling hungry\n" +
                "Then you will often eat at this\n" +
                "When you are playing ping pong\n" +
                "It comes before the word ‘tennis’"});
        level1RiddleId.add(new String[]{
                "Aku sesuai yang kamu gunakan untuk menulis\n" +
                        "Ketika aku dipakai, aku tidak memanjang\n" +
                        "Terkadang aku membutuhkan penghapus\n" +
                        "Ketika kamu menulis sesuatu yang salah",
                "Aku bisa memiliki punggung dan kaki\n" +
                        "Tetapi aku tidak pernah mempunyai ketiak\n" +
                        "Tetapi itu bisa terdapat setelah tangan\n" +
                        "Sesuatu yang kamu gunakan untuk duduk",
                "Ketika kamu merasa lapar\n" +
                        "Kamu biasanya makan diatas ini\n" +
                        "Ketika kamu sedang bermain ping pong\n" +
                        "Aku adalah kata sebelum 'tenis'"
        });
        level1RiddleEn.add(new String[]{"This thing has a cover\n" +
                "But it is not a bed\n" +
                "It has many pages\n" +
                "And is something that’s read", "I'm white, but some black\n" +
                "Some marker may scratch me\n" +
                "Or if you like you can use a chalk\n" +
                "Don't forget to clean me up", "I’m not a razor\n" +
                "But have a blade\n" +
                "I unblunt items\n" +
                "That have a grade"});
        level1RiddleId.add(new String[]{
                "Aku mempunyai penutup\n" +
                        "Tetapi aku bukan kasur\n" +
                        "Aku mempunyai banyak halaman\n" +
                        "dan merupakan sesuatu yang kamu baca", "Aku putih tapi terkadang hitam\n" +
                "Beberapa spidol dapat menggoresku\n" +
                "Atau jika kamu suka, kamu bisa menggunakan kapur\n" +
                "Jangan lupa untuk membersihkanku", "Aku bukan pisau cukur\n" +
                "Tapi aku punya bilah\n" +
                "Aku menajamkan sesuatu\n" +
                "Yang mempunyai nilai"
        });
        level1RiddleEn.add(new String[]{"I’m something that is often round\n" +
                "But I’m not a pizza base\n" +
                "I have hands but don’t have fingers\n" +
                "And have numbers on my face", "I sometimes have lines on me\n" +
                "And other times I am blank\n" +
                "I’m made from a cut down tree\n" +
                "Although I am not a plank", "These are things that have tongues\n" +
                "But don’t have any faces\n" +
                "You wear them on your feet\n" +
                "And they’re done up with laces"});
        level1RiddleId.add(new String[]{"Bentukku terkadang bundar\n" +
                "Tetapi aku bukan pizza\n" +
                "Aku mempunyai tangan tetapi aku tidak mempunyai jari\n" +
                "Aku punya beberapa angka diwajahku", "Terkadang aku mempunyai beberapa garis\n" +
                "Dan terkadang aku kosong\n" +
                "Aku terbuat dari pohon\n" +
                "Tetapi aku bukan papan", "Aku mempunyai lidah\n" +
                "Tetapi tidak punya wajah\n" +
                "Aku dipakai pada kakimu\n" +
                "Dan diselesikan dengan tali"});
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
        tempClassroomDataset.add(new LevelModel("id0", 1, 9, level1RiddleEn, level1RiddleId, level1Answer, level1Pronounce, level1Status, 1, "Classroom", 1, true));

        // Level 2
        List<String[]> level2RiddleEn = new ArrayList<>();
        List<String[]> level2RiddleId = new ArrayList<>();
        List<String[]> level2Answer = new ArrayList<>();
        List<String[]> level2Pronounce = new ArrayList<>();
        List<Boolean[]> level2Status = new ArrayList<>();
//        // Riddles
//        level2Riddle.add(new String[]{"I’m something that you can write with\n" +
//                "When I’ve been used I’m not as long\n" +
//                "I often have an eraser\n" +
//                "In case you write down something wrong", "This might have a back and legs\n" +
//                "But never has an armpit\n" +
//                "But it can come after arm\n" +
//                "For something on which you’d sit", "When you are feeling hungry\n" +
//                "Then you will often eat at this\n" +
//                "When you are playing ping pong\n" +
//                "It comes before the word ‘tennis’"});
//        level2Riddle.add(new String[]{"This thing has a cover\n" +
//                "But it is not a bed\n" +
//                "It has many pages\n" +
//                "And is something that’s read", "I'm white, but some black\n" +
//                "Some marker may scratch me\n" +
//                "Or if you like you can use a chalk\n" +
//                "Don't forget to clean me up", "I’m not a razor\n" +
//                "But have a blade\n" +
//                "I unblunt items\n" +
//                "That have a grade"});
//        level2Riddle.add(new String[]{"I’m something that is often round\n" +
//                "But I’m not a pizza base\n" +
//                "I have hands but don’t have fingers\n" +
//                "And have numbers on my face", "I sometimes have lines on me\n" +
//                "And other times I am blank\n" +
//                "I’m made from a cut down tree\n" +
//                "Although I am not a plank", "These are things that have tongues\n" +
//                "But don’t have any faces\n" +
//                "You wear them on your feet\n" +
//                "And they’re done up with laces"});
//        // Answers
//        level2Answer.add(new String[]{"Mouse", "Cup", "Clock"});
////        level2Answer.add(new String[]{"Pencil", "Chair", "Table"});
//        level2Answer.add(new String[]{"Book", "Whiteboard", "Sharpener"});
//        level2Answer.add(new String[]{"Clock", "Paper", "Shoes"});

        // Riddles
        level2RiddleEn.add(new String[]{"Mouse", "Cup", "Clock"});
        level2RiddleEn.add(new String[]{"Keyboard", "Monitor", "Laptop"});
        level2RiddleEn.add(new String[]{"Fan", "Backpack", "Glasses"});
        // Answers
        level2Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level2Answer.add(new String[]{"Keyboard", "Monitor", "Laptop"});
        level2Answer.add(new String[]{"Fan", "Backpack", "Glasses"});

        // Pronounce
        level2Pronounce.add(new String[]{"/ˈpen.səl/", "/tʃer/", "/ˈteɪ.bəl/"});
        level2Pronounce.add(new String[]{"/bʊk/", "/ˈwaɪt.bɔːrd/", "/ˈʃɑːr.pən.ɚ/"});
        level2Pronounce.add(new String[]{"/klɑːk/", "/ˈpeɪ.pɚ/", "/ʃuː/"});
        // Status
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
        level2Status.add(new Boolean[]{false, false, false});
        tempClassroomDataset.add(new LevelModel("id0", 2, 9, level2RiddleEn, level2RiddleId, level2Answer, level2Pronounce, level2Status, 1, "Classroom", 2, true));

        // Level 3
        List<String[]> level3RiddleEn = new ArrayList<>();
        List<String[]> level3RiddleId = new ArrayList<>();
        List<String[]> level3Answer = new ArrayList<>();
        List<String[]> level3Pronounce = new ArrayList<>();
        List<Boolean[]> level3Status = new ArrayList<>();
        // Riddles
        level3RiddleEn.add(new String[]{"Riddle 1 Stage 1", "Riddle 2 Stage 1", "Riddle 3 Stage 1"});
        level3RiddleEn.add(new String[]{"Riddle 1 Stage 2", "Riddle 2 Stage 2", "Riddle 3 Stage 2"});
        level3RiddleEn.add(new String[]{"Riddle 1 Stage 3", "Riddle 2 Stage 3", "Riddle 3 Stage 3"});
        // Answers
        level3Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level3Answer.add(new String[]{"Cup", "Answer 2 Stage 2", "Answer 3 Stage 2"});
        level3Answer.add(new String[]{"Clock", "Answer 2 Stage 3", "Answer 3 Stage 3"});
        // Status
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        level3Status.add(new Boolean[]{false, false, false});
        tempClassroomDataset.add(new LevelModel("id0", 3, 9, level3RiddleEn, level3RiddleId, level3Answer, level3Pronounce, level3Status, 1, "Classroom", 3, false));

        // Level 4
        List<String[]> level4RiddleEn = new ArrayList<>();
        List<String[]> level4RiddleId = new ArrayList<>();
        List<String[]> level4Answer = new ArrayList<>();
        List<String[]> level4Pronounce = new ArrayList<>();
        List<Boolean[]> level4Status = new ArrayList<>();
        // Riddles
        level4RiddleEn.add(new String[]{"Mouse", "Cup", "Riddle 3 Clock"});
        level4RiddleEn.add(new String[]{"Keyboard", "Monitor", "Laptop"});
        level4RiddleEn.add(new String[]{"Fan", "Backpack", "Glasses"});
        // Answers
        level4Answer.add(new String[]{"Mouse", "Cup", "Clock"});
        level4Answer.add(new String[]{"Keyboard", "Monitor", "Laptop"});
        level4Answer.add(new String[]{"Fan", "Backpack", "Glasses"});
        // Status
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        level4Status.add(new Boolean[]{false, false, false});
        tempClassroomDataset.add(new LevelModel("id0", 1, 9, level4RiddleEn, level4RiddleId, level4Answer, level4Pronounce, level4Status, 2, "Classroom", 4, false));
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
        levelAdapter.notifyDataSetChanged();
    }
}
