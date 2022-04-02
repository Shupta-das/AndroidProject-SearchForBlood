package com.example.searchforblood;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Donor> {

    private Activity context;
    private List<Donor> donorList;

    public CustomAdapter(Activity context, List<Donor> donorList) {
        super(context, R.layout.sample_layout, donorList);
        this.context = context;
        this.donorList = donorList;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.sample_layout,null,true);

        Donor donor=donorList.get(position);

        TextView t1=view.findViewById(R.id.nameTextViewId);
        TextView t2=view.findViewById(R.id.ageTextViewId);
        TextView t3=view.findViewById(R.id.contactNumberTextViewId);
        TextView t4=view.findViewById(R.id.bloodGroupTextViewId);
        TextView t5=view.findViewById(R.id.availableTextViewId);
        TextView t6=view.findViewById(R.id.cityTextViewId);

        t1.setText("Name:"+donor.getName());
        t2.setText("Age:"+donor.getAge());
        t3.setText("Contact:"+donor.getContactNumber());
        t4.setText("BloodGroup:"+donor.getBloodGroup());
        t5.setText("Available:"+donor.getAvailable());
        t6.setText("City:"+donor.getCity());

        return view;
    }
}
