package com.example.frasesaleatoriaschucknorris

import com.example.frasesaleatoriaschucknorris.api.BaseREST
import com.example.frasesaleatoriaschucknorris.api.IFrasesREST
import retrofit2.Call

class FrasesREST : BaseREST<IFrasesREST>(IFrasesREST::class.java){
    fun getListFrases(query: String): Call<ObjectListDTO> {
        return service.getListFrases(query)
    }
    fun getValueFrase(): Call<ListFrasesDTO>{
        return service.getValueFrase()
    }
}