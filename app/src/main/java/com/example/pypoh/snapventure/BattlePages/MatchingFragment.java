package com.example.pypoh.snapventure.BattlePages;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.Model.QuestionModel;
import com.example.pypoh.snapventure.Model.RoomModel;
import com.example.pypoh.snapventure.Model.UserModel;
import com.example.pypoh.snapventure.QuizActivity;
import com.example.pypoh.snapventure.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Timer;


public class MatchingFragment extends Fragment {

    private TextView player1Text;
    private TextView player2Text;
    private TextView matchingText;
    private String matching;

    private FrameLayout foundLayout;

    private Handler matchingHandler = new Handler();
    private Runnable matchingRunnable;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private FirebaseFirestore db;

    private List<String> allPlayerID = new ArrayList<>();
    private List<String> questionIds = new ArrayList<>();

    private String opponentID = "";

    private OpponentFragment opponentFragment = new OpponentFragment();

    public static List<UserModel> userModels = new ArrayList<>();
    public static List<UserModel> opponentModels = new ArrayList<>();
    public static List<QuestionModel> questionDataSet = new ArrayList<>();
    public static List<RoomModel> roomData = new ArrayList<>();

    private BottomNavigationView bottomNavigationView;

    private int stateRound = 0;

    private LayoutInflater layoutInflater;
    private ViewGroup viewGroup;

    // New Quiz Layout
    private TextView player1Name;
    private TextView player1Score;
    private TextView player2Name;
    private TextView player2Score;
    private TextView round;
    private TextView questionHeader;
    private TextView questionText;
    private TextView answerA;
    private TextView answerB;
    private TextView answerC;
    private TextView answerD;

    private CardView answerACard;
    private CardView answerBCard;
    private CardView answerCCard;
    private CardView answerDCard;


    public MatchingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_matching, container, false);

        layoutInflater = inflater;
        viewGroup = container;

        bottomNavigationView = getActivity().findViewById(R.id.nav_view);
        bottomNavigationView.setVisibility(View.GONE);

        matchingText = view.findViewById(R.id.text_matching);
        player1Text = view.findViewById(R.id.text_player1);
        player2Text = view.findViewById(R.id.text_player2);
        foundLayout = view.findViewById(R.id.layout_found);

        instanceFirebase();

        matchingRunnable = new Runnable() {
            @Override
            public void run() {
                if (matching.equalsIgnoreCase("Matching...")) {
                    matching = "Matching";
                    matchingText.setText(matching);
                }
                matching += ".";
                matchingText.setText(matching);
                Log.d("matchingText", matching);
                matchingHandler.postDelayed(this, 500);
            }
        };

        loadMatchingPerSecond();
        findPlayer();

//        insertQuestion();
        return view;
    }

    private void findPlayer() {
        CollectionReference userRef = db.collection("users");

        allPlayerID.clear();

        userRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        allPlayerID.add(document.getId());
                    }

                    opponentID = getRandomData(allPlayerID);
                    playMatch(opponentID);
                } else {
                    Toast.makeText(getContext(), "Failed Matchmaking", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getAllQuestions() {
        CollectionReference questionRef = db.collection("battle_questions");

        questionIds.clear();

        questionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        questionIds.add(document.getId());
                    }
                    Collections.shuffle(questionIds);
                    int questionLength = 5;

                    List<String> questionTemp = questionIds.subList(0, questionLength);
                    questionIds = questionTemp;
//                    questionIds.clear();
//                    questionIds.addAll(questionTemp);

                    // get question details data
                    getQuestionsData();
                } else {
                    Toast.makeText(getContext(), "Can't Get Questions", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getQuestionsData() {
        questionDataSet.clear();
        for (String questionId : questionIds) {
            DocumentReference questionRef = db.collection("battle_questions").document(questionId);
            questionRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    QuestionModel questionModel = documentSnapshot.toObject(QuestionModel.class);
                    questionDataSet.add(questionModel);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });
        }

        if (!questionDataSet.isEmpty()) {
            // Proceed to Create Room
            createRoom();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    createRoom();
                }
            }, 1000);
        }
    }

    private void insertQuestion() {
        DocumentReference documentReference = db.collection("battle_questions").document();
        documentReference.set(new QuestionModel("This is a question", "Answer A", "Answer B", "Answer C", "Answer D", "answerA"));
    }

    private void playMatch(String opponentID) {
        if (!opponentID.equals("")) {
            getPlayersData(opponentID);
            Log.d("TestData", opponentID);
        }
    }

    private String getRandomData(List<String> allPlayerID) {
        String opponentID = "";
        Random randomGenerator = new Random();
        if (!allPlayerID.isEmpty()) {
            opponentID = allPlayerID.get(randomGenerator.nextInt(allPlayerID.size()));
            Log.d("RandomDataTest", mUser.getUid() + " : " + opponentID);
            if (opponentID.equals(mUser.getUid())) {
                getRandomData(allPlayerID);
                Log.d("RandomDataEq", "Yes");
            } else {
                return opponentID;
            }
        }
        return "Empty List";
    }

    private void getPlayersData(final String opponentID) {
        userModels.clear();
        DocumentReference userRef = db.collection("users").document(mUser.getUid());
        userRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot == null) {
                    Log.d("TestDataSaved", "OnSuccess : Null");
                } else {
                    UserModel userModel = documentSnapshot.toObject(UserModel.class);
                    userModels.add(userModel);
                    getOpponentData(opponentID);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Failed Get User", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getOpponentData(String opponentID) {
        opponentModels.clear();
        DocumentReference opponentRef = db.collection("users").document(opponentID);
        opponentRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                UserModel userModel = documentSnapshot.toObject(UserModel.class);
                opponentModels.add(userModel);
                getAllQuestions();
//                createRoom();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Failed Get Opponent", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void createRoom() {
        final UserModel userData = userModels.get(0);
        final UserModel opponentData = opponentModels.get(0);

        if (userData != null && opponentData != null) {
            DocumentReference roomRef = db.collection("rooms").document();
            final RoomModel roomModel = new RoomModel(userData.getId(), opponentData.getId(), 0, 0, "OnGoing", userData.getId());
            roomRef.set(roomModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
//                        Toast.makeText(getContext(), "Room Created", Toast.LENGTH_SHORT).show();
                        Log.d("roomCreation", "Room Created");
                        roomData.add(roomModel);
                        getActivity().getWindow().setStatusBarColor(getContext().getResources().getColor(R.color.colorPrimary));
                        foundLayout.setVisibility(View.VISIBLE);
                        player1Text.setText(userData.getName());
                        player2Text.setText(opponentData.getName());
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                toQuiz();
                            }
                        }, 3000);
//                        startNewLayoutQuizView(stateRound);
                    } else {
//                        Toast.makeText(getContext(), "Room Not Created", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        } else {
            Toast.makeText(getContext(), "Waiting for Connection", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    findPlayer();
                }
            }, 1000);
        }
    }

    private void toQuiz() {
        Intent toQuiz = new Intent(getContext(), QuizActivity.class);
        startActivity(toQuiz);
        this.getActivity().finish();
    }

//    private void startNewLayoutQuizView(int stateRound) {
//        FrameLayout container = (FrameLayout) getActivity().findViewById(R.id.matching_container);
//        View view = layoutInflater.inflate(R.layout.fragment_quiz_battle, container, false);
//        LayoutInflater.from(getActivity())
//                .inflate(R.layout.fragment_quiz_battle, container, false);
//
//        // setup View Ids
//        player1Name = view.findViewById(R.id.text_player1_name);
//        player1Score = view.findViewById(R.id.text_player1_score);
//        player2Name = view.findViewById(R.id.text_player2_name);
//        player2Score = view.findViewById(R.id.text_player2_score);
//        round = view.findViewById(R.id.text_round);
//        questionHeader = view.findViewById(R.id.text_question_header);
//        questionText = view.findViewById(R.id.text_question);
//        answerA = view.findViewById(R.id.text_answer_a);
//        answerB = view.findViewById(R.id.text_answer_b);
//        answerC = view.findViewById(R.id.text_answer_c);
//        answerD = view.findViewById(R.id.text_answer_d);
//        answerACard = view.findViewById(R.id.answer_card_a);
//        answerBCard = view.findViewById(R.id.answer_card_b);
//        answerCCard = view.findViewById(R.id.answer_card_c);
//        answerDCard = view.findViewById(R.id.answer_card_d);
//
//        // Start Quiz
////        startQuiz();
//    }

//    private void startQuiz() {
//        // Model
//        UserModel user = userModels.get(0);
//        UserModel opponent = userModels.get(0);
//        final QuestionModel question = questionDataSet.get(stateRound);
//        RoomModel room = roomData.get(0);
//
//
//    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bottomNavigationView.setVisibility(View.VISIBLE);
        getActivity().getWindow().setStatusBarColor(getContext().getResources().getColor(R.color.white));
    }

    private void instanceFirebase() {
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
    }

    private void loadMatchingPerSecond() {
        matching = "Matching";
        matchingHandler.postDelayed(matchingRunnable, 500);
    }

    @Override
    public void onPause() {
        super.onPause();
        matchingHandler.removeCallbacks(matchingRunnable);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        matchingHandler.removeCallbacks(matchingRunnable);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment, String args) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment, args);
    }
}
