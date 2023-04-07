package com.example.upmood;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class LoginActivity extends AppCompatActivity {
    TabLayout loginTablayout;
    ViewPager2 loginViewPager2;
    LinearLayout loginLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginTablayout = findViewById(R.id.loginTablayout);
        loginViewPager2 = findViewById(R.id.loginViewPager2);
        loginLayout = findViewById(R.id.loginLayout);

        LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),getLifecycle());
        loginViewPager2.setAdapter(adapter);

        //Chinh viewpager2
        new TabLayoutMediator(loginTablayout, loginViewPager2, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Sign In");
                    break;
                case 1:
                    tab.setText("Sign Up");
                    break;
            }
        }).attach();

        //an actionbar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        //Thiet lap an? ban` phim' ao?

        loginLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // Ẩn bàn phím ảo
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                return false;
            }
        });
    }
}
