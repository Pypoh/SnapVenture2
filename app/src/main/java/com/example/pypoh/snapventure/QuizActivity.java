package com.example.pypoh.snapventure;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pypoh.snapventure.BattlePages.MatchingFragment;
import com.example.pypoh.snapventure.Model.QuestionModel;
import com.example.pypoh.snapventure.Model.RoomModel;
import com.example.pypoh.snapventure.Model.UserModel;

public class QuizActivity extends AppCompatActivity {

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

    private int stateRound = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getWindow().setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));

        setupView();
    }

    private void setupView() {
        // setup View Ids
        player1Name = findViewById(R.id.text_player1_name);
        player1Score = findViewById(R.id.text_player1_score);
        player2Name = findViewById(R.id.text_player2_name);
        player2Score = findViewById(R.id.text_player2_score);
        round = findViewById(R.id.text_round);
        questionHeader = findViewById(R.id.text_question_header);
        questionText = findViewById(R.id.text_question);
        answerA = findViewById(R.id.text_answer_a);
        answerB = findViewById(R.id.text_answer_b);
        answerC = findViewById(R.id.text_answer_c);
        answerD = findViewById(R.id.text_answer_d);
        answerACard = findViewById(R.id.answer_card_a);
        answerBCard = findViewById(R.id.answer_card_b);
        answerCCard = findViewById(R.id.answer_card_c);
        answerDCard = findViewById(R.id.answer_card_d);

        // Dataset
        UserModel user = MatchingFragment.userModels.get(0);
        UserModel opponent = MatchingFragment.opponentModels.get(0);
        RoomModel room = MatchingFragment.roomData.get(0);
        final QuestionModel question = MatchingFragment.questionDataSet.get(stateRound);

        // setup view listener & content
        player1Name.setText(user.getName());
        player1Score.setText(room.getScore1() + "");
        player2Name.setText(opponent.getName());
        player2Score.setText(room.getScore2() + "");
        round.setText((stateRound+1) + "");
        questionHeader.setText("Question " + (stateRound+1));
        questionText.setText(question.getQuestion());
        answerA.setText(question.getAnswerA());
        answerB.setText(question.getAnswerB());
        answerC.setText(question.getAnswerC());
        answerD.setText(question.getAnswerD());
        answerACard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAnswer("answerA", question.getCorrectAnswerID())) {
                    setCorrectAnswerCardBackground(answerACard, answerA);
                } else {
                    setCorrectAnswerCard(answerACard, answerA, question.getCorrectAnswerID());
                }
            }
        });
        answerBCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAnswer("answerB", question.getCorrectAnswerID())) {
                    setCorrectAnswerCardBackground(answerACard, answerA);
                } else {
                    setCorrectAnswerCard(answerBCard, answerB, question.getCorrectAnswerID());
                }
            }
        });
        answerCCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAnswer("answerC", question.getCorrectAnswerID())) {
                    setCorrectAnswerCardBackground(answerACard, answerA);
                } else {
                    setCorrectAnswerCard(answerCCard, answerC, question.getCorrectAnswerID());
                }
            }
        });
        answerDCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAnswer("answerD", question.getCorrectAnswerID())) {
                    setCorrectAnswerCardBackground(answerACard, answerA);
                } else {
                    setCorrectAnswerCard(answerDCard, answerD, question.getCorrectAnswerID());
                }
            }
        });
    }

    private boolean checkAnswer (String answer, String correctAnswer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }

    private void setCorrectAnswerCard(CardView wrongAnswerCard, TextView wrongTextView, String correctAnswer) {
        wrongAnswerCard.setCardBackgroundColor(this.getResources().getColor(R.color.classroom_red));
        wrongTextView.setTextColor(this.getResources().getColor(R.color.white));

        switch (correctAnswer) {
            case "answerA":
                answerACard.setCardBackgroundColor(this.getResources().getColor(R.color.garden_green));
                answerA.setTextColor(this.getResources().getColor(R.color.white));
                break;
            case "answerB":
                answerBCard.setCardBackgroundColor(this.getResources().getColor(R.color.garden_green));
                answerB.setTextColor(this.getResources().getColor(R.color.white));
                break;
            case "answerC":
                answerCCard.setCardBackgroundColor(this.getResources().getColor(R.color.garden_green));
                answerC.setTextColor(this.getResources().getColor(R.color.white));
                break;
            case "answerD":
                answerDCard.setCardBackgroundColor(this.getResources().getColor(R.color.garden_green));
                answerD.setTextColor(this.getResources().getColor(R.color.white));
                break;
        }
    }

    private void setCorrectAnswerCardBackground (CardView answerCard, TextView answer) {
        answerCard.setCardBackgroundColor(this.getResources().getColor(R.color.garden_green));
        answer.setTextColor(this.getResources().getColor(R.color.white));
    }
}
