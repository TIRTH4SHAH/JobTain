package com.example.JobTain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class educational_info extends AppCompatActivity {

    EditText college,cgp,field,projects;
    CheckBox ai,cloud,software,frontend,backend,fullstack;
    Button submitOfEducationalInfo;
    Boolean flag;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_info);

        college=findViewById(R.id.college);
        cgp=findViewById(R.id.cpa);
        field=findViewById(R.id.field);
        projects=findViewById(R.id.project);
        ai=findViewById(R.id.ai);
        cloud=findViewById(R.id.cloud);
        software=findViewById(R.id.software);
        frontend=findViewById(R.id.frontend);
        backend=findViewById(R.id.backend);
        fullstack=findViewById(R.id.fullstack);
        submitOfEducationalInfo=findViewById(R.id.submit);


        Intent intent=getIntent();
        final String firstnameReceivedFromPersonalinfo=intent.getStringExtra("firstnameReceivedFromPersonalData");
        final String lastnameReceivedFromPersonalinfo=intent.getStringExtra("lastnameReceivedFromPersonalData");
        final String fullname=firstnameReceivedFromPersonalinfo+" "+lastnameReceivedFromPersonalinfo;
        final String emailReceivedFromPersonalinfo=intent.getStringExtra("emailReceivedFromPersonalData");
        final String phonenumberReceivedFromPersonalinfo=intent.getStringExtra("phonenumberReceivedFromPersonalData");
        final String usernameFromPersonalInfo=intent.getStringExtra("usernameFromPersonalInfo");

        flag=false;

        databaseReference= FirebaseDatabase.getInstance().getReference("StudentData");

        submitOfEducationalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEducationalData(firstnameReceivedFromPersonalinfo,lastnameReceivedFromPersonalinfo,emailReceivedFromPersonalinfo,phonenumberReceivedFromPersonalinfo,usernameFromPersonalInfo);

                if (flag){
                    Intent intent=new Intent(v.getContext(),student_content.class);
                    intent.putExtra("fullnameFromEducationalData",fullname);
                    intent.putExtra("emailFromEducationalData",emailReceivedFromPersonalinfo);
                    intent.putExtra("phonenumberFromEducationalData",phonenumberReceivedFromPersonalinfo);

                    intent.putExtra("collegeFromEducationalData",college.getText().toString());
                    intent.putExtra("cgpFromEducationalData",cgp.getText().toString());
                    intent.putExtra("fieldFromEducationalData",field.getText().toString());
                    intent.putExtra("projectsFromEducationalData",projects.getText().toString());

                    if (ai.isChecked()){
                        intent.putExtra("ai","Artiicial Intelligence");
                    }
                    if (cloud.isChecked()){
                        intent.putExtra("cloud","Cloud Computing");
                    }
                    if (software.isChecked()){
                        intent.putExtra("software","Software Developer");
                    }
                    if (backend.isChecked()){
                        intent.putExtra("backend","Backend Developer");
                    }
                    if (frontend.isChecked()){
                        intent.putExtra("frontend","Frontend Developer");
                    }
                    if (fullstack.isChecked()){
                        intent.putExtra("fullstack","Fullstack Developer");
                    }

                    startActivity(intent);
                }
                else {
                    addEducationalData(firstnameReceivedFromPersonalinfo,lastnameReceivedFromPersonalinfo,emailReceivedFromPersonalinfo,phonenumberReceivedFromPersonalinfo,usernameFromPersonalInfo);
                }


            }
        });
    }


    public void addEducationalData(String firstnameReceivedFromPersonalData,String lastnameReceivedFromPersonalinfo,String emailReceivedFromPersonalinfo,String phonenumberReceivedFromPersonalinfo,String username){
        String tcollege=college.getText().toString().trim();
        String tcgp=cgp.getText().toString().trim();
        String tfield=field.getText().toString().trim();
        String tprojects=projects.getText().toString().trim();
        Boolean f1=false,f2=false,f3=false,f4=false,f5=false,f6=false;
        if (ai.isChecked()){
            f1=true;
        }
        if (cloud.isChecked()){
            f2=true;
        }
        if (software.isChecked()){
            f3=true;
        }
        if (frontend.isChecked()){
            f4=true;
        }
        if (backend.isChecked()){
            f5=true;
        }
        if (fullstack.isChecked()){
            f6=true;
        }

        if (!TextUtils.isEmpty(tcollege)&&!TextUtils.isEmpty(tcgp)&&!TextUtils.isEmpty(tfield)&&!TextUtils.isEmpty(tprojects)){

            Educationaldata educationaldata=new Educationaldata(firstnameReceivedFromPersonalData,lastnameReceivedFromPersonalinfo,emailReceivedFromPersonalinfo,phonenumberReceivedFromPersonalinfo,tcollege,tcgp,tfield,tprojects,f1,f2,f3,f4,f5,f6,username);

            databaseReference.child(username).setValue(educationaldata);

            flag=true;

        }
        else {
            if (TextUtils.isEmpty(tcollege)){
                college.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(tcgp)){
                cgp.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(tfield)){
                field.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(tprojects)){
                projects.setError("Can't be blank");
            }
        }
    }
}
