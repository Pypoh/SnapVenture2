package com.example.pypoh.snapventure.Fragment.MainFragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

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

import com.example.pypoh.snapventure.Fragment.LevelFragment;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;

import java.util.Objects;

public class AdventureFragment extends Fragment {

    private Button button;
    private LevelFragment levelFragment = new LevelFragment();

    // Garden Stage
    private View gardenView;
    private RelativeLayout gardenExpandHeader;
    private ImageView gardenBackground;
    private ConstraintLayout gardenExpansion;
    private ImageView gardenImage;
    private TextView gardenText;
    private Button gardenGoBtn;

    // Kitchen Stage
    private View kitchenView;
    private RelativeLayout kitchenExpandHeader;
    private ImageView kitchenBackground;
    private ConstraintLayout kitchenExpansion;
    private ImageView kitchenImage;
    private TextView kitchenText;
    private Button kitchenGoBtn;

    // Classroom Stage
    private View classroomView;
    private RelativeLayout classroomExpandHeader;
    private ImageView classroomBackground;
    private ConstraintLayout classroomExpansion;
    private ImageView classroomImage;
    private TextView classroomText;
    private Button classroomGoBtn;

    // Street Stage
    private View streetView;
    private RelativeLayout streetExpandHeader;
    private ImageView streetBackground;
    private ConstraintLayout streetExpansion;
    private ImageView streetImage;
    private TextView streetText;
    private Button streetnGoBtn;
    

    public AdventureFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adventure, container, false);

        setupGarden(view);
        setupKitchen(view);
        setupClassroom(view);
        setupStreet(view);
        
        button = view.findViewById(R.id.go_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(levelFragment);
            }
        });

        // TODO: Name and Level

        // TODO: Energy, Total Stars

        // TODO: Stage Chooser


        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupStreet(View view) {
        // Street Stage Initialization
        streetView = view.findViewById(R.id.adventure_stage_street);
        streetExpandHeader = streetView.findViewById(R.id.layout_expansion_panel_main_menu);
        streetExpandHeader.setClipToOutline(true);
        streetBackground = streetView.findViewById(R.id.expansion_panel_main_background);
        streetBackground.setImageResource(R.color.street_black);
        streetExpansion = streetView.findViewById(R.id.container);
        streetExpansion.setBackgroundResource(R.color.street_black);
        streetImage = streetView.findViewById(R.id.image_educational_level_header);
//        streetImage.setImageResource(R.drawable.area_street);
        streetText = streetView.findViewById(R.id.text_educational_level_header);
        streetText.setText("Street");
        streetnGoBtn = streetView.findViewById(R.id.go_btn);
        streetnGoBtn.setTextColor(getResources().getColor(R.color.street_black));
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupClassroom(View view) {
        // Classroom Stage Initialization
        classroomView = view.findViewById(R.id.adventure_stage_classroom);
        classroomExpandHeader = classroomView.findViewById(R.id.layout_expansion_panel_main_menu);
        classroomExpandHeader.setClipToOutline(true);
        classroomBackground = classroomView.findViewById(R.id.expansion_panel_main_background);
        classroomBackground.setImageResource(R.color.classroom_red);
        classroomExpansion = classroomView.findViewById(R.id.container);
        classroomExpansion.setBackgroundResource(R.color.classroom_red);
        classroomImage = classroomView.findViewById(R.id.image_educational_level_header);
        classroomImage.setImageResource(R.drawable.area_classroom);
        classroomText = classroomView.findViewById(R.id.text_educational_level_header);
        classroomText.setText("Classroom");
        classroomGoBtn = classroomView.findViewById(R.id.go_btn);
        classroomGoBtn.setTextColor(getResources().getColor(R.color.classroom_red));
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupKitchen(View view) {
        // kitchen Stage Initialization
        kitchenView = view.findViewById(R.id.adventure_stage_kitchen);
        kitchenExpandHeader = kitchenView.findViewById(R.id.layout_expansion_panel_main_menu);
        kitchenExpandHeader.setClipToOutline(true);
        kitchenBackground = kitchenView.findViewById(R.id.expansion_panel_main_background);
        kitchenBackground.setImageResource(R.color.kitchen_yellow);
        kitchenExpansion = kitchenView.findViewById(R.id.container);
        kitchenExpansion.setBackgroundResource(R.color.kitchen_yellow);
        kitchenImage = kitchenView.findViewById(R.id.image_educational_level_header);
        kitchenImage.setImageResource(R.drawable.area_kitchen);
        kitchenText = kitchenView.findViewById(R.id.text_educational_level_header);
        kitchenText.setText("Kitchen");
        kitchenGoBtn = kitchenView.findViewById(R.id.go_btn);
        kitchenGoBtn.setTextColor(getResources().getColor(R.color.kitchen_yellow));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupGarden(View view) {
        // Garden Stage Initialization
        gardenView = view.findViewById(R.id.adventure_stage_garden);
        gardenExpandHeader = gardenView.findViewById(R.id.layout_expansion_panel_main_menu);
        gardenExpandHeader.setClipToOutline(true);
        gardenBackground = gardenView.findViewById(R.id.expansion_panel_main_background);
        gardenBackground.setImageResource(R.color.garden_green);
        gardenExpansion = gardenView.findViewById(R.id.container);
        gardenExpansion.setBackgroundResource(R.color.garden_green);
        gardenImage = gardenView.findViewById(R.id.image_educational_level_header);
        gardenImage.setImageResource(R.drawable.area_garden);
        gardenText = gardenView.findViewById(R.id.text_educational_level_header);
        gardenText.setText("Garden");
        gardenGoBtn = gardenView.findViewById(R.id.go_btn);
        gardenGoBtn.setTextColor(getResources().getColor(R.color.garden_green));
    }


}
