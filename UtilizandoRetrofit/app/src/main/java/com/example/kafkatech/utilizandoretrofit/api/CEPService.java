package com.example.kafkatech.utilizandoretrofit.api;

import com.example.kafkatech.utilizandoretrofit.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

    @GET("{cep}/json/")
    public Call<CEP> recuperarCep(@Path("cep") String cep);
}
