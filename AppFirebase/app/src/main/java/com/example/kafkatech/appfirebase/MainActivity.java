package com.example.kafkatech.appfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference.child("pontos").setValue("100");
        //reference.child("usuario").child("001").child("nome").setValue("Batman");

        DatabaseReference usuarios = reference.child("usuarios");
        DatabaseReference produtos = reference.child("produtos");

        /*
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setSobreNome("Alves");
        usuario.setIdade(35);

        usuarios.child("001").setValue(usuario);

        Produto produto = new Produto("Moto Edge 30", "Motorola", 2000.99);
        produtos.child("003").setValue(produto);*/


        //Recuperar os dados do firebase

        usuarios.addValueEventListener(new ValueEventListener() { //pode usar antes o child()
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Log.i("FIREBASE", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*//Firebase Authentication
        //Cadastro de usuario
        auth.createUserWithEmailAndPassword(
                "alex2@gmail.com", "al12345")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("CreateUser", "Sucesso ao cadastrar usuario!");
                        }
                        else {
                            Log.i("CreateUser", "Erro ao cadastrar usuario!");
                        }
                    }
                });

        //Desloga usuario
        //auth.signOut();

        //Verifica o cadastro do usuario
        if (auth.getCurrentUser() != null){
            Log.i("CurrentUse", "Usuario logado!");
        }
        else{
            Log.i("CurrentUse", "Usuario nao logado!");
        };

        //Logar Usuario
        auth.signInWithEmailAndPassword(
                "alex2@gmail.com", "al12345")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Log.i("signIn", "Sucesso ao logar usuario!");
                        }
                        else {
                            Log.i("signIn", "Erro ao logar usuario!");
                        }
                    }
                });*/
        /*salva user
        Usuario usuario = new Usuario();
        usuario.setNome("Rodrigo");
        usuario.setSobreNome("Matos");
        usuario.setIdade(35);

        usuarios.push().setValue(usuario);*/

        //Filtro de usuarios
        //DatabaseReference usuarioPesquisa = usuarios.child("-N_AlFzYFKvmcD4E0AIY");
        //Query usuarioPesquisa = usuarios.orderByChild("nome").equalTo("Maria");
        //Query usuarioPesquisa = usuarios.orderByKey().limitToFirst(2);
        //Query usuarioPesquisa = usuarios.orderByKey().limitToLast(2);

        //Usando maior ou igual
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(40);

        //Usando menor ou igual
        //Query usuarioPesquisa = usuarios.orderByChild("idade").endAt(22);

        //Usando o starAt e endAt
        //Query usuarioPesquisa = usuarios.orderByChild("idade").startAt(18).endAt(30);

        //Filtrar palavras
        Query usuarioPesquisa = usuarios.orderByChild("nome")
                .startAt("J").endAt("J" + "\uf8ff");

        usuarioPesquisa.addValueEventListener(new ValueEventListener() { //pode usar antes o child()
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                /*Usuario dadosUsuario = snapshot.getValue(Usuario.class);
                Log.i("Dados usuario", " nome: " + dadosUsuario.getNome() + " idade: " + dadosUsuario.getIdade());*/
                Log.i("Dados usuario", snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}