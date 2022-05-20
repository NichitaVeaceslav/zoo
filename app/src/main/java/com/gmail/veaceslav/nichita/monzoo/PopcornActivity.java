package com.gmail.veaceslav.nichita.monzoo;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PopcornActivity extends Activity {
    private long debut;


    @SuppressLint("StringFormatMatches")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PopcornActivity.PopcornView(this));
        Log.i("CreateActivity", "onCreate()Aquarium fini");
        Intent i = getIntent();
        //0 la valeur par default
        long tempAquarium = i.getLongExtra(AquariumActivity.TEMPS_AQUARIUM, 0);
        //if (tempAquarium > 3000) { Test 3 secondes
        String[] poissons = getResources().getStringArray(R.array.poissons);
        String secondes = getResources().getQuantityString(R.plurals.popcorn_second, (int) (tempAquarium / 100));
        double r = (Math.random() * 10) / poissons.length;// 1 resultat des poissons possibles
        if (tempAquarium > 100) {
            Toast.makeText(this,
                    //"Pas de popcorn pour les poissons(" + tempAquarium/1000 + "secondes)",
                    getString(R.string.popcorn_message, tempAquarium / 1000,
                            secondes, poissons[(int) r]),
                    Toast.LENGTH_LONG).show();

        }

        debut = System.currentTimeMillis();
    }

    @Override
    public void onBackPressed() {
        long fin = System.currentTimeMillis(); // millisecondes depuis le 1/1/1970
        long tempPasse = fin - debut;
        Intent i = new Intent();
        i.putExtra("tempsPopcorn", tempPasse);
        setResult(0, i);
        super.onBackPressed();//fermeture de l'activite popcorn

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {

            if (event.getX() < 400) {
                //la intenstion
                // pour aller vers Carte
                Intent i = new Intent(this, CarteActivity.class);
                //comportment special
                //i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            } else {//appuyer à droite
                String infoPopcorn = "https://www.allrecipes.com/recipes/16051/appetizers-and-snacks/snacks/popcorn/";
                Uri url = Uri.parse(infoPopcorn);//donnée
                Intent i = new Intent(Intent.ACTION_VIEW, url);
                try {
                    startActivity(i);
                } catch (ActivityNotFoundException ex) {
                    Log.e("PopcornActivity", "Pas de bavugateur web");
                }

            }

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
            canvas.drawColor(RED);

            Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.popcorn);
            canvas.drawBitmap(b, 0, 0, null);


        }
    }
}
