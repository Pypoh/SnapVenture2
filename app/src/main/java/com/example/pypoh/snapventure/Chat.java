package com.example.pypoh.snapventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Toast;

import com.example.pypoh.snapventure.Adapter.AnswerAdapter;
import com.example.pypoh.snapventure.Adapter.ChatAdapter;
import com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment;
import com.example.pypoh.snapventure.Model.ChatModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment.currentState;

public class Chat extends AppCompatActivity {

    private RecyclerView chatRecycler;
    private ChatAdapter chatAdapter;

    private RecyclerView answerRecycler;
    private static AnswerAdapter answerAdapter;

    private List<String> answerMessageList = new ArrayList<>();
    private List<String> emptyList = new ArrayList<>();

    // Component
    private static Button recordButton;

    // Speech Recognition
    private SpeechRecognizer speechRecognizer;
    private Intent mSpeechRecognizerIntent;

    private String resultString;
    private boolean stateResult;
    private boolean stateRecord;
    private String filteredAnswer;
    private String filteredResult;

    // Animation
    private Animation shakeAnimation;

    private int currentActiveChapter = 0;
    public static int currentUserState = 0; // 0 bot, 1 user

    // Main Data
    private List<String> tempChapterOneState;
    public static HashMap<String, ChatModel> dataConversation;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chapter Number");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle extras = getIntent().getExtras();
        Log.d("chatAdapterCountIntasd", "asdfasdf");
        if (extras != null) {
            currentActiveChapter = extras.getInt("chapterNumber");
            Log.d("chatAdapterCountInt", currentActiveChapter + "");
            Log.d("chatAdapterCountInt", "sdfgsdfg");
//                tempChapterOneState = (List<String>) extras.getSerializable("dataState");
//                dataConversation = (HashMap<String, ChatModel>) extras.getSerializable("dataConversation");
        }

        // Button Speech Record
        recordButton = findViewById(R.id.btn_record);

        setupData(currentActiveChapter);

        askPermission();
        setupSpeechRecognizer();


        // Setup RecyclerView
        chatRecycler = findViewById(R.id.recycler_chat);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        chatRecycler.setLayoutManager(linearLayoutManager);
        setRVAdapter();

        answerRecycler = findViewById(R.id.recycler_answer);
        answerRecycler.setLayoutManager(new LinearLayoutManager(this));

        // get current active user
        setRVAnswerAdapter();

        final Handler handlerDelay = new Handler();
        stateRecord = false;
        final Runnable runRecord = new Runnable() {
            @Override
            public void run() {
                Log.d("motionButton", "downpressed");
                if (tempChapterOneState.get(tempChapterOneState.size() - 1).equalsIgnoreCase("4")) {
                    removeLastTempChapterOneState();
                }
                recordButton.setBackgroundResource(R.drawable.mic_active);
                addTempChapterOneState("3");
                chatAdapter.notifyDataSetChanged();
                speechRecognizer.startListening(mSpeechRecognizerIntent);
                stateRecord = true;
            }
        };
        final Runnable fetchResultRecord = new Runnable() {
            @Override
            public void run() {
                Log.d("motionButton", "uppressed");
                speechRecognizer.stopListening();
                removeLastTempChapterOneState();
                chatAdapter.notifyDataSetChanged();
//                        processSpeechRecord(resultString);
            }
        };
        recordButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        if (stateRecord) {
                            Log.d("motionButton", "uppressed");
                            recordButton.setBackgroundResource(R.drawable.mic_on);
                            speechRecognizer.stopListening();
                            removeLastTempChapterOneState();
                            chatAdapter.notifyDataSetChanged();
                            stateRecord = false;
                            recursiveCheck();
                        } else {
                            handlerDelay.removeCallbacks(runRecord);
                        }
                        break;

                    case MotionEvent.ACTION_DOWN:
                        if (!answerAdapter.getSelectedAnswer().equalsIgnoreCase("")) {
                            Log.d("motionButton", "if");
                            handlerDelay.postDelayed(runRecord, 1000);
                        } else {
                            Log.d("motionButton", "else");
                            Toast.makeText(Chat.this, "You haven't choose an answer yet", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                return false;
            }
        });
    }

    private void askPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 100);
        }
    }

    private void setupData(int chapterNumber) {
        switch (chapterNumber) {
            case 1:
                this.tempChapterOneState = PronounceFragment.tempChapterOneState;
                this.dataConversation = PronounceFragment.chapterOneDataConversation;
                Log.d("chatAdapterCountState", tempChapterOneState.size() + "");
                Log.d("chatAdapterCountData", dataConversation.size() + "");
                break;
        }
    }

    public void addTempChapterOneState(String input) {
        tempChapterOneState.add(input);
        currentState = tempChapterOneState.get(tempChapterOneState.size() - 1);
    }

    public void removeLastTempChapterOneState() {
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

    private void setRVAdapter() {
        chatAdapter = new ChatAdapter(this, tempChapterOneState);
        chatRecycler.setAdapter(chatAdapter);
        Log.d("chatAdapterCountStateA", tempChapterOneState.size() + "");
        Log.d("chatAdapterCountDataA", dataConversation.size() + "");
        Log.d("chatAdapterCount", chatAdapter.getItemCount() + "");
        chatRecycler.smoothScrollToPosition(chatAdapter.getItemCount() - 1);
    }

    private void setRVAnswerAdapter() {
        char[] currentStateArray = PronounceFragment.currentState.toCharArray();
        char lastUser = currentStateArray[currentStateArray.length - 1];
        if (lastUser == '0' || lastUser == '3' || lastUser == '4') {
            answerMessageList.clear();
            Log.d("answerAdapter", "Jalan");
            // Getting data match with bot chat state
            for (HashMap.Entry<String, ChatModel> entry : dataConversation.entrySet()) {
                if (entry.getValue().checkLayer() == checkLayer() + 1) {
                    // Check if same with lastState
                    String stateString = entry.getKey().substring(0, entry.getKey().length() - 2);
                    if (stateString.equalsIgnoreCase(currentState)) {
                        answerMessageList.add(entry.getKey());
                        Log.d("answerAdapterAdd", "Jalan");
                    }
                }
            }
            recordButton.setBackgroundResource(R.drawable.mic_off);
            answerAdapter = new AnswerAdapter(this, answerMessageList);
        } else {
            answerAdapter = new AnswerAdapter(this, emptyList);
        }
        answerRecycler.setAdapter(answerAdapter);
    }

    public static void setButtonOn() {
        recordButton.setBackgroundResource(R.drawable.mic_on);
    }

    public static void setButtonOff() {
        recordButton.setBackgroundResource(R.drawable.mic_off);
    }

    private boolean checkDataMap(String key) {
        return dataConversation.containsKey(key);
    }

    private void recursiveCheck() {
        if (stateResult) {
            Log.d("motionButtonRec", resultString);
            processSpeechRecord(resultString);
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    recursiveCheck();
                }
            }, 500);
        }
    }

    private void processSpeechRecord(final String result) {
        // Show Speech Record Result
        dataConversation.get("4").setMessage(result);
        addTempChapterOneState("4");
        chatAdapter.notifyDataSetChanged();

        // get answer key
        final String selectedAnswerKey = answerAdapter.getSelectedAnswer();

        // Show if the result match with answer
        if (selectedAnswerKey != null && !selectedAnswerKey.equals("")) {
            // filtering answer message
            filteredAnswer = null;
            filteredResult = null;
            if (result != null && !result.equals("")) {
                filteredAnswer = dataConversation.get(selectedAnswerKey).getMessage().replaceAll("[^a-zA-Z0-9\\s+]", "");
                filteredResult = result.replaceAll("[^a-zA-Z0-9\\s+]", "");
            }
            if (filteredResult == null) {
                Toast.makeText(Chat.this, "Jangan cepet cepet lepasnya ya", Toast.LENGTH_SHORT).show();
                removeLastTempChapterOneState();
                chatAdapter.notifyDataSetChanged();
                return;
            }
            if (filteredResult.equalsIgnoreCase(filteredAnswer)) {
                // Off button
                recordButton.setBackgroundResource(R.drawable.mic_off);

                // Remove temp record result chat bubble
                removeLastTempChapterOneState();
                chatAdapter.notifyDataSetChanged();

                // Set bubble animation to right selected answer
                Objects.requireNonNull(dataConversation.get(selectedAnswerKey)).setBubbleAnimation(true);

                // Add right selected answer to chat bubble
                addTempChapterOneState(selectedAnswerKey);
                chatAdapter.notifyDataSetChanged();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Objects.requireNonNull(dataConversation.get(selectedAnswerKey)).setBubbleAnimation(false);
                        resultString = "";
                    }
                }, 2000);

                // add new event delay for bot to chat
                addBotResponse();

            } else {
                Objects.requireNonNull(dataConversation.get("4")).setAnswerStatus(false);
                resultString = "";
                chatAdapter.notifyDataSetChanged();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Objects.requireNonNull(dataConversation.get("4")).setAnswerStatus(true);
                    }
                }, 2000);
            }
        } else {
            Toast.makeText(getApplicationContext(), "You haven't choose an answer yet", Toast.LENGTH_SHORT).show();
            tempChapterOneState.remove(tempChapterOneState.size() - 1);
            chatAdapter.notifyDataSetChanged();
        }
    }

    // Bot Response
    boolean loadingBotRead;

    private void addBotResponse() {
        setRVAnswerAdapter();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                addTempChapterOneState("5");
//                loadingBotRead = true;
//            }
//        }, 3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentState += "-0";
                if (!checkDataMap(currentState)) {
                    addTempChapterOneState("-1");
                    chatAdapter.notifyDataSetChanged();
                    return;
                }
                addTempChapterOneState(currentState);
                setRVAnswerAdapter();
            }
        }, 3000);
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)) {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                finish();
            }
        }
    }

    public static void refreshData() {
        answerAdapter.notifyDataSetChanged();
    }

    private void setupSpeechRecognizer() {
        mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,
                Locale.getDefault());
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches = results
                        .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

                if (matches != null) {
                    Log.d("speechRecogResult", matches.get(0));
                    resultString = matches.get(0);
                    stateResult = true;
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {

            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });
    }
}