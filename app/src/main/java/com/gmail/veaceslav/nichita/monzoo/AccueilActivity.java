package com.gmail.veaceslav.nichita.monzoo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class AccueilActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
        afficheNouvelle();
        Log.i("AccueilActivity", "onCreate fini");
    }

    private void afficheNouvelle() {
        try {
            InputStream is = getAssets().open("nouvelles.txt");
            //Reader r = new InputStreamReader(is, Charset.forName("UTF-8"));
            Reader r = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(r);
            String ligne, tout = "";
            while ( (ligne = br.readLine()) != null)
                tout += ligne + "\n";
            Log.i("AccueilActivity", "Nouvelles : " +tout);
            is.close();
        } catch (IOException ex) {
            Log.e("AccueilActivity", "Probleme d'ouvertrure de fichier nouvelle.txt", ex);
        }
    }
}
