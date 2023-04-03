package com.example.weconnect;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();
        try {
            Thread.sleep(3000); // Pause for 5 seconds (5000 milliseconds)
            Intent intent=new Intent(MainActivity2.this,SigninActivity.class);
            startActivity(intent);
        } catch (InterruptedException e) {
            // Handle the exception
        }

    }
}