package com.example.frasesaleatoriaschucknorris

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frasesaleatoriaschucknorris.databinding.FragmentListFrasesBinding


class ListFrasesFragment : Fragment() {
    lateinit var mBinding: FragmentListFrasesBinding
    lateinit var mAdapter: ListFrasesAdapter
    private var mListFrasesDTO: List<ListFrasesDTO> = emptyList()
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mParent: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentListFrasesBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getListFrases()
        searchFrases()


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) this.mParent = context



    }

    fun setupAdapter() {
        try {
            mLinearLayoutManager = LinearLayoutManager(requireContext())
            mAdapter = ListFrasesAdapter(requireContext(), mListFrasesDTO)
            mBinding.recycleViewListFrases.layoutManager = mLinearLayoutManager
            mBinding.recycleViewListFrases.adapter = mAdapter

        } catch (e: Exception) {
            Toast.makeText((requireContext()), e.message.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    fun getListFrases() {
        mParent.mModel.mListFrasesDTO.observe(viewLifecycleOwner) {
            mListFrasesDTO = it
            mBinding.recycleViewListFrases.visibility = View.VISIBLE
            setupAdapter()
        }
    }

    fun searchFrases(){
        mBinding.buttonSeach.setOnClickListener{
            if (mBinding.editTextFilter.text.isNotEmpty()){
                mParent.mModel.getListFrases(mBinding.editTextFilter.text.toString())

            }else {
                Toast.makeText(requireContext(), "Informe uma palavra para a busca de frases!", Toast.LENGTH_SHORT).show()
            }

        }
    }

}
