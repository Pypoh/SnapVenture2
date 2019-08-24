package com.example.pypoh.snapventure.Auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.example.pypoh.snapventure.R;

public class Auth extends AppCompatActivity {

    private Button _btnLogin, _btnRegist, _btnGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        _btnLogin = findViewById(R.id.auth_login_button);
        _btnRegist = findViewById(R.id.auth_regist_button);
        _btnGuest = findViewById(R.id.auth_guest_button);

        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Auth.this, "Under Development", Toast.LENGTH_SHORT).show();
            }
        });

        _btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Auth.this, "Under Development", Toast.LENGTH_SHORT).show();
            }
        });

        _btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playAsGuest = new Intent(Auth.this, MainActivity.class);
                playAsGuest.putExtra("AuthCode", "3");
                startActivity(playAsGuest);
            }
        });
    }
}
