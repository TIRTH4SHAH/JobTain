package com.example.JobTain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Student_main_screen extends AppCompatActivity {

    ListView listviewpersonal;

    List<JobPost> jobPost;

    DatabaseReference databaseReference;


    Button sign_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main_screen);

        listviewpersonal=findViewById(R.id.listviewpersonal);

        databaseReference= FirebaseDatabase.getInstance().getReference("JobPost");

        sign_out=findViewById(R.id.sign_out);

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signOut();

        jobPost=new ArrayList<>();


        listviewpersonal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JobPost jobPost1=jobPost.get(position);

                Intent intent=new Intent(getApplicationContext(),JobActivity.class);

                intent.putExtra("username",jobPost1.getUsername());

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                jobPost.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    JobPost jobPost1 = postSnapshot.getValue(JobPost.class);
                    //adding artist to the list
                    jobPost.add(jobPost1);
                }

                JobList jobList=new JobList(Student_main_screen.this,jobPost);
                listviewpersonal.setAdapter(jobList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
