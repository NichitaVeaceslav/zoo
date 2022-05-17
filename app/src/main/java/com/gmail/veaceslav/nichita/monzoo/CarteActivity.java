package com.gmail.veaceslav.nichita.monzoo;

import static android.graphics.Color.*;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CarteActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CarteView(this));
        Log.i("CreateActivity", "onCreate() fini");
        Toast.makeText(this, "Bonjour à vous!", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            //la intenstion
            // pour aller vers aquarium
            Intent i = new Intent(this, AquariumActivity.class);
            startActivity(i);
        }
        return true;//événement utilisé
    }

    public class CarteView extends View {

        public CarteView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(GREEN);
            Paint paint = new Paint();
            paint.setColor(RED);
            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.carte);
            canvas.drawBitmap(b, 0, 0, null);
            canvas.drawLine(0, 200, 600, 200, paint);
            Bitmap c = BitmapFactory.decodeResource(getResources(), R.drawable.zoo);
            canvas.drawBitmap(c, 400, 0, null);

        }
    }
}
