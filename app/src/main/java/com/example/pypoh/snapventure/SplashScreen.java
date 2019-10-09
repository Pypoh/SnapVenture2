package com.example.pypoh.snapventure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pypoh.snapventure.Auth.Auth;
import com.example.pypoh.snapventure.Auth.Login;
import com.example.pypoh.snapventure.MainMenu.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Intent intent;

    // Dialog
    private Dialog warningDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mAuth = FirebaseAuth.getInstance();

        createWarningDialog();

        warningDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
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
        });
    }

    private void createWarningDialog() {
        warningDialog = new Dialog(this);
        warningDialog.setContentView(R.layout.dialog_warning);
        warningDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        warningDialog.show();

        Button okBtn = warningDialog.findViewById(R.id.button_warning_ok);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                warningDialog.dismiss();
            }
        });
    }
}
