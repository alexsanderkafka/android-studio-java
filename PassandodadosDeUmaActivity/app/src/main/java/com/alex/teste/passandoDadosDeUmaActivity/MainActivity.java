package com.alex.teste.passandoDadosDeUmaActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttoEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttoEnviar = findViewById(R.id.buttonEnviar);

        buttoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SegundaActivity2.class);

                //Instanciar o objeto
                Usuario usuario = new Usuario("Alexsander", "alex@gmail.com");

                //Passar dados
                intent.putExtra("nome", "Alexsander");
                intent.putExtra("idade", 30);
                intent.putExtra("objeto", usuario);

                startActivity(intent);
            }
        });
    }


}