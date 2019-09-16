package com.nerya.rollup;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ClipData;
import android.content.ClipDescription;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class project extends AppCompatActivity implements View.OnDragListener, View.OnLongClickListener {
    TextView view, viewa;
    int idTooMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        view = findViewById(R.id.dad);
        viewa = findViewById(R.id.dada);
        idTooMove = 0;

        view.setTranslationX(1000);

        view.setOnLongClickListener(this);
        viewa.setOnLongClickListener(this);
        view.setOnDragListener(this);
        viewa.setOnDragListener(this);

        //findViewById(R.id.target).setOnDragListener(this);

        //view.setTranslationX(getApplicationContext().getResources().getDisplayMetrics().widthPixels-100);

//        drag(view);
//        draga(viewa);

        Toast.makeText(project.this, getApplicationContext().getResources().getDisplayMetrics().heightPixels + "," + getApplicationContext().getResources().getDisplayMetrics().widthPixels, Toast.LENGTH_SHORT).show();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        try {
            getSupportActionBar().hide();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Toast.makeText(project.this, getIntent().getStringExtra("numOfDancers"), Toast.LENGTH_LONG).show();
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
                        findViewById(idTooMove).setTranslationX(event.getX()-200);
                        findViewById(idTooMove).setTranslationY(event.getY()-200);
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