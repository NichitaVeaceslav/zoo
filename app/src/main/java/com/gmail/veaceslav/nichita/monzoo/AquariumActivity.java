package com.gmail.veaceslav.nichita.monzoo;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AquariumActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new AquariumActivity.AquariumView(this));
        Log.i("CreateActivity", "onCreate()Aquarium fini");
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            //la intenstion
            // pour aller vers PopCOrn
            Intent i = new Intent(this, PopcornActivity.class);

            startActivity(i);
        }
        return true;//événement utilisé
    }


    public class AquariumView extends View {

        public AquariumView(Context context) {
            super(context);
        }



        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(BLUE);

            Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.aquarium);
            canvas.drawBitmap(b,0,0,null);


        }
    }
}
