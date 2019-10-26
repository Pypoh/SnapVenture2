package com.example.pypoh.snapventure.Fragment.MainFragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pypoh.snapventure.Adapter.ChapterRecyclerAdapter;
import com.example.pypoh.snapventure.Lesson.LevelPronounceFragment;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.Model.ChapterModel;
import com.example.pypoh.snapventure.Model.ChatModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class PronounceFragment extends Fragment {

    // Level Fragment
    LevelPronounceFragment levelPronounceFragment = new LevelPronounceFragment();

    // Chapter One
    private View chapterOneView;
    private RelativeLayout chapterOneExpandHeader;
    private ImageView chapterOneBackground;
    private ConstraintLayout chapterOneExpansion;
    private ImageView chapterOneImage;
    private TextView chapterOneText;
    private Button chapterOneGoBtn;

    public static int currentChapter;

    public static String currentState;

    // RecyclerView Chapter
    private RecyclerView chapterRecycler;
    private ChapterRecyclerAdapter chapterRecyclerAdapter;

    List<ChapterModel> mDataChapter = new ArrayList<>();

    // Main Data Conversation
    public static HashMap<String, ChatModel> chapterOneDataConversation = new HashMap<>();

    // Main State
    public static List<String> tempChapterOneState = new ArrayList<>();

    public PronounceFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pronounce, container, false);

        setupChapterView(view);
        chapterOneChatSetup();
        setupChapterRecycler();

        ImageView leaderboardIcon = view.findViewById(R.id.leaderboard_icon);
        leaderboardIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new LeaderboardFragment());
            }
        });

        return view;
    }

    private void setupChapterView(View view) {
        chapterRecycler = view.findViewById(R.id.recycler_pronounce_chapter);
        chapterRecycler.setLayoutManager(new GridLayoutManager(this.getContext(), 3));
        chapterRecyclerAdapter = new ChapterRecyclerAdapter(this.getContext(), mDataChapter);
        chapterRecycler.setAdapter(chapterRecyclerAdapter);
    }

    // Setup Main Data
    private void chapterOneChatSetup() {
        chapterOneDataConversation.clear();
        chapterOneDataConversation.put("3", new ChatModel("3", 1, "Typing..."));
        chapterOneDataConversation.put("-1", new ChatModel("-1", -1, "This is the end of this conversation"));
//        dataConversation.put("5", new ChatModel("5",0, "Typing..."));
        chapterOneDataConversation.put("4", new ChatModel("4", 1, "*result*"));
        chapterOneDataConversation.put("0", new ChatModel("0", 0, "Hi there, my name is Snappy. Nice to meet you!"));
        chapterOneDataConversation.put("0-1", new ChatModel("0-1", 1, "Nice to meet you too!"));
        chapterOneDataConversation.put("0-2", new ChatModel("0-2", 1, "I am sorry, i'm busy right now"));
        chapterOneDataConversation.put("0-1-0", new ChatModel("0-1-0", 0, "Great! By they way, let me ask you something. Are you a student?"));
        chapterOneDataConversation.put("0-2-0", new ChatModel("0-2-0", 0, "Uhh sorry, i didn't mean to disturb you. But, can we chat later? i'm gonna text you a moment later"));
        chapterOneDataConversation.put("0-1-0-1", new ChatModel("0-1-0-1", 1, "Yes, i am a student"));
        chapterOneDataConversation.put("0-1-0-2", new ChatModel("0-1-0-2", 1, "No, i cannot tell you"));
        chapterOneDataConversation.put("0-2-0-1", new ChatModel("0-2-0-1", 1, "Nevermind, you can chat me right now"));
        chapterOneDataConversation.put("0-2-0-2", new ChatModel("0-2-0-2", 1, "Okay. Got to go"));

        if (tempChapterOneState.isEmpty()) {
            tempChapterOneState.add("0");
            currentState = tempChapterOneState.get(tempChapterOneState.size() - 1);
        }
    }

    private void setupChapterRecycler() {
        // Add 5 Chapter
        mDataChapter.clear();
        mDataChapter.add(new ChapterModel(1, 1));
        mDataChapter.add(new ChapterModel(2, 2));
        mDataChapter.add(new ChapterModel(3, 2));
        mDataChapter.add(new ChapterModel(4, 0));
        mDataChapter.add(new ChapterModel(5, 0));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    private void setupChapter1(View view) {
//        // chapterOne Stage Initialization
//        chapterOneView = view.findViewById(R.id.adventure_stage_chapterOne);
//        chapterOneExpandHeader = chapterOneView.findViewById(R.id.layout_expansion_panel_main_menu);
//        chapterOneExpandHeader.setClipToOutline(true);
//        chapterOneBackground = chapterOneView.findViewById(R.id.expansion_panel_main_background);
//        chapterOneBackground.setImageResource(R.color.garden_green);
//        chapterOneExpansion = chapterOneView.findViewById(R.id.container);
//        chapterOneExpansion.setBackgroundResource(R.color.garden_green);
//        chapterOneImage = chapterOneView.findViewById(R.id.image_educational_level_header);
//        chapterOneImage.setImageResource(R.drawable.area_garden);
//        chapterOneText = chapterOneView.findViewById(R.id.text_educational_level_header);
//        chapterOneText.setText("Chapter One");
//        chapterOneGoBtn = chapterOneView.findViewById(R.id.go_btn);
//        chapterOneGoBtn.setTextColor(getResources().getColor(R.color.garden_green));
//        chapterOneGoBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                placeToast("chapterOne");
//                currentChapter = 0;
//                if (currentState == null) currentState = "0";
//                changeFragment(levelPronounceFragment);
//            }
//        });
//    }


}
