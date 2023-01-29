package com.example.weconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weconnect.databinding.ActivityConsernBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ConsernActivity extends AppCompatActivity {
    ActivityConsernBinding binding;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    FirebaseAuth auth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consern);
        binding=ActivityConsernBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        String id=auth.getUid();
        String recipient=database.getReference().child("Users").child(id).child("email").get().toString();
        String subject="Share Concern";
        String message=binding.cntxt.getText().toString()+" from id: "+id;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "rima.snt99@gmail.com" });
        intent.putExtra(Intent.EXTRA_SUBJECT, "My Concern");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(Intent.createChooser(intent, "choose email client"));
    }
}