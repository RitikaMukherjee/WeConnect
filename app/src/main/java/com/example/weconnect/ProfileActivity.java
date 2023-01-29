package com.example.weconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weconnect.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        binding= ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth=FirebaseAuth.getInstance();

        String receiverId=getIntent().getStringExtra("userId");
        String userName=getIntent().getStringExtra("userName");
        String profilePic=getIntent().getStringExtra("profilePic");
        String course=getIntent().getStringExtra("course");
        String stream=getIntent().getStringExtra("stream");
        String yoa=getIntent().getStringExtra("yoa");
        String yop=getIntent().getStringExtra("yop");
        String company=getIntent().getStringExtra("company");
        String linkedin=getIntent().getStringExtra("linkedin");
        String about=getIntent().getStringExtra("about");
        binding.userName.setText(userName);
        binding.course.setText(course);
        binding.stream.setText(stream);
        binding.yoa.setText(yoa);
        binding.yop.setText(yop);
        binding.company.setText(company);
        binding.about.setText(about);
        binding.linkedin.setText(linkedin);
        Picasso.get().load(profilePic).placeholder(R.drawable.avatar3).into(binding.profilePic);
        binding.backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileActivity.this,UserlistActivity.class);
                intent.putExtra("userId",receiverId);
                intent.putExtra("profilePic",profilePic);
                intent.putExtra("userName",userName);
                intent.putExtra("course",course);
                intent.putExtra("stream",stream);
                intent.putExtra("yoa",yoa);
                intent.putExtra("yop",yop);
                intent.putExtra("company",company);
                intent.putExtra("linkedin",linkedin);
                intent.putExtra("about",about);
                startActivity(intent);
            }
        });
    }
}