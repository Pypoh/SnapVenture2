package com.example.pypoh.snapventure.Auth;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.Model.UserModel;
import com.example.pypoh.snapventure.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;
import java.util.concurrent.Executor;


public class RegisterFragment extends Fragment {

    TextView textDummyHintName;
    EditText editName;
    TextView textDummyHintEmail;
    EditText editEmail;
    TextView textDummyHintPassword;
    EditText editPassword;
    TextView textDummyHintRePass;
    EditText editRePass;

    private Button signUpBtn;

    // Firebase
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private FirebaseFirestore db;


    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        setupViews(view);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();


        return view;
    }

    private void signUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Objects.requireNonNull(getActivity()), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            user = mAuth.getCurrentUser();
                            insertUserData(editName.getText().toString(), editEmail.getText().toString());
                        } else {
                            signUpBtn.setEnabled(true);
                            Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void insertUserData(String name, String email) {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DocumentReference userRef = db.collection("users").document(userId);

        UserModel userModel = new UserModel(userId, name, email, 0);

        userRef.set(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getContext(), "Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Fail Insert", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupViews(View view) {
        signUpBtn = view.findViewById(R.id.button_sign_up_register);
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpBtn.setEnabled(false);
                signUp(editEmail.getText().toString(), editPassword.getText().toString());
            }
        });


        textDummyHintName = view.findViewById(R.id.text_dummy_hint_name);
        editName = view.findViewById(R.id.edit_name);
        editName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Show white background behind floating label
                            textDummyHintName.setVisibility(View.VISIBLE);
                        }
                    }, 100);
                } else {
                    // Required to show/hide white background behind floating label during focus change
                    if (editName.getText().length() > 0)
                        textDummyHintName.setVisibility(View.VISIBLE);
                    else
                        textDummyHintName.setVisibility(View.INVISIBLE);
                }
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

        textDummyHintRePass = view.findViewById(R.id.text_dummy_hint_repassword);
        editRePass = view.findViewById(R.id.edit_repassword);
        editRePass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // Show white background behind floating label
                            textDummyHintRePass.setVisibility(View.VISIBLE);
                        }
                    }, 100);
                } else {
                    // Required to show/hide white background behind floating label during focus change
                    if (editRePass.getText().length() > 0)
                        textDummyHintRePass.setVisibility(View.VISIBLE);
                    else
                        textDummyHintRePass.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void changeFragment(Fragment fragment) {
        ((AuthActivity) Objects.requireNonNull(getActivity())).setSecondFragment(fragment);
    }



}
