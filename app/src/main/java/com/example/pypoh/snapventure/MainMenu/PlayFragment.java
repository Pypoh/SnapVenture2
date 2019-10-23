package com.example.pypoh.snapventure.MainMenu;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.pypoh.snapventure.Adapter.ModeAdapter;
import com.example.pypoh.snapventure.Auth.AuthActivity;
import com.example.pypoh.snapventure.Fragment.MainFragment.AdventureFragment;
import com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment;
import com.example.pypoh.snapventure.Model.ModeModel;
import com.example.pypoh.snapventure.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.relex.circleindicator.CircleIndicator2;

public class PlayFragment extends Fragment {

    private LinearLayout snapModeBtn, pronounceModeBtn, quizModeBtn;

    private RecyclerView modeRecycler;
    private ModeAdapter modeAdapter;

    private AdventureFragment adventureFragment = new AdventureFragment();
    private PronounceFragment pronounceFragment = new PronounceFragment();

    private List<ModeModel> mainData = new ArrayList<>();

    public PlayFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_play, container, false);

        setupViews(view);

        if (mainData.isEmpty()) {
            setupMainData();
        }

        modeRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        modeAdapter = new ModeAdapter(getContext(), mainData);
        modeRecycler.setAdapter(modeAdapter);

        modeAdapter.setOnItemClickListener(new ModeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ModeModel modeModel) {
                switch (modeModel.getMode()) {
                    case 1:
                        changeFragment(adventureFragment);
                        break;
                    case 2:
                        changeFragment(pronounceFragment);
                        break;
                    case 3:
                        Toast.makeText(getContext(), "Under Development", Toast.LENGTH_SHORT).show();
                }
            }
        });

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(modeRecycler);

        CircleIndicator2 indicator = view.findViewById(R.id.modes_indicator);
        indicator.attachToRecyclerView(modeRecycler, pagerSnapHelper);

        return view;
    }

    private void setupMainData() {
        mainData.add(new ModeModel("Snap", "ini deskripsi yaaaa", 1));
        mainData.add(new ModeModel("Pronounce", "ini deskripsi yaaaa", 2));
        mainData.add(new ModeModel("Quiz", "ini deskripsi yaaaa", 3));
    }

    private void setupViews(View view) {

        modeRecycler = view.findViewById(R.id.recycler_mode);
//        snapModeBtn = view.findViewById(R.id.snap_mode);
//        snapModeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeFragment(adventureFragment);
//            }
//        });
//        pronounceModeBtn = view.findViewById(R.id.pronounce_mode);
//        pronounceModeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                changeFragment(pronounceFragment);
//            }
//        });
//        quizModeBtn = view.findViewById(R.id.quiz_mode);
//        quizModeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "Under Development", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }
}
