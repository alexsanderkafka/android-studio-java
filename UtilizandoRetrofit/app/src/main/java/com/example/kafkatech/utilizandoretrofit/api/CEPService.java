package com.example.kafkatech.utilizandoretrofit.api;

import com.example.kafkatech.utilizandoretrofit.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CEPService {
    @GET("01001000/json/")
    public Call<CEP> recuperarCEP();

}
