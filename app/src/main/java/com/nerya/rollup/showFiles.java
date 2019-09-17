package com.nerya.rollup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
    List<String> myList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_files);

        //deleteFile("fileNames.txt");
            displayText = findViewById(R.id.displayText);
            listView = findViewById(R.id.list);
        myList = new ArrayList<>();
            readFiles();
            if(myList.size() == 0){
                myList.add("you dont have no files");
            }
            arrayAdapter = new ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    myList);

            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(this);


    }
    public void readFiles() {
        try {
            FileInputStream fileInputStream = openFileInput("fileNames.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }


            myList.add(Arrays.asList(stringBuffer.toString().split(",")).toString());

            displayText.setText(myList.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFile() {
        try {
            FileInputStream fileInputStream = openFileInput("Tutorial File.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }

            displayText.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        displayText.setText(myList.get(position));
    }
}
