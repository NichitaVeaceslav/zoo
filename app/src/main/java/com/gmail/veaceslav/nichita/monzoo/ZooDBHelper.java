package com.gmail.veaceslav.nichita.monzoo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ZooDBHelper extends SQLiteOpenHelper {
    public ZooDBHelper(@Nullable Context context) {
        super(context, "zoo.sqlite", null, 2);
    }
    //apeler automatiquement si la BDD n'existe pas
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE alerte(" +
                "id INTEGER PRIMARY KEY, titre TEXT, lieu TEXT, infos TEXT, urgent BOOLEAN)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//if oldVersion ==1 && newVersion==2 mise_a_jour...
    }
    public void ajouterAlerte(String titre, String lieu, String infos, boolean urgent){
        try (SQLiteDatabase sqLiteDatabase = getWritableDatabase()){
            sqLiteDatabase.execSQL(
                    "INSERT INTO alerte(titre, lieu, infos, urgent) VALUES(?,?,?,?)",
                    new Object[]{titre, lieu, infos, urgent});
        }


        //automatique : sqLiteDatabase.close();
    }
}
