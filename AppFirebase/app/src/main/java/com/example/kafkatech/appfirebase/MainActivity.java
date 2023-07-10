package com.example.kafkatech.appfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference.child("pontos").setValue("100");
        //reference.child("usuario").child("001").child("nome").setValue("Batman");

        DatabaseReference usuarios = reference.child("usuarios");

        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setSobreNome("Alves");
        usuario.setIdade(35);

        usuarios.child("001").setValue(usuario);


        DatabaseReference produtos = reference.child("produtos");
        Produto produto = new Produto("Moto Edge 30", "Motorola", 2000.99);
        produtos.child("003").setValue(produto);

    }
}