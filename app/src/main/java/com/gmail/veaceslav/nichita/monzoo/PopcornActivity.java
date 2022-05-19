package com.gmail.veaceslav.nichita.monzoo;

import static android.graphics.Color.BLUE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class PopcornActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PopcornActivity.PopcornView(this));
        Log.i("CreateActivity", "onCreate()Aquarium fini");
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            //la intenstion
            // pour aller vers Carte
            Intent i = new Intent(this, CarteActivity.class);
            //comportment special
            //i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
        return true;//événement utilisé
    }

    public class PopcornView extends View {

        public PopcornView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(BLUE);

            Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.popcorn);
            canvas.drawBitmap(b,0,0,null);


        }
    }
}
