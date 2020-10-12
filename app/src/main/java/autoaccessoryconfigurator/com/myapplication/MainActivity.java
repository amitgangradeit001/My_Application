package autoaccessoryconfigurator.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnDragListener {

    private RelativeLayout targetedView1,targetedView2,targetedView3;
    private Button rightBtn,leftBtn,forwardBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Adding Comment for prod
        // Adding Comment for prod 17

        initUIElement();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initUIElement() {
        rightBtn = findViewById(R.id.rightBtn);
        leftBtn = findViewById(R.id.leftBtn);
        forwardBtn = findViewById(R.id.forwardBtn);
        targetedView1 = findViewById(R.id.targetedView1);
        targetedView2 = findViewById(R.id.targetedView2);
        targetedView3 = findViewById(R.id.targetedView3);

        rightBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData data = new ClipData("Right", mimeTypes, item);
                data.addItem(item);
                View.DragShadowBuilder dragshadow = new View.DragShadowBuilder(v);

                v.startDrag(data, dragshadow , v , 0);
                return true;
            }

        });

        leftBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData data = new ClipData("Left", mimeTypes, item);
                data.addItem(item);
                View.DragShadowBuilder dragshadow = new View.DragShadowBuilder(v);

                v.startDrag(data, dragshadow , v , 0);
                return true;
            }
        });

        forwardBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
              //  ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());

                ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
                ClipData data = new ClipData("forward", mimeTypes, item);
                data.addItem(item);

                View.DragShadowBuilder dragshadow = new View.DragShadowBuilder(v);

                v.startDrag(data, dragshadow , v , 0);
                return true;
            }
        });

        targetedView1.setOnDragListener(this);
//        targetedView2.setOnDragListener(this);
//        targetedView3.setOnDragListener(this);
    }


   /* private View.OnDragListener targetViewDragListener1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int action = dragEvent.getAction();
            switch (action) {

                case DragEvent.ACTION_DRAG_STARTED:
                    if (dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                    view.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    // Ignore the event
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:

                    view.getBackground().clearColorFilter();
                    view.invalidate();
                    return true;


                case DragEvent.ACTION_DROP:

                    Log.d("##----##", "onDrag: ....Action Drop..");
                    ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                    String clipData = (String) item.getText();
                    Log.d("TAG###########", "onDrag: target 1 ......"+clipData);
                    Button button = new Button(MainActivity.this);
                    button.setText("right");
                    Toast.makeText(MainActivity.this, "Dragged data", Toast.LENGTH_SHORT).show();

                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    view.getBackground().clearColorFilter();

                    view.invalidate();
                    if (dragEvent.getResult())
                        Toast.makeText(MainActivity.this, "The drop was handled.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                    // returns true; the value is ignored.
                    return true;

                default:
                    Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                    break;
            }
            return false;
        }
    };



 *//*   private View.OnDragListener targetViewDragListener2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int action = dragEvent.getAction();
            switch (action) {

                case DragEvent.ACTION_DRAG_STARTED:
                    if (dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        Log.d("##", "onDrag:ACTION_DRAG_STARTED ");
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                    view.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    // Ignore the event
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:

                    view.getBackground().clearColorFilter();
                    view.invalidate();
                    return true;


                case DragEvent.ACTION_DROP:

                    Log.d("##----##", "onDrag: ....Action Drop..");
                    ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                    String clipData = (String) item.getText();
                    Log.d("TAG###########", "onDrag: target 2 ......"+clipData);
                    Toast.makeText(MainActivity.this, "Dragged data is ", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Dragged data is ", Toast.LENGTH_SHORT).show();

                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    view.getBackground().clearColorFilter();
                    view.invalidate();

                    if (dragEvent.getResult())
                        Toast.makeText(MainActivity.this, "The drop was handled.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                    // returns true; the value is ignored.
                    return true;

                default:
                    Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                    break;
            }
            return false;
        }
    };


    private View.OnDragListener targetViewDragListener3 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            int action = dragEvent.getAction();
            switch (action) {

                case DragEvent.ACTION_DRAG_STARTED:
                    if (dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                        return true;
                    }
                    return false;

                case DragEvent.ACTION_DRAG_ENTERED:
                    view.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                    view.invalidate();
                    return true;

                case DragEvent.ACTION_DRAG_LOCATION:
                    // Ignore the event
                    return true;

                case DragEvent.ACTION_DRAG_EXITED:

                    view.getBackground().clearColorFilter();
                    view.invalidate();
                    return true;


                case DragEvent.ACTION_DROP:

                    Log.d("##----##", "onDrag: ....Action Drop..");
                    ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                    String clipData = (String) item.getText();
                    Log.d("TAG###########", "onDrag: target 3 ......"+clipData);
                    Toast.makeText(MainActivity.this, "Dragged data 3 ", Toast.LENGTH_SHORT).show();

                    return true;

                case DragEvent.ACTION_DRAG_ENDED:
                    view.getBackground().clearColorFilter();
                    view.invalidate();

                    if (dragEvent.getResult())
                        Toast.makeText(MainActivity.this, "The drop was handled.", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(MainActivity.this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                    // returns true; the value is ignored.
                    return true;

                default:
                    Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                    break;
            }
            return false;
        }
    };*/

    @Override
    public boolean onDrag(View v, DragEvent event) {
        // Defines a variable to store the action type for the incoming event
        int action = event.getAction();
        // Handles each of the expected events
        switch (action) {

            case DragEvent.ACTION_DRAG_STARTED:
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    return true;
                }
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:
                v.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                v.invalidate();
                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                // Ignore the event
                return true;

            case DragEvent.ACTION_DRAG_EXITED:

                v.getBackground().clearColorFilter();
                v.invalidate();
                return true;

            case DragEvent.ACTION_DROP:


                Log.d("##----##", "onDrag: ....Action Drop..");
                ClipData.Item item = event.getClipData().getItemAt(0);
                // Gets the text data from the item.
               // String dragData = item.getText().toString();
                // Displays a message containing the dragged data.
                Toast.makeText(this, "Dragged data is ", Toast.LENGTH_SHORT).show();
                // Turns off any color tints

                View vw = (View) event.getLocalState();
//                ViewGroup owner = (ViewGroup) vw.getParent();
//                owner.removeView(vw); //remove the dragged view
                //caste the view into LinearLayout as our drag acceptable layout is LinearLayout
                RelativeLayout container = (RelativeLayout) v;
                Button oldBtn = (Button)vw;
                Button newBtn = new Button(getApplicationContext());
                newBtn.setText(oldBtn.getText());
                container.addView(newBtn);//Add the dragged view
                vw.setVisibility(View.VISIBLE);//finally set Visibility to VISIBLE
                // Returns true. DragEvent.getResult() will return true.
                return true;

            case DragEvent.ACTION_DRAG_ENDED:
                v.getBackground().clearColorFilter();
                v.invalidate();

                if (event.getResult())
                    Toast.makeText(this, "The drop was handled.", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_SHORT).show();
                // returns true; the value is ignored.
                return true;
            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }
        return false;


    }


}
