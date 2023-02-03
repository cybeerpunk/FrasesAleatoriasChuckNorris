package com.example.frasesaleatoriaschucknorris


import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.frasesaleatoriaschucknorris.databinding.RecyclerViewListFrasesBinding

class ListFrasesViewHolder(
    val mBinding: RecyclerViewListFrasesBinding,
    val mContext: Context
    ) : RecyclerView.ViewHolder(mBinding.root) {

    fun fill(aDTO: ListFrasesDTO) {
        try {
           // mBinding.textViewId.setText(aDTO.id.toString())
           // mBinding.textViewValue.setText(aDTO.value.toString())
            mBinding.textViewValue.setText("Informado")
            //   mBinding.imageViewIdUrl.loadUrl(aDTO.icon_url)


        } catch (e: Exception){
            Toast.makeText(mContext, e.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }


}

