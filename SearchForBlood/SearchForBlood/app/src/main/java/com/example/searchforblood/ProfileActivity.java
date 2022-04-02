package com.example.searchforblood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

     TextView name,age,contact,bloodgroup,city,available;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name=findViewById(R.id.nameId);
        age=findViewById(R.id.ageId);
        contact=findViewById(R.id.contactId);
        city=findViewById(R.id.cityId);
        available=findViewById(R.id.availableId);
        bloodgroup=findViewById(R.id.bloodGroupId);

        Information();
    }

    private void Information() {

                name.setText("NAME : "+SaveDataActivity.nameS);
                city.setText("CITY : "+SaveDataActivity.cityS);
                bloodgroup.setText("BLOOD_GROUP : "+SaveDataActivity.bloodGroupS);
                contact.setText("CONTACT_NUMBER : "+SaveDataActivity.contactNumberS);
                available.setText("AVAILABLE : "+SaveDataActivity.availableS);
                age.setText("AGE : "+SaveDataActivity.ageS);


            }

}
