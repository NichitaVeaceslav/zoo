package com.gmail.veaceslav.nichita.monzoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class AccueilActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        afficheNouvelle();

        Button btCarte = findViewById(R.id.accueil_bt_carte);
        btCarte.setOnClickListener(this);


        Log.i("AccueilActivity", "onCreate fini");
    }

    private void afficheNouvelle() {
        try {
            //Recuperatuin en inputstream
            InputStream is = getAssets().open("nouvelles.txt");
            //Reader r = new InputStreamReader(is, Charset.forName("UTF-8"));

            //Convertion Input stream en Reader
            Reader r = new InputStreamReader(is, StandardCharsets.UTF_8);
            //flux text en buffer
            BufferedReader br = new BufferedReader(r);
            String ligne, tout = "";
            while ( (ligne = br.readLine()) != null)
                //recuperation tous les lignes
                tout += ligne + "\n";
            Log.i("AccueilActivity", "Nouvelles : " +tout);
            is.close();
            //récupérer l'objet et écrire dedans
            TextView tvNouvelles = findViewById((R.id.accueil_nouvelles));
            tvNouvelles.setText(tout);

        } catch (IOException ex) {
            Log.e("AccueilActivity", "Probleme d'ouvertrure de fichier nouvelle.txt", ex);
        }
    }

    @Override
    public void onClick(View v) {
//ouvrir l'activité de la carte:
        //la intenstion
        // pour aller vers Carte
        Intent i = new Intent(this, CarteActivity.class);
        Log.i("AccueilActivity", "onClick fini");
        startActivityForResult(i, 0);
    }
}
