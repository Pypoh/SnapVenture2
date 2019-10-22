package com.example.pypoh.snapventure.Auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class LoginFragment extends Fragment {

    TextView textDummyHintPassword;
    EditText editPassword;
    TextView textDummyHintEmail;
    EditText editEmail;

    private Button loginBtn;

    // Firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        setupViews(view);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        
        return view;
    }

    private void loginUserEmailPass(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    toMain();
                } else {
                    Toast.makeText(getContext(), "Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void toMain() {
        Intent toMain = new Intent(getContext(), MainActivity.class);
        startActivity(toMain);
        getActivity().finish();
    }


    private void setupViews(View view) {
        loginBtn = view.findViewById(R.id.button_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserEmailPass(editEmail.getText().toString().trim(), editPassword.getText().toString().trim());
            }
        });

        textDummyHintEmail = view.findViewById(R.id.text_dummy_hint_email);
        editEmail = view.findViewById(R.id.edit_email);
        editEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Show white background behind floating label
                            textDummyHintEmail.setVisibility(View.VISIBLE);
                        }
                    }, 100);
                } else {
                    // Required to show/hide white background behind floating label during focus change
                    if (editEmail.getText().length() > 0)
                        textDummyHintEmail.setVisibility(View.VISIBLE);
                    else
                        textDummyHintEmail.setVisibility(View.INVISIBLE);
                }
            }
        });

        textDummyHintPassword = view.findViewById(R.id.text_dummy_hint_password);
        editPassword = view.findViewById(R.id.edit_password);
        editPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Show white background behind floating label
                            textDummyHintPassword.setVisibility(View.VISIBLE);
                        }
                    }, 100);
                } else {
                    // Required to show/hide white background behind floating label during focus change
                    if (editPassword.getText().length() > 0)
                        textDummyHintPassword.setVisibility(View.VISIBLE);
                    else
                        textDummyHintPassword.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((AuthActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }



}
