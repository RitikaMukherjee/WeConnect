package com.example.weconnect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weconnect.Models.Users;
import com.example.weconnect.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;//for database integration
import com.google.firebase.auth.FirebaseAuth;//for database integration
import com.google.firebase.database.FirebaseDatabase;//for database integration

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;//for database integration
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth=FirebaseAuth.getInstance();//new database instance is created
        database=FirebaseDatabase.getInstance();//new database instance is created

        progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We're creating your account");
        binding.signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //error handling is done by considering several test cases when user gives wrong sign up data
                if(!binding.username.toString().isEmpty()&&!binding.password.toString().isEmpty()&&!binding.email.toString().isEmpty()&&!binding.college.toString().isEmpty()&&!binding.course.toString().isEmpty()&&!binding.stream.toString().isEmpty()&&!binding.yoa.toString().isEmpty()&&!binding.yop.toString().isEmpty()&&!binding.company.toString().isEmpty()&&!binding.linkedin.toString().isEmpty()){
                    progressDialog.show();
                    mAuth.createUserWithEmailAndPassword(binding.email.getText().toString(),binding.password.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if(task.isSuccessful()){
                                Users user=new Users(binding.username.getText().toString(),binding.email.getText().toString(),binding.password.getText().toString(),binding.college.getText().toString(),binding.course.getText().toString(),binding.stream.getText().toString(),binding.yoa.getText().toString(),binding.yop.getText().toString(),binding.company.getText().toString(),binding.linkedin.getText().toString());
                                String id= task.getResult().getUser().getUid();
                                database.getReference().child("Users").child(id).setValue(user);//new record is created into database
                                Toast.makeText(MainActivity.this, "User is signed up successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(MainActivity.this,UserlistActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else {
                    Toast.makeText(MainActivity.this, "Enter valid credentials", Toast.LENGTH_SHORT).show();
                }
                //error handling is done by considering several test cases when user gives wrong sign up data
            }
        });
        binding.signinTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SigninActivity.class);
                startActivity(intent);
            }
        });
    }
}
