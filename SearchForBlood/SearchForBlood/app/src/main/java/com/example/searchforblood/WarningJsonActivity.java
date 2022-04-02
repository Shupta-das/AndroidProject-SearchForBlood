package com.example.searchforblood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WarningJsonActivity extends AppCompatActivity {

    Button click;
    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning_json);
        click=(Button)findViewById(R.id.hitButtonId);
        data=(TextView)findViewById(R.id.textId) ;
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchData process=new fetchData();
                process.execute();

            }
        });
    }
}
