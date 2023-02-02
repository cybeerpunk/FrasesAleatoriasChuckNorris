package com.example.frasesaleatoriaschucknorris.api


import com.example.frasesaleatoriaschucknorris.FrasesREST
import com.example.frasesaleatoriaschucknorris.ListFrasesDTO
import com.example.frasesaleatoriaschucknorris.ObjectListDTO
import com.example.frasesaleatoriaschucknorris.exception.FrasesException
import java.util.Objects

class ListFrasesRepository {
    fun getListFrases(query: String): List<ListFrasesDTO>  {
    val response = FrasesREST()
        .getListFrases(query)
        .execute()
    if (response.code() != 200 && response.code() != 201)
        throw FrasesException.fromHTTPErrorBody(response.errorBody())
    return response.body()!!
}
}