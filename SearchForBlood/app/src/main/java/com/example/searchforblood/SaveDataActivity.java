package com.example.searchforblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaveDataActivity extends AppCompatActivity {

    private EditText nameEditText,ageEditText,cityEditText,bloodGroupEditText,availableEditText,contactNumberEditText;
    private Button saveButton;
    DatabaseReference databaseReference;
    String[] bloodGroupNames;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_data);

        Initialize();

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.sample_view,R.id.textViewSampleId,bloodGroupNames);
        spinner.setAdapter(adapter);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        String name=nameEditText.getText().toString().trim();
        String age=ageEditText.getText().toString().trim();
        String city=cityEditText.getText().toString().trim();
        String bloodGroup=spinner.getSelectedItem().toString();
        String available=availableEditText.getText().toString().trim();
        String contactNumber=contactNumberEditText.getText().toString().trim();
        databaseReference= FirebaseDatabase.getInstance().getReference(bloodGroup);

        String key=databaseReference.push().getKey();
        Donor donor=new Donor(name,age,contactNumber,bloodGroup,available,city);
        databaseReference.child(key).setValue(donor);

        SendUserToMainActivity();

    }

    private void Initialize() {
        spinner=(Spinner)findViewById(R.id.spinnerId);
        bloodGroupNames=getResources().getStringArray(R.array.blood_group_names);
        nameEditText=(EditText)findViewById(R.id.nameEditTextId);
        ageEditText=(EditText)findViewById(R.id.ageEditTextId);
        cityEditText=(EditText)findViewById(R.id.cityEditTextId);
        //bloodGroupEditText=(EditText)findViewById(R.id.bloodGroupEditTextId);
        availableEditText=(EditText)findViewById(R.id.availableEditTextId);
        saveButton=(Button) findViewById(R.id.saveButtonId);
        contactNumberEditText=(EditText)findViewById(R.id.contactNumberEditTextId);
    }
    private void SendUserToMainActivity() {

        Intent loginIntent=new Intent(SaveDataActivity.this,MainActivity.class);
        startActivity(loginIntent);
    }
}
