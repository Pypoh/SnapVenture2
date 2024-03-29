package com.example.pypoh.snapventure.MainMenu;

import android.os.Bundle;

import com.example.pypoh.snapventure.BattlePages.MatchingFragment;
import com.example.pypoh.snapventure.Fragment.MainFragment.ProfileFragment;
import com.example.pypoh.snapventure.Fragment.MainFragment.PronounceFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pypoh.snapventure.R;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    // Fragment
//    private AdventureFragment adventureFragment = new AdventureFragment();
    private PronounceFragment pronounceFragment = new PronounceFragment();
//    private VocabFragment vocabFragment = new VocabFragment();

    private LessonFragment lessonFragment = new LessonFragment();
    private BattleFragment battleFragment = new BattleFragment();
    private PlayFragment playFragment = new PlayFragment();
    private ProfileFragment profileFragment = new ProfileFragment();

    // Utils
    boolean doubleBackToExitPressedOnce = false;

    private Menu bottomMenu;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_adventure:
                    setFragment(lessonFragment);
                    changeIconStateBar(R.id.navigation_adventure, R.drawable.navbar_lesson_on);
                    return true;
                case R.id.navigation_pronounciation:
                    setFragment(playFragment);
                    changeIconStateBar(R.id.navigation_pronounciation, R.drawable.navbar_play_on);
                    return true;
                case R.id.navigation_multiplayer:
                    setFragment(battleFragment);
                    changeIconStateBar(R.id.navigation_multiplayer, R.drawable.navbar_battle_on);
                    return true;
                case R.id.navigation_profile:
                    setFragment(profileFragment);
                    changeIconStateBar(R.id.navigation_profile, R.drawable.navbar_profile_on);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        bottomMenu = navView.getMenu();

        setFragment(lessonFragment);
    }

    public static void setFragmentToPlay() {

    }

    private void changeIconStateBar(int pathItem, int pathIcon) {
        bottomMenu.findItem(R.id.navigation_adventure).setIcon(R.drawable.navbar_lesson_off);
        bottomMenu.findItem(R.id.navigation_pronounciation).setIcon(R.drawable.navbar_play_off);
        bottomMenu.findItem(R.id.navigation_multiplayer).setIcon(R.drawable.navbar_battle_off);
        bottomMenu.findItem(R.id.navigation_profile).setIcon(R.drawable.navbar_profile_off);

        bottomMenu.findItem(pathItem).setIcon(pathIcon);
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, fragment, "MAIN_FRAGMENT");
        ft.addToBackStack(null);
        ft.commit();
    }

    public void setSecondFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_frame, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void setSecondFragment(Fragment fragment, String args) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Bundle bundleArgs = new Bundle();
        bundleArgs.putString("KEY_ARG", args);
        fragment.setArguments(bundleArgs);
        ft.replace(R.id.main_frame, fragment);
//        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.main_frame);
        if (fragment instanceof MatchingFragment) {
            return;
        }
        if (doubleBackToExitPressedOnce || !checkCurrentFragment()) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private boolean checkCurrentFragment() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("MAIN_FRAGMENT");
        return currentFragment != null && currentFragment.isVisible();
    }

}
