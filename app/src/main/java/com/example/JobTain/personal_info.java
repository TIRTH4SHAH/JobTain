package com.example.JobTain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class personal_info extends AppCompatActivity {

    Button submitOfPersonalInfo;
    Spinner daySpinner,monthSpinner,yearSpinner;
    EditText first_name,last_name,e_mail,phone_number;

    Boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);


        submitOfPersonalInfo=findViewById(R.id.submitOfPersonalInfo);
        first_name=findViewById(R.id.first_name);
        last_name=findViewById(R.id.last_name);
        e_mail=findViewById(R.id.email);
        phone_number=findViewById(R.id.phone_number);
        flag=false;


        Intent intent=getIntent();
        final String usernameFromPersonalInfo=intent.getStringExtra("usernameFromStudentLogin");

        submitOfPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPersonalData();

                if (flag){
                    Intent intent=new Intent(v.getContext(),student_content.class);
                    intent.putExtra("firstname",first_name.getText().toString());
                    intent.putExtra("lastname",last_name.getText().toString());
                    intent.putExtra("email",e_mail.getText().toString());
                    intent.putExtra("phonenumber",phone_number.getText().toString());
                    intent.putExtra("usernameFromPersonalInfo",usernameFromPersonalInfo);
                    startActivity(intent);
                }
                else {
                    addPersonalData();
                }
            }
        });

        daySpinner = (Spinner) findViewById(R.id.daySpinner);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.days,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        daySpinner.setAdapter(arrayAdapter);

        monthSpinner = (Spinner) findViewById(R.id.monthSpinner);
        ArrayAdapter<CharSequence> arrayAdapter2=ArrayAdapter.createFromResource(this,R.array.months,android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(arrayAdapter2);

        yearSpinner = (Spinner) findViewById(R.id.foundedyear);
        ArrayAdapter<CharSequence> arrayAdapter3=ArrayAdapter.createFromResource(this,R.array.years,android.R.layout.simple_spinner_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(arrayAdapter3);
    }

    public void addPersonalData(){
        String firstname=first_name.getText().toString().trim();
        String lastname=last_name.getText().toString().trim();
        String email=e_mail.getText().toString().trim();
        String phonenumber=phone_number.getText().toString().trim();


        if (!TextUtils.isEmpty(firstname)&&!TextUtils.isEmpty(lastname)&&!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(phonenumber)){
            flag=true;
        }
        else {
            if (TextUtils.isEmpty(firstname)){
                first_name.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(lastname)){
                last_name.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(email)){
                e_mail.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(phonenumber)){
                phone_number.setError("Can't be blank");
            }
        }
    }
}
