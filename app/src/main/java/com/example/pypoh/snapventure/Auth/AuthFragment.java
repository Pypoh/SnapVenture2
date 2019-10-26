package com.example.pypoh.snapventure.Auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.pypoh.snapventure.EducationLevel;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;

import java.util.Objects;


public class AuthFragment extends Fragment {

    private Button _btnLogin, _btnRegist, _btnGuest;

    public AuthFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_auth, container, false);

        _btnLogin = view.findViewById(R.id.auth_login_button);
        _btnRegist = view.findViewById(R.id.auth_regist_button);
        _btnGuest = view.findViewById(R.id.auth_guest_button);

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new LoginFragment());
            }
        });

        _btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new RegisterFragment());
            }
        });

        _btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _btnGuest.setEnabled(false);
//                Intent playAsGuest = new Intent(getContext(), EducationLevel.class);
//                playAsGuest.putExtra("AuthCode", "3");
//                startActivity(playAsGuest);
                Toast.makeText(getContext(), "Under Development", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((AuthActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }


}
