package com.example.frasesaleatoriaschucknorris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.frasesaleatoriaschucknorris.api.ListFrasesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FrasesViewModel(private val mRepository: ListFrasesRepository) : ViewModel() {
    private var _listFrasesDTO = MutableLiveData<List<ListFrasesDTO>>()
    val mListFrasesDTO: LiveData<List<ListFrasesDTO>> get() = _listFrasesDTO

    private var _valuefraseDTO = MutableLiveData<ListFrasesDTO>()
    val mValueFraseDTO: LiveData<ListFrasesDTO> get() = _valuefraseDTO


    private var _response = MutableLiveData<String>()
    val mResponse: LiveData<String> get() = _response

    fun getListFrases(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _listFrasesDTO.postValue(mRepository.responseArrayObject(query))
            } catch (e: Exception) {
                _response.postValue(e.message.toString())
            }
        }
    }

    fun getValueFrase(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _valuefraseDTO.postValue(mRepository.getValueFrase())
            } catch (e: Exception) {
                _response.postValue((e.message.toString()))
            }
        }
    }

}