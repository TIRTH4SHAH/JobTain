package com.example.JobTain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

public class student_content extends AppCompatActivity {

    Button personal_info, educational_info, create_resume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_content);

        personal_info = findViewById(R.id.personal_info);
        educational_info = findViewById(R.id.educational_info);
        create_resume = findViewById(R.id.create_resume);

        Intent intent = getIntent();
        final String firstnameReceivedFromPersonalData = intent.getStringExtra("firstname");
        final String lastnameReceivedFromPersonalData = intent.getStringExtra("lastname");
        final String emailReceivedFromPersonalData = intent.getStringExtra("email");
        final String phonenumberReceivedFromPersonalData = intent.getStringExtra("phonenumber");

        final String usernameFromStudentLogin=intent.getStringExtra("username");


        final String usernameFromPersonalInfo=intent.getStringExtra("usernameFromPersonalInfo");
        final String fullnameFromEducationalData = intent.getStringExtra("fullnameFromEducationalData");
        final String emailFromEducationalData = intent.getStringExtra("emailFromEducationalData");
        final String phonenumberFromEducationalData = intent.getStringExtra("phonenumberFromEducationalData");

        final String collegeReceivedFromEducationalData = intent.getStringExtra("collegeFromEducationalData");
        final String cgpReceivedFromEducationalData = intent.getStringExtra("cgpFromEducationalData");
        final String fieldReceivedFromEducationalData = intent.getStringExtra("fieldFromEducationalData");
        final String projectsReceivedFromEducationalData = intent.getStringExtra("projectsFromEducationalData");
        final String aiReceivedFromEducationalData = intent.getStringExtra("ai");
        final String cloudReceivedFromEducationalData = intent.getStringExtra("cloud");
        final String softwareReceivedFromEducationalData = intent.getStringExtra("software");
        final String backendReceivedFromEducationalData = intent.getStringExtra("backend");
        final String frontendReceivedFromEducationalData = intent.getStringExtra("frontend");
        final String fullstackReceivedFromEducationalData = intent.getStringExtra("fullstack");

        personal_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(v.getContext(), personal_info.class);
                intent3.putExtra("usernameFromStudentLogin",usernameFromStudentLogin);
                startActivity(intent3);
            }
        });

        educational_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), educational_info.class);
                intent.putExtra("firstnameReceivedFromPersonalData", firstnameReceivedFromPersonalData);
                intent.putExtra("lastnameReceivedFromPersonalData", lastnameReceivedFromPersonalData);
                intent.putExtra("emailReceivedFromPersonalData", emailReceivedFromPersonalData);
                intent.putExtra("phonenumberReceivedFromPersonalData", phonenumberReceivedFromPersonalData);
                intent.putExtra("usernameFromPersonalInfo",usernameFromPersonalInfo);
                startActivity(intent);
            }
        });

        create_resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), Resume_preview.class);
                intent2.putExtra("fullnameFromEducationalData", fullnameFromEducationalData);
                intent2.putExtra("emailFromEducationalData", emailFromEducationalData);
                intent2.putExtra("phonenumberFromEducationalData", phonenumberFromEducationalData);
                intent2.putExtra("collegeReceivedFromEducationalData", collegeReceivedFromEducationalData);
                intent2.putExtra("cgpReceivedFromEducationalData", cgpReceivedFromEducationalData);
                intent2.putExtra("fieldReceivedFromEducationalData", fieldReceivedFromEducationalData);
                intent2.putExtra("projectsReceivedFromEducationalData", projectsReceivedFromEducationalData);
                intent2.putExtra("aiReceivedFromEducationalData", aiReceivedFromEducationalData);
                intent2.putExtra("cloudReceivedFromEducationalData", cloudReceivedFromEducationalData);
                intent2.putExtra("softwareReceivedFromEducationalData", softwareReceivedFromEducationalData);
                intent2.putExtra("backendReceivedFromEducationalData", backendReceivedFromEducationalData);
                intent2.putExtra("frontendReceivedFromEducationalData", frontendReceivedFromEducationalData);
                intent2.putExtra("fullstackReceivedFromEducationalData", fullstackReceivedFromEducationalData);
                startActivity(intent2);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();


        //Intent intent2=new Intent();
        //String user=intent2.getStringExtra("username");
        educational_info=findViewById(R.id.educational_info);
        create_resume=findViewById(R.id.create_resume);

        educational_info.setEnabled(false);
        create_resume.setEnabled(false);

        Intent intent = getIntent();
        final String firstnameReceivedFromPersonalData = intent.getStringExtra("firstname");
        final String collegeReceivedFromEducationalData = intent.getStringExtra("collegeFromEducationalData");


        if (!TextUtils.isEmpty(firstnameReceivedFromPersonalData)){
            educational_info.setEnabled(true);
        }

        if (!TextUtils.isEmpty(collegeReceivedFromEducationalData)){
            educational_info.setEnabled(true);
            create_resume.setEnabled(true);
        }

    }

}
