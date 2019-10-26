package com.example.pypoh.snapventure.Fragment.MainFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pypoh.snapventure.Auth.AuthActivity;
import com.example.pypoh.snapventure.Fragment.PlacementTestFragment;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class ProfileFragment extends Fragment {

    private Button logoutBtn;
    private TextView placementTestBtn;

    private PlacementTestFragment placementTestFragment = new PlacementTestFragment();

    public ProfileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Profile");

        placementTestBtn = view.findViewById(R.id.change_text_profile);
        placementTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(placementTestFragment);
            }
        });

        logoutBtn = view.findViewById(R.id.button_logout_profile);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                toAuth();
            }
        });

        return view;
    }

    private void toAuth() {
        Intent toAuthIntent = new Intent(getContext(), AuthActivity.class);
        startActivity(toAuthIntent);
        getActivity().finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((MainActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }
}
