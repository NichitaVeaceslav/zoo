package com.gmail.veaceslav.nichita.monzoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

        Button btAlerte = findViewById(R.id.accueil_bt_alerte);
        //classe anonime OnClickListener
        btAlerte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //afficher l'aquarium
                //ouvrir l'activité de la aquarium:
                //AccueilActivity.this et pas this du class curent OnClickListener
                Intent i = new Intent(AccueilActivity.this, AlerteActivity.class);
                startActivity(i);
            }
        });

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
        Log.i("AccueilActivity", "onClick carte fini");
        startActivity(i);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //chercher notre menu
        getMenuInflater().inflate(R.menu.accueil, menu);
        return true;

    }

    @Override
    public boolean onMenuItemSelected(int featureId, @NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_carte:
                //ouvrir la carte
                Intent i = new Intent(this, CarteActivity.class);
                startActivity(i);
                break;
            case R.id.menu_enregistrer:
                 item.setChecked(! item.isChecked() );
                break;
        }
        return true;
    }
}
