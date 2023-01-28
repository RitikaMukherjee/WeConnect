package com.example.weconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weconnect.Adapter.FragmentsAdapter;
import com.example.weconnect.Models.Users;
import com.example.weconnect.databinding.ActivityUserlistBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UserlistActivity extends AppCompatActivity {
    ActivityUserlistBinding binding;
    FirebaseDatabase database;
    FirebaseAuth mAuth;
    ArrayList<Users> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        binding=ActivityUserlistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth=FirebaseAuth.getInstance();
        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
//                Toast.makeText(this, "settings is clicked", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(UserlistActivity.this,SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.shareConcerns:
                Toast.makeText(this, "share concerns is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
//                Toast.makeText(this, "logout is clicked", Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                Intent intent1=new Intent(UserlistActivity.this,SigninActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}