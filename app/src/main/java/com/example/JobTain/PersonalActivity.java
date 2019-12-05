package com.example.JobTain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

public class PersonalActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    String firstName,lastname,email,college,phone,field,projects,tech,ai,cloud,software,backend,frontend,fullstack;
    TextView n,pn,eml,clg,fld,prj,tk;
    Button contactemailOfPersonalActivity,contactphoneOfPersonalActivity;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        n=findViewById(R.id.n);
        pn=findViewById(R.id.pn);
        eml=findViewById(R.id.eml);
        clg=findViewById(R.id.clg);
        fld=findViewById(R.id.fld);
        prj=findViewById(R.id.prj);
        tk=findViewById(R.id.tk);
        contactemailOfPersonalActivity=findViewById(R.id.contactemailOfPersonalActivity);
        contactphoneOfPersonalActivity=findViewById(R.id.contactphoneOfPersonalActivity);

        Intent intent=getIntent();
        final String username=intent.getStringExtra("username");

        databaseReference= FirebaseDatabase.getInstance().getReference("StudentData").child(username);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                firstName=dataSnapshot.child("firstname").getValue(String.class);
                lastname=dataSnapshot.child("lastname").getValue(String.class);
                college=dataSnapshot.child("college").getValue(String.class);
                email=dataSnapshot.child("email").getValue(String.class);
                phone=dataSnapshot.child("phonenumber").getValue(String.class);
                field=dataSnapshot.child("field").getValue(String.class);
                projects=dataSnapshot.child("projects").getValue(String.class);
                ai=dataSnapshot.child("choice1").getValue(String.class);
                cloud=dataSnapshot.child("choice2").getValue(String.class);
                software=dataSnapshot.child("choice3").getValue(String.class);
                backend=dataSnapshot.child("choice4").getValue(String.class);
                frontend=dataSnapshot.child("choice5").getValue(String.class);
                fullstack=dataSnapshot.child("choice6").getValue(String.class);


                StringBuilder stringBuilder=new StringBuilder();
                if (!TextUtils.isEmpty(ai)){
                    stringBuilder.append(ai+" ");
                }
                if (!TextUtils.isEmpty(cloud)){
                    stringBuilder.append(cloud+" ");
                }
                if (!TextUtils.isEmpty(software)){
                    stringBuilder.append(software+" ");
                }
                if (!TextUtils.isEmpty(backend)){
                    stringBuilder.append(backend+" ");
                }
                if (!TextUtils.isEmpty(frontend)){
                    stringBuilder.append(frontend+" ");
                }
                if (!TextUtils.isEmpty(fullstack)){
                    stringBuilder.append(fullstack+" ");
                }
                tech=stringBuilder.toString().trim();

                String s=firstName+" "+lastname;
                n.setText(s);
                //pn.setText(lastname);
                eml.setText(email);
                pn.setText(phone);
                clg.setText(college);
                fld.setText(field);
                prj.setText(projects);
                tk.setText(tech);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        contactemailOfPersonalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=email;
                Intent mail=new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL,new String[]{to});
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail,"Send mail via:"));
            }
        });


        contactphoneOfPersonalActivity.setOnClickListener(new View.OnClickListener() {
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
