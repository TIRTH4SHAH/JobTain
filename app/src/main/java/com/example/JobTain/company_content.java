package com.example.JobTain;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class company_content extends AppCompatActivity {
    Button submitOfCompanyContent;
    Spinner yearSpinner;
    EditText company_name,head,email,founder,ceo,nation,contact;
    RadioButton govern,self;
    CheckBox ai,cloud,software,backend,frontend,fullstack;
    Boolean flag=false;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_content);

        Intent intent=getIntent();
        final String user=intent.getStringExtra("user");

        company_name = findViewById(R.id.companyname);
        head = findViewById(R.id.head);
        nation = findViewById(R.id.nation);
        founder = findViewById(R.id.founder);
        ceo = findViewById(R.id.ceo);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        govern=findViewById(R.id.govern);
        self=findViewById(R.id.self);
        yearSpinner = (Spinner) findViewById(R.id.foundedyear);
        ai=findViewById(R.id.ai);
        cloud=findViewById(R.id.cloud);
        software=findViewById(R.id.software);
        backend=findViewById(R.id.backend);
        frontend=findViewById(R.id.frontend);
        fullstack=findViewById(R.id.fullstack);
        submitOfCompanyContent = findViewById(R.id.submitOfCompanyContent);

        ArrayAdapter<CharSequence> arrayAdapter3 = ArrayAdapter.createFromResource(this, R.array.years, android.R.layout.simple_spinner_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(arrayAdapter3);

        databaseReference= FirebaseDatabase.getInstance().getReference("CompanyData");

        submitOfCompanyContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addCompanyData(user);

                if (flag){
                    Intent intent=new Intent(getApplicationContext(),Company_display_items.class);
                    startActivity(intent);
                }
                else {
                    addCompanyData(user);
                }

            }
        });
    }

    public void addCompanyData(String username){
        String tcompany_name=company_name.getText().toString();
        String thead=head.getText().toString();
        String temail=email.getText().toString();
        String tfound=founder.getText().toString();
        String tceo=ceo.getText().toString();
        String tnation=nation.getText().toString();
        String tcontact=contact.getText().toString();
        String tfoundedyear=yearSpinner.getSelectedItem().toString();
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

        if (!TextUtils.isEmpty(tcompany_name)&&!TextUtils.isEmpty(thead)&&!TextUtils.isEmpty(temail)&&!TextUtils.isEmpty(tfound)&&!TextUtils.isEmpty(tceo)&&!TextUtils.isEmpty(tnation)&&!TextUtils.isEmpty(tcontact)){

            CompanyData companyData=new CompanyData(tcompany_name,thead,temail,tfound,tceo,tnation,tcontact,tfoundedyear,f1,f2,f3,f4,f5,f6,username);
            databaseReference.child(username).setValue(companyData);
            flag=true;
            Toast.makeText(this,"Data added",Toast.LENGTH_LONG).show();
        }
        else {
            if (TextUtils.isEmpty(tcompany_name)){
                company_name.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(thead)){
                head.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(temail)){
                email.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(tfound)){
                founder.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(tceo)){
                ceo.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(tnation)){
                nation.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(tcontact)){
                contact.setError("Can't be blank");
            }
        }
    }
}
