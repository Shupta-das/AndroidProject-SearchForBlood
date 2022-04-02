package com.example.searchforblood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchBloodActivity extends AppCompatActivity {

    Button searchButton;
    EditText Bloodneeded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_blood);
        searchButton=findViewById(R.id.searchButtonId);
        Bloodneeded=findViewById(R.id.needBloodId);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(SearchBloodActivity.this,DetailsActivity.class);
                String st=Bloodneeded.getText().toString().trim();
                Bundle b=new Bundle();
                b.putString("stuff",st);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

}
