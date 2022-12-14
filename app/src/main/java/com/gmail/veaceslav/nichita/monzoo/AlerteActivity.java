package com.gmail.veaceslav.nichita.monzoo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alerte_confirmer_titre);
        builder.setMessage(R.string.alerte_confirmer_text);
        builder.setIcon(android.R.drawable.ic_input_get);
        //avec f-tion anonime
        builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                confirmer();
            }
        });
        builder.setNegativeButton(android.R.string.no,null);
        builder.show();
    }
    private void confirmer(){
        EditText etTitre = findViewById(R.id.alerte_et_titre);
        EditText etLieu= findViewById(R.id.alerte_et_lieu);
        EditText etInfos = findViewById(R.id.alerte_et_infos);
        CheckBox cbUrgent = findViewById(R.id.alerte_cb_urgent);
        //r??cup??rer l'info remplir par utilisateur
        String message = "Envoy?? (" + etTitre.getText() + ")";
        SharedPreferences sp = getSharedPreferences("zoo", MODE_PRIVATE );

        if (sp.getBoolean("enregister", true)){//SI LA case Enregister du menu est cosh??e
//enregister dans la base
            try{
                String titre = etTitre.getText().toString();
                String lieu = etLieu.getText().toString();
                String infos = etInfos.getText().toString();
                boolean urgent = cbUrgent.isChecked();
                ZooDBHelper z = new ZooDBHelper(this);

                z.ajouterAlerte(titre, lieu, infos, urgent );
                Log.i("AlerteActivity", "Eregistrement BD ok");
            }catch (Exception e){
                Log.e("AlerteActivity", "Eregistrement BD ", e);
            }
        }
        if (cbUrgent.isChecked()) message += "!!!";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}
