package com.example.frasesaleatoriaschucknorris.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class FrasesHTTP {

    public static Retrofit create() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.chucknorris.io/jokes/search/")
                .build();

    }
}