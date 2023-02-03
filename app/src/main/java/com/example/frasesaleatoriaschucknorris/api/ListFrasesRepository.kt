package com.example.frasesaleatoriaschucknorris.api


import com.example.frasesaleatoriaschucknorris.FrasesREST
import com.example.frasesaleatoriaschucknorris.ListFrasesDTO
import com.example.frasesaleatoriaschucknorris.ObjectListDTO
import com.example.frasesaleatoriaschucknorris.exception.FrasesException


class ListFrasesRepository {


    fun getListFrases(query: String): ObjectListDTO  {
    val response = FrasesREST()
        .getListFrases(query)
        .execute()
    if (response.code() != 200 && response.code() != 201)
        throw FrasesException.fromHTTPErrorBody(response.errorBody())
    return response.body()!!
}

    fun responseArrayObject(query: String) : List<ListFrasesDTO> {
        val response = getListFrases(query)
        val array : ArrayList<ListFrasesDTO> = ArrayList()
        if(response.result.isNotEmpty()){
            for (size in response.result){
                array.add(size)
            }
        }
        return array
    }

    fun getValueFrase(): ListFrasesDTO {
        val response = FrasesREST()
            .getValueFrase()
            .execute()
        if (response.code() != 200 && response.code() != 201)
            throw FrasesException.fromHTTPErrorBody(response.errorBody())
        return response.body()!!
    }
}