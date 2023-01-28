package com.example.weconnect;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weconnect.Models.Users;
import com.example.weconnect.databinding.ActivitySettingsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class SettingsActivity extends AppCompatActivity {
    ActivitySettingsBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    FirebaseStorage storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();
        binding=ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        storage=FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();
        binding.backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingsActivity.this,UserlistActivity.class);
                startActivity(intent);
            }
        });

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String,Object>obj=new HashMap<>();
                String username=binding.txtUserName.getText().toString();
                String course=binding.txtCourse.getText().toString();
                String stream=binding.txtStream.getText().toString();
                String yoa=binding.yoa.getText().toString();
                String yop=binding.yop.getText().toString();
                String company=binding.company.getText().toString();
                String linkedin=binding.linkedin.getText().toString();
                String about=binding.about.getText().toString();
                obj.put("userName",username);
                obj.put("course",course);
                obj.put("stream",stream);
                obj.put("yoa",yoa);
                obj.put("yop",yop);
                obj.put("company",company);
                obj.put("linkedin",linkedin);
                obj.put("about",about);
                database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid())
                        .updateChildren(obj).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(SettingsActivity.this, "Profile updated", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid())
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                Users users=snapshot.getValue(Users.class);
                                Picasso.get()
                                        .load(users.getProfilePic())
                                        .placeholder(R.drawable.avatar3)
                                        .into(binding.profilePic);
                                binding.txtUserName.setText(users.getUserName());
                                binding.txtCourse.setText(users.getCourse());
                                binding.txtStream.setText(users.getStream());
                                binding.yoa.setText(users.getYoa());
                                binding.yop.setText(users.getYop());
                                binding.company.setText(users.getCompany());
                                binding.linkedin.setText(users.getLinkedin());
                                binding.about.setText(users.getAbout());
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });

        binding.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,25);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.getData()!=null){
            Uri sFile=data.getData();
            binding.profilePic.setImageURI(sFile);
            final StorageReference reference=storage.getReference().child("profilePic")
                    .child(FirebaseAuth.getInstance().getUid());
            reference.putFile(sFile).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid())
                                    .child("profilePic").setValue(uri.toString());
                        }
                    });
                }
            });
        }
    }
}