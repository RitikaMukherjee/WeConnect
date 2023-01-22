package com.example.weconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.weconnect.databinding.ActivityUserlistBinding;
import com.google.firebase.auth.FirebaseAuth;

public class UserlistActivity extends AppCompatActivity {
    ActivityUserlistBinding binding;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        binding=ActivityUserlistBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth=FirebaseAuth.getInstance();
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
                Toast.makeText(this, "settings is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shareConcerns:
                Toast.makeText(this, "share concerns is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
//                Toast.makeText(this, "logout is clicked", Toast.LENGTH_SHORT).show();
                mAuth.signOut();
                Intent intent=new Intent(UserlistActivity.this,SigninActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}