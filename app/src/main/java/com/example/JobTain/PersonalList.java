package com.example.JobTain;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;


public class PersonalList extends ArrayAdapter<Educationaldata> {
    private Activity context;
    List<Educationaldata> educationaldata;

    public PersonalList(Activity context,List<Educationaldata> educationaldata){
        super(context,R.layout.layout_personal_list,educationaldata);
        this.context=context;
        this.educationaldata=educationaldata;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_personal_list, null, true);

        TextView textViewName=listViewItem.findViewById(R.id.textViewName);
        TextView textViewExperience=listViewItem.findViewById(R.id.textViewExperience);


        Educationaldata educationaldata1 = educationaldata.get(position);

        String s=educationaldata1.getFirstname()+" "+educationaldata1.getLastname();

        textViewName.setText(s);
        textViewExperience.setText(educationaldata1.getPhonenumber());

        return listViewItem;
    }
}
