package com.nerya.rollup;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class project extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {
    TextView view, viewa, viewb, viewc, viewd, viewe, viewf, viewg, viewh, viewi, frameDisplay;
    int idTooMove, numDancers, frame;
    Button next, previous, finish;
    List allPos = new ArrayList<>();
    List framePos = new ArrayList<>();
    List pos = new ArrayList<>();
    List posa = new ArrayList<>();
    List posb = new ArrayList<>();
    List posc = new ArrayList<>();
    List posd = new ArrayList<>();
    List pose = new ArrayList<>();
    List posf = new ArrayList<>();
    List posg = new ArrayList<>();
    List posh = new ArrayList<>();
    List posi = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        ParseInstallation.getCurrentInstallation().saveInBackground();

        allPos.add(getIntent().getStringExtra("pName"));

        frameDisplay = findViewById(R.id.frameDisplay);

        frameDisplay.setText("frame 1");

        finish = findViewById(R.id.finisha);

        frame = 1;

        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);

        if(frame == 1){
            previous.setText("Back To Settings");
        }else {
            previous.setText("back");
        }

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToServer();
            }
        });

//try {
    numDancers = Integer.parseInt(getIntent().getStringExtra("numOfDancers"));
//}catch (Exception e){
 //   e.printStackTrace();
//}


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
        idTooMove = 0;

        setXY(view.getId(), 10, 5);

        setXY(viewa.getId(), 200, 5);

        setXY(viewb.getId(), 395, 5);

        setXY(viewc.getId(), 590, 5);

        setXY(viewd.getId(), 780, 5);

        setXY(viewe.getId(), 970, 5);

        setXY(viewf.getId(), 1160, 5);

        setXY(viewg.getId(), 1350, 5);

        setXY(viewh.getId(), 1540, 5);

        setXY(viewi.getId(), 1730, 5);

        view.setOnLongClickListener(this);
        viewa.setOnLongClickListener(this);
        viewb.setOnLongClickListener(this);
        viewc.setOnLongClickListener(this);
        viewd.setOnLongClickListener(this);
        viewe.setOnLongClickListener(this);
        viewf.setOnLongClickListener(this);
        viewg.setOnLongClickListener(this);
        viewh.setOnLongClickListener(this);
        viewi.setOnLongClickListener(this);

        view.setOnDragListener(this);
        viewa.setOnDragListener(this);
        viewb.setOnDragListener(this);
        viewc.setOnDragListener(this);
        viewd.setOnDragListener(this);
        viewe.setOnDragListener(this);
        viewf.setOnDragListener(this);
        viewg.setOnDragListener(this);
        viewh.setOnDragListener(this);
        viewi.setOnDragListener(this);

        switch (numDancers){
            case 1:
                viewa.setVisibility(View.INVISIBLE);
                viewb.setVisibility(View.INVISIBLE);
                viewc.setVisibility(View.INVISIBLE);
                viewd.setVisibility(View.INVISIBLE);
                viewe.setVisibility(View.INVISIBLE);
                viewf.setVisibility(View.INVISIBLE);
                viewg.setVisibility(View.INVISIBLE);
                viewh.setVisibility(View.INVISIBLE);
                viewi.setVisibility(View.INVISIBLE);
                break;
            case 2:
                viewb.setVisibility(View.INVISIBLE);
                viewc.setVisibility(View.INVISIBLE);
                viewd.setVisibility(View.INVISIBLE);
                viewe.setVisibility(View.INVISIBLE);
                viewf.setVisibility(View.INVISIBLE);
                viewg.setVisibility(View.INVISIBLE);
                viewh.setVisibility(View.INVISIBLE);
                viewi.setVisibility(View.INVISIBLE);
                break;
            case 3:
                viewc.setVisibility(View.INVISIBLE);
                viewd.setVisibility(View.INVISIBLE);
                viewe.setVisibility(View.INVISIBLE);
                viewf.setVisibility(View.INVISIBLE);
                viewg.setVisibility(View.INVISIBLE);
                viewh.setVisibility(View.INVISIBLE);
                viewi.setVisibility(View.INVISIBLE);
                break;
            case 4:
                viewd.setVisibility(View.INVISIBLE);
                viewe.setVisibility(View.INVISIBLE);
                viewf.setVisibility(View.INVISIBLE);
                viewg.setVisibility(View.INVISIBLE);
                viewh.setVisibility(View.INVISIBLE);
                viewi.setVisibility(View.INVISIBLE);
                break;
            case 5:
                viewe.setVisibility(View.INVISIBLE);
                viewf.setVisibility(View.INVISIBLE);
                viewg.setVisibility(View.INVISIBLE);
                viewh.setVisibility(View.INVISIBLE);
                viewi.setVisibility(View.INVISIBLE);
                break;
            case 6:
                viewf.setVisibility(View.INVISIBLE);
                viewg.setVisibility(View.INVISIBLE);
                viewh.setVisibility(View.INVISIBLE);
                viewi.setVisibility(View.INVISIBLE);
                break;
            case 7:
                viewg.setVisibility(View.INVISIBLE);
                viewh.setVisibility(View.INVISIBLE);
                viewi.setVisibility(View.INVISIBLE);
                break;
            case 8:
                viewh.setVisibility(View.INVISIBLE);
                viewi.setVisibility(View.INVISIBLE);
                break;
            case 9:
                viewi.setVisibility(View.INVISIBLE);
                break;
            case 10:
                break;
        }

        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                framePos.clear();
                framePos.add(pos);
                framePos.add(posa);
                framePos.add(posb);
                framePos.add(posc);
                framePos.add(posd);
                framePos.add(pose);
                framePos.add(posf);
                framePos.add(posg);
                framePos.add(posh);
                framePos.add(posi);
                Log.i("arrTest", framePos.toString());
                allPos.add(framePos.toString());
                Log.i("arrTest", allPos.toString());
                frame++;
                frameDisplay.setText("frame " + frame);
                if(frame == 1){
                    previous.setText("Back To Settings");
                }else {
                    previous.setText("back");
                }
            }
        });
        findViewById(R.id.previous).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(frame == 1){
                    AlertDialog.Builder builder = new AlertDialog.Builder(project.this);

                    builder.setTitle("Confirm");
                    builder.setMessage("Are you sure you want to exit? Your project won't be saved");

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(project.this, ProjectSettings.class);
                            startActivity(intent);

                            dialog.dismiss();
                        }
                    });

                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            // Do nothing
                            dialog.dismiss();
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();


                }else {
                    frame--;
                    frameDisplay.setText("frame " + frame);
                    if(frame == 1){
                        previous.setText("Back To Settings");
                    }else {
                        previous.setText("back");
                    }
                }
            }
        });
        //findViewById(R.id.target).setOnDragListener(this);

        //view.setTranslationX(getApplicationContext().getResources().getDisplayMetrics().widthPixels-100);

//        drag(view);
//        draga(viewa);

        //Toast.makeText(project.this, getApplicationContext().getResources().getDisplayMetrics().heightPixels + "," + getApplicationContext().getResources().getDisplayMetrics().widthPixels, Toast.LENGTH_SHORT).show();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Toast.makeText(project.this, getIntent().getStringExtra("numOfDancers"), Toast.LENGTH_LONG).show();
    }

public void saveToServer(){
    framePos.clear();
    framePos.add(pos);
    framePos.add(posa);
    framePos.add(posb);
    framePos.add(posc);
    framePos.add(posd);
    framePos.add(pose);
    framePos.add(posf);
    framePos.add(posg);
    framePos.add(posh);
    framePos.add(posi);
    Log.i("arrTest", framePos.toString());
    allPos.add(framePos.toString());
    Log.i("arrTest", allPos.toString());
    ParseObject server = new ParseObject("dances");
    server.put("nameOfDance", allPos.get(0));
    server.put("dance", allPos);
    server.saveInBackground(new SaveCallback() {
        @Override
        public void done(ParseException e) {
            if (e == null){
                Toast.makeText(project.this, "Project Saved!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(project.this, MainActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(project.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    });
}
    public void setXY(int id, float x, float y){
        findViewById(id).setTranslationX(x);
        findViewById(id).setTranslationY(y);
    }

    @Override
    public void onBackPressed() {
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        //Log.i("idfind", v.getId() + "");
        // Handles each of the expected events
        switch (action) {

            case DragEvent.ACTION_DRAG_STARTED:
                // Determines if this View can accept the dragged data
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // if you want to apply color when drag started to your view you can uncomment below lines
                    // to give any color tint to the View to indicate that it can accept data.
                    // v.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                    // Invalidate the view to force a redraw in the new tint
                    //  v.invalidate();
                    // returns true to indicate that the View can accept the dragged data.
                    return true;
                }
                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                // Applies a GRAY or any color tint to the View. Return true; the return value is ignored.
                //v.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                // Invalidate the view to force a redraw in the new tint
                //v.invalidate();
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;

            case DragEvent.ACTION_DRAG_EXITED:
                // Re-sets the color tint to blue. Returns true; the return value is ignored.
                // view.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                //It will clear a color filter .
//                v.getBackground().clearColorFilter();
                // Invalidate the view to force a redraw in the new tint
                v.invalidate();
                return true;

            case DragEvent.ACTION_DROP:
                // Gets the item containing the dragged data
                ClipData.Item item = event.getClipData().getItemAt(0);
                // Gets the text data from the item.
                //String dragData = item.getText().toString();
                // Displays a message containing the dragged data.
                //Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_SHORT).show();
                // Turns off any color tints
               // v.getBackground().clearColorFilter();
                // Invalidates the view to force a redraw
                //v.invalidate();

                View vw = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) vw.getParent();
                owner.removeView(vw); //remove the dragged view
                //caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                //ConstraintLayout container = (ConstraintLayout) v;
                //container.addView(vw);//Add the dragged view
                vw.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE
                // Returns true. DragEvent.getResult() will return true.
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                Log.i("mikoom", event.getX() + "," + event.getY());
                Log.i("mikoom", v.getX() + "," + v.getY());
                // Turns off any color tinting
//                v.getBackground().clearColorFilter();
                // Invalidates the view to force a redraw
                //v.invalidate();
                // Does a getResult(), and displays what happened.
                //if (event.getResult())
                    //Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();
                //else
                    //Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                //int id = v.getId();
                try {
                    findViewById(idTooMove).setTranslationX(event.getX()-100);
                    findViewById(idTooMove).setTranslationY(event.getY()-200);

                    switch (idTooMove){
                        case R.id.dad:
                            pos.clear();
                            pos.add(0, idTooMove);
                            pos.add(1, event.getX()-100);
                            pos.add(2, event.getY()-200);
                            break;
                        case R.id.dada:
                            posa.clear();
                            posa.add(0, idTooMove);
                            posa.add(1, event.getX()-100);
                            posa.add(2, event.getY()-200);
                            break;
                        case R.id.dadb:
                            posb.clear();
                            posb.add(0, idTooMove);
                            posb.add(1, event.getX()-100);
                            posb.add(2, event.getY()-200);
                            break;
                        case R.id.dadc:
                            posc.clear();
                            posc.add(0, idTooMove);
                            posc.add(1, event.getX()-100);
                            posc.add(2, event.getY()-200);
                            break;
                        case R.id.dadd:
                            posd.clear();
                            posd.add(0, idTooMove);
                            posd.add(1, event.getX()-100);
                            posd.add(2, event.getY()-200);
                            break;
                        case R.id.dade:
                            pose.clear();
                            pose.add(0, idTooMove);
                            pose.add(1, event.getX()-100);
                            pose.add(2, event.getY()-200);
                            break;
                        case R.id.dadf:
                            posf.clear();
                            posf.add(0, idTooMove);
                            posf.add(1, event.getX()-100);
                            posf.add(2, event.getY()-200);
                            break;
                        case R.id.dadg:
                            posg.clear();
                            posg.add(0, idTooMove);
                            posg.add(1, event.getX()-100);
                            posg.add(2, event.getY()-200);
                            break;
                        case R.id.dadh:
                            posh.clear();
                            posh.add(0, idTooMove);
                            posh.add(1, event.getX()-100);
                            posh.add(2, event.getY()-200);
                            break;
                        case R.id.dadi:
                            posi.clear();
                            posi.add(0, idTooMove);
                            posi.add(1, event.getX()-100);
                            posi.add(2, event.getY()-200);
                            break;
                    }


                }catch (Exception e){
                    e.printStackTrace();
                }

                // returns true; the value is ignored.
                return true;
            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        // create it from the object's tag
        ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());

        String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
        ClipData data = new ClipData(v.getTag() + "", mimeTypes, item);
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);

        idTooMove = v.getId();
        Log.i("firstId", v.getId() + "");

        v.startDrag( data, //data to be dragged
                shadowBuilder, //drag shadow
                v, //local data about the drag and drop operation
                0   //no needed flags
        );


        //view.setVisibility(View.INVISIBLE);
        return true;
    }


//    @Override
//    public boolean onLongClick(View v) {
////        // Create a new ClipData.Item from the View object's tag
////        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
////
////        // Create a new ClipData using the tag as a label, the plain text MIME type, and
////        // the already-created item. This will create a new ClipDescription object within the
////        // ClipData, and set its MIME type entry to "text/plain"
////        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
////        ClipData data = new ClipData(v.getTag() + "", mimeTypes, item);
////
////        // Instantiates the drag shadow builder.
////        View.DragShadowBuilder dragshadow = new View.DragShadowBuilder(v);
////
////        // Starts the drag
////        v.startDrag(data       // data to be dragged
////                , dragshadow  // drag shadow
////                , v            // local data about the drag and drop operation
////                , 0          // flags set to 0 because not using currently
////        );
////        return true;
//        //ClipData data = ClipData.newPlainText("value", v.getCha);
//        ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
//        String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
//        ClipData data = new ClipData(v.getTag() + "", mimeTypes, item);
//        v.startDrag(data, new View.DragShadowBuilder(v), null, 0);
//        return true;
//    }
//    @Override
//    public boolean onDrag(View v, DragEvent event) {
//
//        v.setTranslationX(event.getX());
//        v.setTranslationY(event.getY());
//        // Defines a variable to store the action type for the incoming event
//        int action = event.getAction();
//        // Handles each of the expected events
//        switch (action) {
//
//
//            case DragEvent.ACTION_DRAG_STARTED:
//
//
//                // Determines if this View can accept the dragged data
//                //if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
//                    // applies a blue color tint to the View to indicate that it can accept the data
//                    //v.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
//                    // Invalidate the view to force a redraw in the new tint
//                    //v.invalidate();
//                    // returns true to indicate that the View can accept the dragged data.
//                    //return true;
//                //}
//                // Returns false. During the current drag and drop operation, this View will
//                // not receive events again until ACTION_DRAG_ENDED is sent.
//                Log.i("drag", DragEvent.ACTION_DRAG_LOCATION + "");
//                Log.i("drag", event.getX() + "," + event.getY());
//                return false;
//
//            case DragEvent.ACTION_DRAG_ENTERED:
//
//                Log.i("drag", DragEvent.ACTION_DRAG_LOCATION + "");
//                Log.i("drag", event.getX() + "," + event.getY());
//                // Applies a YELLOW or any color tint to the View. Return true; the return value is ignored.
//                //v.getBackground().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
//                // Invalidate the view to force a redraw in the new tint
//                //v.invalidate();
//                return true;
//
//
//            case DragEvent.ACTION_DRAG_LOCATION:
//                // Ignore the event
//                Log.i("drag", DragEvent.ACTION_DRAG_LOCATION + "");
//                Log.i("drag", event.getX() + "," + event.getY());
//                return true;
//
//
//            case DragEvent.ACTION_DRAG_EXITED:
//                Log.i("drag", DragEvent.ACTION_DRAG_LOCATION + "");
//                Log.i("drag", event.getX() + "," + event.getY());
//
////                Toast.makeText(project.this, "Exited", Toast.LENGTH_SHORT).show();
////                // Re-sets the color tint to blue, if you had set the BLUE color or any color in ACTION_DRAG_STARTED. Returns true; the return value is ignored.
////                v.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
////                //If u had not provided any color in ACTION_DRAG_STARTED then clear color filter.
////                v.getBackground().clearColorFilter();
////                v.setTranslationX(event.getX());
////                v.setTranslationY(event.getY());
////                // Invalidate the view to force a redraw in the new tint
////                v.invalidate();
//                return true;
//            case DragEvent.ACTION_DROP:
//                // Gets the item containing the dragged data
////                ClipData.Item item = event.getClipData().getItemAt(0);
////                // Gets the text data from the item.
////                String dragData = item.getText() + "";
////                // Displays a message containing the dragged data.
////                Toast.makeText(project.this, "Dropped", Toast.LENGTH_SHORT).show();
////                // Turns off any color tints
////                v.getBackground().clearColorFilter();
////                // Invalidates the view to force a redraw
////                v.invalidate();
////                // Returns true. DragEvent.getResult() will return true.
//                Log.i("drag", DragEvent.ACTION_DRAG_LOCATION + "");
//                Log.i("drag", event.getX() + "," + event.getY());
//                return true;
//            case DragEvent.ACTION_DRAG_ENDED:
////                // Turns off any color tinting
////                v.getBackground().clearColorFilter();
////                // Invalidates the view to force a redraw
////                //v.invalidate();
////                // Does a getResult(), and displays what happened.
//                Log.i("drag", DragEvent.ACTION_DRAG_LOCATION + "");
//                Log.i("drag", event.getX() + "," + event.getY());
////                //if (event.getResult()) {
////                    Toast.makeText(project.this, "The drop was handled.", Toast.LENGTH_SHORT).show();
////                //} else {
////                    Toast.makeText(project.this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
////                //}
////                // returns true; the value is ignored.
//                return true;
//
//            // An unknown action type was received.
//            default:
//                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
//
//                break;
//        }
//        return false;
//    }
}