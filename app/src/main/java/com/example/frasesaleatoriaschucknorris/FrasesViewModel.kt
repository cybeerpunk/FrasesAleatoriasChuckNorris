package com.example.frasesaleatoriaschucknorris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frasesaleatoriaschucknorris.api.ListFrasesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FrasesViewModel(val mRepository: ListFrasesRepository) : ViewModel() {
    private var _listFrasesDTO = MutableLiveData <List<ListFrasesDTO>>()
    val mListFrasesDTO: LiveData<List<ListFrasesDTO>> get() = _listFrasesDTO

    private var _response = MutableLiveData<String>()
    val mResponse: LiveData<String> get() = _response

    fun getListFrases(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _listFrasesDTO.postValue(mRepository.getListFrases(query))
            } catch (e: Exception) {
                _response.postValue(e.message.toString())
            }
        }
    }

}