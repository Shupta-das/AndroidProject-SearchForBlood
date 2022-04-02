package com.example.searchforblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SaveDataActivity extends AppCompatActivity {

    private EditText nameEditText,ageEditText,cityEditText,bloodGroupEditText,availableEditText,contactNumberEditText;
    public  static  String nameS,ageS,cityS,bloodGroupS,availableS,contactNumberS;
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
        nameS=nameEditText.getText().toString().trim();
        ageS=ageEditText.getText().toString().trim();
        cityS=cityEditText.getText().toString().trim();
        bloodGroupS=spinner.getSelectedItem().toString();
       availableS=availableEditText.getText().toString().trim();
        contactNumberS=contactNumberEditText.getText().toString().trim();
        databaseReference= FirebaseDatabase.getInstance().getReference(bloodGroupS);

        String key=databaseReference.push().getKey();
        Donor donor=new Donor(nameS,ageS,contactNumberS,bloodGroupS,availableS,cityS);
        databaseReference.child(key).setValue(donor);

        //nameEditText.setText("");
        //ageEditText.setText("");
        //cityEditText.setText("");
        //availableEditText.setText("");
       // contactNumberEditText.setText("");
       // nameEditText.setText("");

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

        Toast.makeText(SaveDataActivity.this,"Updated successfully",Toast.LENGTH_SHORT).show();
        Intent loginIntent=new Intent(SaveDataActivity.this,MainActivity.class);
        startActivity(loginIntent);
    }
}
