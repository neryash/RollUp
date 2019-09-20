package com.nerya.rollup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class viewProject extends AppCompatActivity {

    TextView view, viewa, viewb, viewc, viewd, viewe, viewf, viewg, viewh, viewi, frameDisplay;
    ArrayList dance;
    String danceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_project);

        view = findViewById(R.id.dad);
        viewa = findViewById(R.id.dada);
        viewb = findViewById(R.id.dadb);
        viewc = findViewById(R.id.dadc);
        viewd = findViewById(R.id.dadd);
        viewe = findViewById(R.id.dade);
        viewf = findViewById(R.id.dadf);
        viewg = findViewById(R.id.dadg);
        viewh = findViewById(R.id.dadh);
        viewi = findViewById(R.id.dadi);

        dance = new ArrayList<>();
        danceName = getIntent().getStringExtra("danceAlgo");
        Log.i("dance", danceName + "");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("dances");
        query.whereEqualTo("nameOfDance", danceName + "");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e == null){
                    if(objects.size() > 0){
                        for (ParseObject list : objects){
                            list.get("dance");
                            dance = (ArrayList)list.get("dance");
                            Log.i("dance", dance.toString());
                        }
                    }else {
                        Toast.makeText(viewProject.this, "no objects", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(viewProject.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setXY(view.getId(), 1000, 1000);
    }

    public void setXY(int id, float x, float y){
        findViewById(id).setTranslationX(x);
        findViewById(id).setTranslationY(y);
    }
}
