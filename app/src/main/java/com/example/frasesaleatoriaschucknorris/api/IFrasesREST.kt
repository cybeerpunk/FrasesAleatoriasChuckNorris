package com.example.frasesaleatoriaschucknorris.api


import com.example.frasesaleatoriaschucknorris.ListFrasesDTO
import com.example.frasesaleatoriaschucknorris.ObjectListDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IFrasesREST {
    @GET("https://api.chucknorris.io/jokes/search/")
    fun getListFrases(
        @Query("query") query: String?
    ): Call<ObjectListDTO>

    @GET ("https://api.chucknorris.io/jokes/random/")
    fun getValueFrase(
    ): Call<ListFrasesDTO>
}

