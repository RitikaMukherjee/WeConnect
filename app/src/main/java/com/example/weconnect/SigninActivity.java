package com.example.weconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();//to hide the top bar
    }
}