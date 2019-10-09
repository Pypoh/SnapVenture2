package com.example.pypoh.snapventure.Fragment.MainFragment;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pypoh.snapventure.LevelPronounceFragment;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;

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

    public PronounceFragment() {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pronounce, container, false);

        setupChapter1(view);

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupChapter1(View view) {
        // chapterOne Stage Initialization
        chapterOneView = view.findViewById(R.id.adventure_stage_chapterOne);
        chapterOneExpandHeader = chapterOneView.findViewById(R.id.layout_expansion_panel_main_menu);
        chapterOneExpandHeader.setClipToOutline(true);
        chapterOneBackground = chapterOneView.findViewById(R.id.expansion_panel_main_background);
        chapterOneBackground.setImageResource(R.color.garden_green);
        chapterOneExpansion = chapterOneView.findViewById(R.id.container);
        chapterOneExpansion.setBackgroundResource(R.color.garden_green);
        chapterOneImage = chapterOneView.findViewById(R.id.image_educational_level_header);
        chapterOneImage.setImageResource(R.drawable.area_garden);
        chapterOneText = chapterOneView.findViewById(R.id.text_educational_level_header);
        chapterOneText.setText("Chapter One");
        chapterOneGoBtn = chapterOneView.findViewById(R.id.go_btn);
        chapterOneGoBtn.setTextColor(getResources().getColor(R.color.garden_green));
        chapterOneGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                placeToast("chapterOne");
                currentChapter = 0;
                if (currentState == null) currentState = "0";
                changeFragment(levelPronounceFragment);
            }
        });

    }
}
