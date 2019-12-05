package com.example.JobTain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JobActivity extends AppCompatActivity {

    DatabaseReference databaseReference,databaseReference1;
    String jobtitle,joblocation,jobexp,jobsal,email,phone;
    TextView title,loc,exp,sal,companyname;
    Button contactemailOfJobActivity,contactphoneOfJobActivity;
    int jobcount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);

        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("jobdata",0);
        jobcount=sharedPreferences.getInt("jobc",-1)-1;


        title=findViewById(R.id.jobtitle);
        loc=findViewById(R.id.joblocation);
        exp=findViewById(R.id.jobexp);
        sal=findViewById(R.id.jobsalary);
        companyname=findViewById(R.id.companyname);

        contactemailOfJobActivity=findViewById(R.id.contactemailOfJobActivity);
        contactphoneOfJobActivity=findViewById(R.id.contactphoneOfJobActivity);

        Intent intent=getIntent();
        final String username=intent.getStringExtra("username");

        String s="job"+jobcount;

        databaseReference= FirebaseDatabase.getInstance().getReference("JobPost").child(username);
        //databaseReference1=FirebaseDatabase.getInstance().getReference("CompanyData").child(username);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                jobtitle=dataSnapshot.child("jobTitle").getValue(String.class);
                joblocation=dataSnapshot.child("location").getValue(String.class);
                jobsal=dataSnapshot.child("jobsalary").getValue(String.class);
                jobexp=dataSnapshot.child("experience").getValue(String.class);
                //email=dataSnapshot.child("email").getValue(String.class);
                //phone=dataSnapshot.child("contact").getValue(String.class);

                companyname.setText(username);
                title.setText(jobtitle);
                loc.setText(joblocation);
                exp.setText(jobexp);
                sal.setText(jobsal);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        contactemailOfJobActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=email;
                Intent mail=new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail,"Send mail via:"));
            }
        });


        contactphoneOfJobActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("tel:"+phone);
                Intent callIntent=new Intent(Intent.ACTION_DIAL,uri);

                //callIntent.setData(Uri.parse("tel"+phone));
                startActivity(callIntent);
            }
        });

    }
}
