package com.alex.teste.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirDailog(View view){

        // Instanciar AlerDialog
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        // Configurando titulo e mensagem
        alert.setTitle("Título da dialog");
        alert.setMessage("Mensagem da Dialog");

        //Configurar cancelamento
        alert.setCancelable(false);

        //Configurar icone
        alert.setIcon(android.R.drawable.ic_btn_speak_now);

        //Configurando acoes para sim e nao
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Executar ao clicar no botão sim", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Executar ao clicar no botão não", Toast.LENGTH_SHORT).show();
            }
        });

        // Criar e exibir AlertDialog
        alert.create();
        alert.show();
    }
}