package com.example.frasesaleatoriaschucknorris

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.frasesaleatoriaschucknorris.databinding.RecyclerViewListFrasesBinding

class ListFrasesAdapter(val mContext: Context, val aListFrases: List<ListFrasesDTO>) :
    RecyclerView.Adapter<ListFrasesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFrasesViewHolder {
        val lBinding =
            RecyclerViewListFrasesBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ListFrasesViewHolder(lBinding, mContext)
    }

    override fun onBindViewHolder(holder: ListFrasesViewHolder, position: Int) {
        holder.fill(aListFrases[position])

    }

    override fun getItemCount(): Int {
        return aListFrases.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}