package com.example.kafkatech.requisicoeshttp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

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
                MyTask task = new MyTask();
                String urlApi = "https://blockchain.info/ticker";
                //String urlApi = "https://blockchain.info/tobtc?currency=USD&value=500";
                //String urlApi = "https://viacep.com.br/ws/01001000/json/";
                task.execute(urlApi);
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    public class MyTask extends AsyncTask<String, Void, String>{

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

        @SuppressLint("SetTextI18n")
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            /*
            String logradouro = null;
            String cep = null;
            String complemento = null;
            String bairro = null;
            String localidade = null;
            String uf = null;*/

            String objetoValor = null;
            String valorMoeda = null;
            String simbolo = null;

            try {
                /*
                JSONObject json = new JSONObject(s);
                logradouro = json.getString("logradouro");
                cep = json.getString("cep");
                complemento = json.getString("complemento");
                bairro = json.getString("bairro");
                localidade = json.getString("localidade");
                uf = json.getString("uf");*/

                JSONObject json = new JSONObject(s);
                objetoValor = json.getString("BRL");

                JSONObject jsonReal = new JSONObject(objetoValor);
                valorMoeda = jsonReal.getString("last");
                simbolo = jsonReal.getString("symbol");

            }
            catch (JSONException e) {
                throw new RuntimeException(e);
            }

            //resultado.setText(logradouro + " / " + cep + " / " + bairro + " / " + complemento + " / " + localidade + " / " + uf);
            resultado.setText(simbolo + "  " + valorMoeda);
        }
    }

}