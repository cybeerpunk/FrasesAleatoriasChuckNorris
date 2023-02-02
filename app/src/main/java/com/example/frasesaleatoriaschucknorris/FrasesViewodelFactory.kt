package com.example.frasesaleatoriaschucknorris

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.frasesaleatoriaschucknorris.api.ListFrasesRepository

class FrasesViewodelFactory constructor(private val repository: ListFrasesRepository) :
        ViewModelProvider.Factory{
            override fun<T : ViewModel> create(modelClass: Class<T>): T{
                if (modelClass.isAssignableFrom(FrasesViewModel::class.java)){
                    return FrasesViewModel(repository) as T
                }else{
                    throw java.lang.IllegalArgumentException("ViewMoel Not Found!")
                }
            }
}