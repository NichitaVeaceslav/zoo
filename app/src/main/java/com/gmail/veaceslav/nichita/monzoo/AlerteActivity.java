package com.gmail.veaceslav.nichita.monzoo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
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

        AutoCompleteTextView tvLieux = findViewById(R.id.alerte_et_lieu);
        String[] lieux = getResources().getStringArray(R.array.alerte_lieux);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,lieux);
        tvLieux.setAdapter(aa);
    }

    public void envoi(View v) {
        EditText etTitre = findViewById(R.id.alerte_et_titre);
        //récupérer l'info remplir par utilisateur
        String message = "Envoyé (" + etTitre.getText() + ")";
        CheckBox cbUrgent = findViewById(R.id.alerte_cb_urgent);
        if (cbUrgent.isChecked()) message += "!!!";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
