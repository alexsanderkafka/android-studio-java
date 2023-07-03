package com.example.bancosdedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Criar banco de dados
            SQLiteDatabase bancosDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar tabela
            bancosDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(nome VARCHAR, idade INT(3))");

            //Inserir dados
            bancosDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Alex Silva', 90)");
            bancosDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Maria Dick', 25)");

            //Recuperar pessoas
            Cursor cursor = bancosDados.rawQuery("SELECT nome, idade FROM pessoas", null);

            //Indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while(cursor != null){
                Log.i("RESULTADO - nome: ", cursor.getString(indiceNome));
                Log.i("RESULTADO - idade: ", cursor.getString(indiceIdade));
                cursor.moveToNext();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}