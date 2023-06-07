package com.alex.teste.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textResult);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText("Progresso: " + progress + " / " + seekBar.getMax());
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //textView.setText("onStartTrackingTouch");
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //textView.setText("onStopTrackingTouch");
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void recuperarResultado(View view){
        textView.setText("Escolhido: " + seekBar.getProgress());
    }
}