package com.example.kafkatech.utilizandoretrofit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.kafkatech.utilizandoretrofit.api.CEPService;
import com.example.kafkatech.utilizandoretrofit.api.DataService;
import com.example.kafkatech.utilizandoretrofit.model.CEP;
import com.example.kafkatech.utilizandoretrofit.model.Photo;
import com.example.kafkatech.utilizandoretrofit.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button recuperar;
    private TextView resultado;
    private Retrofit retrofit;
    private List<Photo> listaPhoto = new ArrayList<>();
    private List<Post> listaPost = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recuperar = findViewById(R.id.buttonBuscar);
        resultado = findViewById(R.id.textResultado);
        retrofit = new Retrofit.Builder()
                //.baseUrl("https://viacep.com.br/ws/")
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recuperarCepRetrofit();
                //recuperarList();
                salvarPost();
            }
        });
    }

    private void salvarPost() {
       //Post post = new Post("1234", "Título postagem", "Corpo postagem");

        DataService dataService = retrofit.create(DataService.class);
        Call<Post> call = dataService.salvarUmaPostagem("1234", "Título postagem", "Corpo postagem");

        call.enqueue(new Callback<Post>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Post postReposta = response.body();
                    resultado.setText("Código: " + response.code()+
                                      " id: " + postReposta.getId() +
                                      " titulo: " + postReposta.getTitle());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void recuperarList(){
        DataService dataService = retrofit.create(DataService.class);
        /*Call<List<Photo>> call = dataService.recuperarFotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if(response.isSuccessful()){
                    listaPhoto = response.body();

                    for(int i=0; i < listaPhoto.size(); i++){
                        Photo photo = listaPhoto.get(i);
                        Log.d("resultado", "Resultado: " + photo.getId() + " / " + photo.getTitle());
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {

            }
        });*/

        Call<List<Post>> call = dataService.recuperarPostagens();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(@NonNull Call<List<Post>> call, Response<List<Post>> response) {
                if(response.isSuccessful()){
                    listaPost = response.body();
                    for(int i = 0; i < listaPost.size(); i++){
                        Post post = listaPost.get(i);
                        Log.d("resultado", "Resultado: " + post.getId() + " / " + post.getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

    }

    private void recuperarCepRetrofit(){
        CEPService cepService = retrofit.create(CEPService.class);
        Call<CEP> call = cepService.recuperarCep("01001000");
        call.enqueue(new Callback<CEP>() {
            @Override
            public void onResponse(Call<CEP> call, Response<CEP> response) {
                if(response.isSuccessful()){
                    CEP cep = response.body();
                    resultado.setText(cep.getLogradouro() + " / " + cep.getBairro());
                }
            }

            @Override
            public void onFailure(Call<CEP> call, Throwable t) {

            }
        });
    }
}