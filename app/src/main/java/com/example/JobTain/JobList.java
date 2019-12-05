package com.example.JobTain;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static com.example.JobTain.R.layout.activity_job_list;

public class JobList extends ArrayAdapter<JobPost> {

    private Activity context;
    List<JobPost> jobPost;

    public JobList(Activity context,List<JobPost> jobPost){
        super(context, activity_job_list,jobPost);
        this.context=context;
        this.jobPost=jobPost;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(activity_job_list, null, true);

        TextView jobtitle=listViewItem.findViewById(R.id.title);
        TextView jobExperience=listViewItem.findViewById(R.id.textViewExp);

        JobPost jobPost1 = jobPost.get(position);

        //String s=educationaldata1.getFirstname()+" "+educationaldata1.getLastname();

        jobtitle.setText(jobPost1.getJobTitle());
        String s="Experience: "+jobPost1.getExperience();
        jobExperience.setText(s);

        return listViewItem;
    }

}
