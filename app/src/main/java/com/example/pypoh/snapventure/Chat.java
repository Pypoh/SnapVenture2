package com.example.pypoh.snapventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pypoh.snapventure.Adapter.AnswerAdapter;
import com.example.pypoh.snapventure.Adapter.ChatAdapter;
import com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.Model.ChatModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment.currentState;
import static com.example.pypoh.snapventure.LevelPronounceFragment.dataConversation;
import static com.example.pypoh.snapventure.LevelPronounceFragment.tempChapterOneState;

public class Chat extends AppCompatActivity {

    private RecyclerView chatRecycler;
    private ChatAdapter chatAdapter;

    private RecyclerView answerRecycler;
    private static AnswerAdapter answerAdapter;

    private List<String> answerMessageList = new ArrayList<>();
    private List<String> emptyList = new ArrayList<>();


    public static int currentUserState = 0; // 0 bot, 1 user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chapter Number");

        // Setup RecyclerView
        chatRecycler = findViewById(R.id.recycler_chat);
        chatRecycler.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter(this, tempChapterOneState);
        chatRecycler.setAdapter(chatAdapter);

        answerRecycler = findViewById(R.id.recycler_answer);
        answerRecycler.setLayoutManager(new LinearLayoutManager(this));
        // get current active user
        char[] currentStateArray = PronounceFragment.currentState.toCharArray();
        char lastUser = currentStateArray[currentStateArray.length - 1];
        Log.d("lastUser", lastUser + "");
        if (lastUser == '0') {
            answerMessageList.clear();

            // Getting data match with bot chat state
            for (HashMap.Entry<String, ChatModel> entry : dataConversation.entrySet()) {
                if (entry.getValue().checkLayer() == LevelPronounceFragment.checkLayer()+1) {
                    answerMessageList.add(entry.getKey());
                }
            }

            answerAdapter = new AnswerAdapter(this, answerMessageList);
        } else {
            answerAdapter = new AnswerAdapter(this, emptyList);
        }
        answerRecycler.setAdapter(answerAdapter);

        // TODO: voice recognition using partial result with button onkey up/down listener (use android intent speech recognition)
        //  show it in chat bubble. after that, check if the answer is different from chat data or not

    }

    public static void refreshData() {
        answerAdapter.notifyDataSetChanged();
    }
}