package com.alex.teste.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.alex.teste.recyclerview.R;
import com.alex.teste.recyclerview.activity.adapter.Adapter;
import com.alex.teste.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listagem de filmes
        criarFilmes();

        //Configura adapter
        Adapter adapter = new Adapter(listFilmes);

        //Configura Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public void criarFilmes(){
        Filme filme = new Filme("Homem Aranha - De volta ao lar", "Aventura", "2017");
        listFilmes.add(filme);

        filme = new Filme("Mulher Maravilha", "Fantasia", "2017");
        listFilmes.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        listFilmes.add(filme);

        filme = new Filme("Capitão América - guerra Civíl", "Aventura/Ficção", "2016");
        listFilmes.add(filme);

        filme = new Filme("It: A Coisa", "Drama/Terror", "2017");
        listFilmes.add(filme);

        filme = new Filme("Pica-Pau", "Comédia/Animação", "2017");
        listFilmes.add(filme);

        filme = new Filme("A Múmia", "Terror", "2017");
        listFilmes.add(filme);

        filme = new Filme("A Bela e a Fera", "Romance", "2017");
        listFilmes.add(filme);

        filme = new Filme("Meu malvado favorito 3", "Comédia", "2017");
        listFilmes.add(filme);

        filme = new Filme("Carros 3", "Comédia", "2017");
        listFilmes.add(filme);

    }
}