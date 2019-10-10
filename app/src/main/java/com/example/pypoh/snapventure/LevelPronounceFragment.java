package com.example.pypoh.snapventure;

import android.content.Context;
import android.content.Intent;
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

import com.example.pypoh.snapventure.Adapter.ChatAdapter;
import com.example.pypoh.snapventure.Adapter.LevelAdapter;
import com.example.pypoh.snapventure.Fragment.MainFragment.AdventureFragment;
import com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment;
import com.example.pypoh.snapventure.Model.ChatModel;
import com.example.pypoh.snapventure.Model.LevelModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment.currentState;


public class LevelPronounceFragment extends Fragment {

    public static List<String> tempChapterOneState = new ArrayList<>();
    public static HashMap<String, ChatModel> dataConversation = new HashMap<>();

    private Button testBtn;

    public LevelPronounceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_pronounce, container, false);

        setupView(view);

        switch (PronounceFragment.currentChapter) {
            case 0:
                if (dataConversation.isEmpty()) {
                    chapterOneChatSetup();
                }
                break;
            default:
                break;
        }

        return view;
    }

    private void chapterOneChatSetup() {
        dataConversation.put("3", new ChatModel("3",1, "Typing..."));
        dataConversation.put("4", new ChatModel("4",1, "*result*"));
        dataConversation.put("0", new ChatModel("0",0, "Hey Guest, Im Sherazet. You can call me Shera. I'm the girl that ask your phone number at school today. Do you mind if i chat you because i'm lonely"));
        dataConversation.put("0-1", new ChatModel("0-1",1, "Of course, We can be friends"));
        dataConversation.put("0-2", new ChatModel("0-2",1, "I am sorry, i'm still busy right now"));
        dataConversation.put("0-1-0", new ChatModel("0-1-0",0, "Thank you so much. So, how about your first day of school?"));
        dataConversation.put("0-2-0", new ChatModel("0-2-0",0, "Uhh sorry, i didn't mean to disturb you. But, can we chat later? i'm gonna text you a moment later"));
        dataConversation.put("0-1-0-1", new ChatModel("0-1-0-1",1, "That is great, i made some new friends"));
        dataConversation.put("0-1-0-2", new ChatModel("0-1-0-2",1, "Not great, i got bored because i don't have any friends"));
        dataConversation.put("0-2-0-1", new ChatModel("0-2-0-1",1, "Nevermind, you can chat me right now"));
        dataConversation.put("0-2-0-2", new ChatModel("0-2-0-2", 1, "Okay. Got to go"));

        if (tempChapterOneState.isEmpty()) {
            tempChapterOneState.add("0");
//            tempChapterOneState.add("3");
//            tempChapterOneState.add("0-1");
//            tempChapterOneState.add("0-1-0");
            currentState = tempChapterOneState.get(tempChapterOneState.size() - 1);
        }
    }

    public static void addTempChapterOneState(String input) {
        tempChapterOneState.add(input);
        currentState = tempChapterOneState.get(tempChapterOneState.size() - 1);
    }

    public static void removeLastTempChapterOneState() {
        tempChapterOneState.remove(tempChapterOneState.size() - 1);
        currentState = tempChapterOneState.get(tempChapterOneState.size() - 1);
    }

    public static int checkLayer() {
        int layerCount = 0;
        char[] stateToArray = currentState.toCharArray();
        for (char item : stateToArray) {
            if (item == '0' || item == '1' || item == '2') {
                layerCount++;
            }
        }
        return layerCount;
    }

    private void setupView(View view) {
        testBtn = view.findViewById(R.id.test_btn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toChat = new Intent(getContext(), Chat.class);
                startActivity(toChat);
            }
        });


    }


}
