package com.alex.teste.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private EditText valorGorjeta;
    private TextView porcentagemSeek;
    private TextView valorTotal;
    private TextView valorTotalGorjeta;
    private SeekBar seekBar;
    private double porcentagem = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorGorjeta = findViewById(R.id.valorGorjeta);
        porcentagemSeek = findViewById(R.id.resultSeek);
        valorTotal = findViewById(R.id.valorTotal);
        valorTotalGorjeta = findViewById(R.id.resultValorGorjeta);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                porcentagemSeek.setText(Math.round(porcentagem) + " %");

                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    public void calcular(){

       String valorRecuperado = valorGorjeta.getText().toString();

        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro", Toast.LENGTH_LONG).show();
        }
        else {
            double valorGorjeta = Double.parseDouble(valorRecuperado);
            double calc = valorGorjeta * porcentagem / 100;
            double valorFinal = valorGorjeta + calc;

            valorTotalGorjeta.setText("R$ " + String.format("%.2f", calc));
            valorTotal.setText("R$ " + String.format("%.2f", valorFinal));
        }

    }
}