package com.gmail.veaceslav.nichita.monzoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class AlerteActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alerte);

    }

    public void envoi(View v){
        EditText etTitre = findViewById(R.id.alerte_et_titre);
        //récupérer l'info remplir par utilisateur
        String message = "Envoyé (" + etTitre.getText() + ")";
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

}
