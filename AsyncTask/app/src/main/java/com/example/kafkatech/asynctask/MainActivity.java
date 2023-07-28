package com.example.kafkatech.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends  AppCompatActivity {

    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
    }

    public void iniciarAsync(View view){
        MyAsync myAsync = new MyAsync();
        myAsync.execute(10);
    }

    /*
    * 1 -> Parâmetro a ser passado para a classe / void
    * 2 -> Tipo de valor que será utilizado para o prograsso da tarefa
    * 3 -> Retorno após tarefa finalizada
    * */

    public class MyAsync extends AsyncTask<Integer, Integer, String>{

        //... var args
        // primeiro valor para o doInBackgound
        // segundo valor para o onProgressUpdate
        // terceiro valor para o onPostExecute

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {

            int numero = integers[0];

            for (int i = 0; i < numero; i++){
                publishProgress(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return "Finalizado";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            progressBar.setProgress(0);
            progressBar.setVisibility(View.INVISIBLE);
        }

    }
}