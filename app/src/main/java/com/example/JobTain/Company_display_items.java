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

public class Company_display_items extends AppCompatActivity {

    ListView listviewpersonal;
    Button sign_out,addjobpost;

    String user,company_name;

    List<Educationaldata> educationaldata;

    DatabaseReference databaseReference,databaseReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_display_items);

        Intent i=getIntent();
        user=i.getStringExtra("user");

        databaseReference= FirebaseDatabase.getInstance().getReference("StudentData");
        databaseReference1=FirebaseDatabase.getInstance().getReference("CompanyData");

        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                company_name=dataSnapshot.child(user).child("company_name").getValue(String.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listviewpersonal=findViewById(R.id.listviewpersonal);
        addjobpost=findViewById(R.id.add_job_post);
        sign_out=findViewById(R.id.sign_out);

        educationaldata=new ArrayList<>();

        listviewpersonal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Educationaldata educationaldata1=educationaldata.get(position);

                Intent intent=new Intent(getApplicationContext(),PersonalActivity.class);

                intent.putExtra("username",educationaldata1.getUsername());

                startActivity(intent);
            }
        });

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        addjobpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),AddJobPost.class);
                intent.putExtra("user",user);
                intent.putExtra("company_name",company_name);
                startActivity(intent);
            }
        });

        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signOut();


    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                educationaldata.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Educationaldata educationaldata1 = postSnapshot.getValue(Educationaldata.class);
                    //adding artist to the list
                    educationaldata.add(educationaldata1);
                }

                PersonalList personalList=new PersonalList(Company_display_items.this,educationaldata);
                listviewpersonal.setAdapter(personalList);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
