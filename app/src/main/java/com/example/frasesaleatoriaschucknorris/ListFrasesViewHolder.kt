package com.example.frasesaleatoriaschucknorris


import androidx.recyclerview.widget.RecyclerView
import com.example.frasesaleatoriaschucknorris.databinding.RecyclerViewListFrasesBinding

class ListFrasesViewHolder(
    val mBinding: RecyclerViewListFrasesBinding,
    ) : RecyclerView.ViewHolder(mBinding.root) {

    fun fill(aDTO: ListFrasesDTO) {
        mBinding.textViewId.text = aDTO.id
        mBinding.textViewValue.text = aDTO.value
        mBinding.imageViewIdUrl.loadUrl(aDTO.icon_url)


    }


}

