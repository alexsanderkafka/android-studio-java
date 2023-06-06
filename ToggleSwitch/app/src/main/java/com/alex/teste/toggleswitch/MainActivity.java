package com.alex.teste.toggleswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ToggleButton toggleButton;
    private Switch switchButton;
    private CheckBox checkBox;

    public MainActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textResult);
        toggleButton = findViewById(R.id.botaoToggle);
        switchButton = findViewById(R.id.botaoSwitch);
        checkBox = findViewById(R.id.checkBox);

        adicionarListener();
    }

    public void adicionarListener() {

            //toggleButton
            //checkbox
            switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
                @SuppressLint("SetTextI18n")
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        textView.setText("Ligado");
                    }
                    else {
                        textView.setText("Desligado");
                    }
                }
            });
    }

    @SuppressLint("SetTextI18n")
    public void enviar(View view){

        //if (switchButton.isChecked()){
        //if (toggleButton.isChecked()){

        if (checkBox.isChecked()){
            textView.setText("Check Ligado");
        }
        else {
            textView.setText("Check Desligado");
        }
    }
}