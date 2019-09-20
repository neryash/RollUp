package com.nerya.rollup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class showFiles extends AppCompatActivity implements AdapterView.OnItemClickListener {
    TextView displayText;
    ListView listView;
    ArrayList dances;
    List<String> myList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_files);


        dances = new ArrayList<>();
            displayText = findViewById(R.id.displayText);
            listView = findViewById(R.id.list);
            findItems();
            arrayAdapter = new ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    dances);

            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(this);


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        displayText.setText(dances.get(position).toString());
    }
    public void findItems(){
        final ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("dances");
        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(objects.size() > 0) {
                    for (ParseObject item : objects) {
                        dances.add(item.get("nameOfDance"));
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

    }
}
