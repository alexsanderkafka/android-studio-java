package com.example.minhasanotaes;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.minhasanotaes.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private AnotacaoPreferencias preferencias;

    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacoes);

        preferencias = new AnotacaoPreferencias( getApplicationContext() );

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validar se foi digitado algo
                String textoRecuperado = editAnotacao.getText().toString();
                if( textoRecuperado.equals("") ){
                    Snackbar.make(view, "Preencha a anotaçao!", Snackbar.LENGTH_LONG).show();
                }
                else {
                    preferencias.salvarAnotacao( textoRecuperado );
                    Snackbar.make(view, "Anotaçao salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }

            }
        });

        //Recuperar anotacao
        String anotacao = preferencias.recuperarAnotacao();
        if(!Objects.equals(anotacao, "")){
            editAnotacao.setText( anotacao );
        }
    }

}