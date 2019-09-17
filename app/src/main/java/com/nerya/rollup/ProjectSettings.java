package com.nerya.rollup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class ProjectSettings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private static final String[] paths = {"1 person", "2 people", "3 people", "4 people", "5 people", "6 people", "7 people", "8 people", "9 people", "10 people"};
    private int num = 0;
    private EditText pName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_settings);

        pName = findViewById(R.id.pName);

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ProjectSettings.this, android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent project = new Intent(ProjectSettings.this, project.class);
                project.putExtra("pName",pName.getText().toString());
                project.putExtra("numOfDancers", (num+1) + "");
                startActivity(project);

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                num = position;
                break;
            case 1:
                num = position;
                break;
            case 2:
                num = position;
                break;
            case 3:
                num = position;
                break;
            case 4:
                num = position;
                break;
            case 5:
                num = position;
                break;
            case 6:
                num = position;
                break;
            case 7:
                num = position;
                break;
            case 8:
                num = position;
                break;
            case 9:
                num = position;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
