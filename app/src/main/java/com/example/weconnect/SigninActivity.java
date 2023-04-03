package com.example.weconnect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weconnect.databinding.ActivitySigninBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SigninActivity extends AppCompatActivity {//extending AppCompatActivity for inheriting its methods that shows inheritance
    ActivitySigninBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseDatabase firebaseDatabase;
//    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//inheting the methods ofsuper class
        setContentView(R.layout.activity_signin);
        getSupportActionBar().hide();//to hide the top bar

        binding=ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        progressDialog=new ProgressDialog(SigninActivity.this);
        progressDialog.setTitle("Logging in");
        progressDialog.setMessage("Please wait\nnvalidation in progress");


//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken("57181989795-ukgvjlsh7cdm9gqqljgfju0dho3qshnd.apps.googleusercontent.com")
//                .requestEmail()
//                .build();
//        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);
//
//        binding.googleBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                signIn();
//            }
//        });

        binding.signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validation check
                if(!binding.email.getText().toString().isEmpty()&&!binding.password.getText().toString().isEmpty()){
                    progressDialog.show();
                    mAuth.signInWithEmailAndPassword(binding.email.getText().toString(),binding.password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();
                                    if(task.isSuccessful()){
                                        Intent intent=new Intent(SigninActivity.this,UserlistActivity.class);
                                        startActivity(intent);
                                    }else {
                                        Toast.makeText(SigninActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else {
                    Toast.makeText(SigninActivity.this,"Enter valid credentials",Toast.LENGTH_SHORT).show();
                }
                //validation check
            }
        });
        if(mAuth.getCurrentUser()!=null){
            Intent intent=new Intent(SigninActivity.this,UserlistActivity.class);
            startActivity(intent);
        }
        binding.signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SigninActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
