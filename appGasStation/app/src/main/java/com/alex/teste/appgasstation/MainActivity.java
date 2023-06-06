package com.alex.teste.appgasstation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool, editGasolina;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textResult);
        editAlcool = findViewById(R.id.precoAlcool);
        editGasolina = findViewById(R.id.precoGasolina);
    }

    @SuppressLint("SetTextI18n")
    public void calcular(View view) {

        String priceAlcool = editAlcool.getText().toString();
        String priceGasolina = editGasolina.getText().toString();

        Boolean camposValidados = validarCampos(priceAlcool, priceGasolina);

        if (camposValidados) {
            Double alcool = Double.parseDouble(priceAlcool);
            Double gasolina = Double.parseDouble(priceGasolina);

            if (alcool / gasolina >= 0.7){
                textView.setText("É melhor utilizar a Gasolina");
            }
            else {
                textView.setText("É melhor utilizar o Álcool");
            }
        }
        else {
            textView.setText("Não foi possível realizar o calculo");
        }

    }

        public Boolean validarCampos(String alcool, String gasolina){

            Boolean camposValidados = true;

            if (alcool == null || alcool.equals("")){
                camposValidados = false;
            } else if (gasolina == null || gasolina.equals("")) {
                camposValidados = false;
            }

            return camposValidados;
        }
}