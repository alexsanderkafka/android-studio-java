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
            bancosDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
            //bancosDados.execSQL("DROP TABLE pessoas"); apaga a tabela


            //Inserir dados
            //bancosDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Mariana', 18)");
            //bancosDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES('Maria', 35)");

            //fazendo um update dos dados
            //bancosDados.execSQL("UPDATE pessoas SET idade = 55, nome = 'Mariana Silva' WHERE id = 3");

            //Exclui do banco de dados
            //bancosDados.execSQL("DELETE FROM pessoas WHERE id = 2");
            //bancosDados.execSQL("DELETE FROM pessoas"); exclui todos os dados da tabela

            //Recuperar pessoas
            /*String consulta = "SELECT nome, idade FROM pessoas " +
                              "WHERE nome = 'João' AND idade = 30 ";

              String consulta = "SELECT nome, idade FROM pessoas " +
                              "WHERE idade >= 35 OR idade = 18";

              String consulta = "SELECT nome, idade FROM pessoas " +
                              "WHERE nome IN('João', 'Pedro')";

              String consulta = "SELECT nome, idade FROM pessoas " +
                              "WHERE idade BETWEEN 30 AND 35";

              String filtro = "Si";
              String consulta = "SELECT nome, idade FROM pessoas " +
                              "WHERE nome LIKE '%" + filtro + "%'  ";*/

            String consulta = "SELECT * FROM pessoas " +
                              "WHERE 1=1 "; //ASC ou DESC

            Cursor cursor = bancosDados.rawQuery(consulta, null);

            //Indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");
            int indiceId = cursor.getColumnIndex("id");

            cursor.moveToFirst();

            while(cursor != null){
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceId);

                Log.i("RESULTADO - id ", id + " / nome: " + nome + " / idade: " + idade);
                cursor.moveToNext();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}