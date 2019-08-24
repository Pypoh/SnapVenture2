package com.example.pypoh.snapventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.pypoh.snapventure.Auth.Auth;
import com.example.pypoh.snapventure.Auth.Login;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                if (mAuth.getCurrentUser() != null){
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                }else {
                    intent = new Intent(getApplicationContext(), Auth.class);
                }
                startActivity(intent);
                finish();
            }
        }).start();
    }
}
