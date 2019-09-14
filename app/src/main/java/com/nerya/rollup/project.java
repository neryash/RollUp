package com.nerya.rollup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class project extends AppCompatActivity {
    TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        view = findViewById(R.id.dad);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData data = ClipData.newPlainText("value", view.getText());
                view.startDrag(data, new View.DragShadowBuilder(v), null, 0);
                return true;
            }
        });

        view.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                v.setTranslationX(event.getX());
                v.setTranslationY(event.getY());
                v.setBackgroundResource(R.drawable.face);

                Log.i("drag", event.getX() + "," + event.getY());
                switch(event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        Log.i("drag", "start!");
                        Log.i("drag", event.getX() + "," + event.getY());
                        return true;


                    case DragEvent.ACTION_DRAG_ENTERED:
                        v.setBackgroundColor(Color.LTGRAY);
                        Log.i("drag", "entered!");
                        Log.i("drag", event.getX() + "," + event.getY());
                        return true;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        Log.i("drag", DragEvent.ACTION_DRAG_LOCATION + "");
                        Log.i("drag", event.getX() + "," + event.getY());
                        return true;

                    case DragEvent.ACTION_DRAG_EXITED:
                        v.setBackgroundColor(Color.TRANSPARENT);
                        Log.i("drag", "done!");
                        Log.i("drag", event.getX() + "," + event.getY());
                        v.setTranslationX(event.getX());
                        v.setTranslationY(event.getY());
                        return true;

                    case DragEvent.ACTION_DROP:
                        Log.i("drag", "droped!");
                        Log.i("drag", event.getX() + "," + event.getY());
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        Log.i("drag", "ended!");
                        Log.i("drag", event.getX() + "," + event.getY());
                        return true;

                    default:
                        break;
                }
                return false;
            }
        });

        Toast.makeText(project.this, getIntent().getStringExtra("numOfDancers"), Toast.LENGTH_LONG).show();
    }



}
