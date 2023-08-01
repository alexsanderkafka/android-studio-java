package com.example.kafkatech.requisicoeshttp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button recuperar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recuperar = findViewById(R.id.buttonRecuperar);
        resultado = findViewById(R.id.textViewResultado);

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsync task = new MyAsync();
                //String urlApi = "https://blockchain.info/ticker";
                //String urlApi = "https://blockchain.info/tobtc?currency=USD&value=500";
                String urlApi = "https://viacep.com.br/ws/01001000/json/";
                task.execute(urlApi);
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    public class MyAsync extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = strings[0];
            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;
            StringBuffer buffer = null;

            try {
                URL url = new URL(stringUrl);
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

                // Recupera os dados em Bytes
                inputStream = conexao.getInputStream();

                // Lê os dados em Bytes e decodifica para caractere
                inputStreamReader = new InputStreamReader(inputStream);

                //Para fazer a leitura dos caracteres do inputStreamReader
                BufferedReader reader = new BufferedReader(inputStreamReader);
                buffer = new StringBuffer();
                String linha = "";

                while((linha = reader.readLine()) != null){
                    buffer.append(linha);
                }

            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

            return buffer.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            resultado.setText(s);
        }
    }

}