package com.example.weconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.database.sqlite.SQLiteDatabaseKt;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    private Button submit;
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText collegeEditText;
    private EditText courseEditText;
    private EditText streamEditText;
    private EditText yoaEditText;
    private EditText yopEditText;
    private EditText companyEditText;
    private TextView gotosignin;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();//hides the top bar
        submit=(Button) findViewById(R.id.submit);
        usernameEditText=(EditText) findViewById(R.id.username);
        emailEditText=(EditText) findViewById(R.id.email);
        passwordEditText=(EditText) findViewById(R.id.password);
        collegeEditText=(EditText) findViewById(R.id.college);
        courseEditText=(EditText) findViewById(R.id.course);
        streamEditText=(EditText) findViewById(R.id.stream);
        yoaEditText=(EditText) findViewById(R.id.yoa);
        yopEditText=(EditText) findViewById(R.id.yop);
        companyEditText=(EditText) findViewById(R.id.company);
        gotosignin=(TextView) findViewById(R.id.gotosignin);
        databaseHelper=new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase=databaseHelper.getWritableDatabase();
        gotosignin.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.submit){
            String username=usernameEditText.getText().toString();
            String email=emailEditText.getText().toString();
            String password=passwordEditText.getText().toString();
            String college=collegeEditText.getText().toString();
            String course=courseEditText.getText().toString();
            String stream=streamEditText.getText().toString();
            int yoa=Integer.parseInt(yoaEditText.getText().toString());
            int yop=Integer.parseInt(yopEditText.getText().toString());
            String company=companyEditText.getText().toString();
        }else if(view.getId()==R.id.gotosignin){
            Intent intent =new Intent(SignupActivity.this,SigninActivity.class);
            startActivity(intent);
        }
    }
}