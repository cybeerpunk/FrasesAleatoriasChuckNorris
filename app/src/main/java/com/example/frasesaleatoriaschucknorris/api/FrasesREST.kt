package com.example.frasesaleatoriaschucknorris.api

import com.example.frasesaleatoriaschucknorris.dto.ListFrasesDTO
import com.example.frasesaleatoriaschucknorris.dto.ObjectListDTO
import retrofit2.Call

class FrasesREST : BaseREST<IFrasesREST>(IFrasesREST::class.java){
    fun getListFrases(query: String): Call<ObjectListDTO> {
        return service.getListFrases(query)
    }
    fun getValueFrase(): Call<ListFrasesDTO>{
        return service.getValueFrase()
    }
}