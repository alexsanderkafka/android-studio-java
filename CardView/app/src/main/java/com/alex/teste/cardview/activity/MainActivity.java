package com.alex.teste.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.alex.teste.cardview.R;
import com.alex.teste.cardview.adapter.PostagemAdapter;
import com.alex.teste.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Postagem> postagens = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Define layout
        //RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        //Define o adapter
        preparaPostagens();
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerView.setAdapter(adapter);
    }

    public void preparaPostagens(){
        Postagem p = new Postagem("Alex Silva", "#tbt viagem legal", R.drawable.imagem1);
        this.postagens.add(p);

        p = new Postagem("Alex Mcqueen", "O mundo é louco", R.drawable.imagem2);
        this.postagens.add(p);

        p = new Postagem("Alex Small", "A morena gostou", R.drawable.imagem3);
        this.postagens.add(p);

        p = new Postagem("Alex Big Tall", "Quase fiquei no meio do mato", R.drawable.imagem4);
        this.postagens.add(p);

    }
}