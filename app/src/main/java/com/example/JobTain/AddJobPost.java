package com.example.JobTain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddJobPost extends AppCompatActivity {

    int jobcount;
    String user,company_name;
    Button post;

    Boolean flag;

    DatabaseReference databaseReference;

    EditText job_title,job_exp,job_sal,job_loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job_post);



        Intent i=getIntent();
        user=i.getStringExtra("user");
        company_name=i.getStringExtra("company_name");



        job_title=findViewById(R.id.jobtitle);
        job_exp=findViewById(R.id.exp);
        job_sal=findViewById(R.id.salary);
        job_loc=findViewById(R.id.location);
        post=findViewById(R.id.postjob);

        databaseReference= FirebaseDatabase.getInstance().getReference("JobPost");

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("jobdata",0);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                jobcount=sharedPreferences.getInt("jobc",-1);

                addJob(jobcount);

                if (flag){

                    Intent intent=new Intent(getApplicationContext(),Company_display_items.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
                else {
                    addJob(jobcount);
                }
                jobcount=jobcount+1;
                editor.putInt("jobc",jobcount);
                editor.apply();

            }
        });

    }

    public void addJob(int jobcount){
        String title=job_title.getText().toString().trim();
        String exp=job_exp.getText().toString().trim();
        String loc=job_loc.getText().toString().trim();
        String sal=job_sal.getText().toString().trim();

        if (!TextUtils.isEmpty(title)&&!TextUtils.isEmpty(exp)&&!TextUtils.isEmpty(loc)&&!TextUtils.isEmpty(sal)){

            Job job=new Job(title,loc,exp,sal,company_name,user);
            databaseReference.child(user).setValue(job);

            flag=true;

        }
        else {
            if (TextUtils.isEmpty(title)){
                job_title.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(exp)){
                job_exp.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(loc)){
                job_sal.setError("Can't be blank");
            }
            if (TextUtils.isEmpty(sal)){
                job_loc.setError("Can't be blank");
            }
        }
    }
}
