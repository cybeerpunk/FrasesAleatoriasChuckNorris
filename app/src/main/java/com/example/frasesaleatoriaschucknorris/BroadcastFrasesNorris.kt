package com.example.frasesaleatoriaschucknorris

import android.content.Context
import android.content.Intent
import com.google.gson.Gson

class BroadcastFrasesNorris(val mContext: Context) {
    companion object{
        const val getFrasesDTO = "com.example.frasesaleatoriaschucknorris.getFrasesDTO"
    }

    fun emitiBroadCastGetFrasesDTO(aFrasesDTO: ListFrasesDTO){
        val lIntent = Intent()
        lIntent.action = getFrasesDTO
        lIntent.putExtra("FrasesDTO", Gson().toJson(aFrasesDTO))
        mContext.sendBroadcast(lIntent)
    }

}