package com.example.JobTain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Resume_preview extends AppCompatActivity {

    TextView textname, email, phonenumber, college, cgpa, field, projects, technology;
    Button next;


    DatabaseReference databaseReference;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_preview);


        Intent intent2 = getIntent();
        final String username = intent2.getStringExtra("username");

        databaseReference = FirebaseDatabase.getInstance().getReference("StudentData");

        textname = findViewById(R.id.name);
        next = findViewById(R.id.next);
        email = findViewById(R.id.email);
        phonenumber = findViewById(R.id.phone_number);
        college = findViewById(R.id.college);
        cgpa = findViewById(R.id.cgpa);
        field = findViewById(R.id.field);
        projects = findViewById(R.id.projects);
        technology = findViewById(R.id.technology);

        if (!TextUtils.isEmpty(username)) {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final String rfirstname = dataSnapshot.child(username).child("firstname").getValue(String.class);
                    final String rlastname = dataSnapshot.child(username).child("lastname").getValue(String.class);
                    final String rfullname = rfirstname + " " + rlastname;
                    final String remail = dataSnapshot.child(username).child("email").getValue(String.class);
                    final String rphonenumber = dataSnapshot.child(username).child("phonenumber").getValue(String.class);
                    final String rcollege = dataSnapshot.child(username).child("college").getValue(String.class);
                    final String rcgp = dataSnapshot.child(username).child("cgp").getValue(String.class);
                    final String rfield = dataSnapshot.child(username).child("field").getValue(String.class);
                    final String rprojects = dataSnapshot.child(username).child("projects").getValue(String.class);
                    final String rai = dataSnapshot.child(username).child("choice1").getValue(String.class);
                    final String rcloud = dataSnapshot.child(username).child("choice2").getValue(String.class);
                    final String rsoftware = dataSnapshot.child(username).child("choice3").getValue(String.class);
                    final String rbackend = dataSnapshot.child(username).child("choice4").getValue(String.class);
                    final String rfrontend = dataSnapshot.child(username).child("choice5").getValue(String.class);
                    final String rfullstack = dataSnapshot.child(username).child("choice6").getValue(String.class);

                    StringBuilder stringBuilder = new StringBuilder();
                    if (!TextUtils.isEmpty(rai)) {
                        stringBuilder.append(rai + " ");
                    }
                    if (!TextUtils.isEmpty(rcloud)) {
                        stringBuilder.append(rcloud + " ");
                    }
                    if (!TextUtils.isEmpty(rsoftware)) {
                        stringBuilder.append(rsoftware + " ");
                    }
                    if (!TextUtils.isEmpty(rbackend)) {
                        stringBuilder.append(rbackend + " ");
                    }
                    if (!TextUtils.isEmpty(rfrontend)) {
                        stringBuilder.append(rfrontend + " ");
                    }
                    if (!TextUtils.isEmpty(rfullstack)) {
                        stringBuilder.append(rfullstack + " ");
                    }

                    final String rtechnology = stringBuilder.toString().trim();

                    textname.setText(rfullname);
                    email.setText(remail);
                    phonenumber.setText(rphonenumber);
                    college.setText(rcollege);
                    cgpa.setText(rcgp);
                    field.setText(rfield);
                    projects.setText(rprojects);
                    technology.setText(rtechnology);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        else {

            final Intent intent = getIntent();
            final String rfullname = intent.getStringExtra("fullnameFromEducationalData");
            final String remail = intent.getStringExtra("emailFromEducationalData");
            final String rphonenumber = intent.getStringExtra("phonenumberFromEducationalData");
            final String rcollege = intent.getStringExtra("collegeReceivedFromEducationalData");
            final String rcgp = intent.getStringExtra("cgpReceivedFromEducationalData");
            final String rfield = intent.getStringExtra("fieldReceivedFromEducationalData");
            final String rprojects = intent.getStringExtra("projectsReceivedFromEducationalData");
            final String rai = intent.getStringExtra("aiReceivedFromEducationalData");
            final String rcloud = intent.getStringExtra("cloudReceivedFromEducationalData");
            final String rsoftware = intent.getStringExtra("softwareReceivedFromEducationalData");
            final String rbackend = intent.getStringExtra("backendReceivedFromEducationalData");
            final String rfrontend = intent.getStringExtra("frontendReceivedFromEducationalData");
            final String rfullstack = intent.getStringExtra("fullstackReceivedFromEducationalData");


            StringBuilder stringBuilder = new StringBuilder();
            if (rai != "") {
                stringBuilder.append(rai + " ");
            }
            if (rcloud != "") {
                stringBuilder.append(rcloud + " ");
            }
            if (rsoftware != "") {
                stringBuilder.append(rsoftware + " ");
            }
            if (rbackend != "") {
                stringBuilder.append(rbackend + " ");
            }
            if (rfrontend != "") {
                stringBuilder.append(rfrontend + " ");
            }
            if (rfullstack != "") {
                stringBuilder.append(rfullstack + " ");
            }

            final String rtechnology = stringBuilder.toString();

            textname.setText(rfullname);
            email.setText(remail);
            phonenumber.setText(rphonenumber);
            college.setText(rcollege);
            cgpa.setText(rcgp);
            field.setText(rfield);
            projects.setText(rprojects);
            technology.setText(rtechnology);

        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Student_main_screen.class);
                startActivity(intent1);
            }
        });
    }
}
