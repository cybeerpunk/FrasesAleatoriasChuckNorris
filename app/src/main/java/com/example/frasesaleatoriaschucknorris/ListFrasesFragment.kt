package com.example.frasesaleatoriaschucknorris

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.frasesaleatoriaschucknorris.databinding.FragmentListFrasesBinding
import com.google.gson.Gson


class ListFrasesFragment : Fragment() {
    lateinit var mBinding: FragmentListFrasesBinding
    lateinit var mAdapter: ListFrasesAdapter
    private var mListFrasesDTO: List<ListFrasesDTO> = emptyList()
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mParent: MainActivity
    private var mFrasesDTO: ListFrasesDTO = ListFrasesDTO()
    private val mBroadCast = GetBroadCastFrases()


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
        getValueFrase()
        registerBroadCast()
        setClickNextPage()


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
            //  mBinding.recycleViewListFrases.visibility = View.VISIBLE
            setupAdapter()
        }
    }

    fun searchFrases() {
        mBinding.buttonSeach.setOnClickListener {
            if (mBinding.editTextFilter.text.isNotEmpty()) {
                mParent.mModel.getListFrases(mBinding.editTextFilter.text.toString())

            } else {
                Toast.makeText(
                    requireContext(),
                    "Informe uma palavra para a busca de frases!",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    fun getValueFrase() {
        mParent.mModel.mValueFraseDTO.observe(viewLifecycleOwner) {
            mBinding.textViewFraseAleatoria.text = it.value
        }
    }

   internal inner class GetBroadCastFrases: BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent?) {
            try {
                when (intent?.action) {
                    BroadcastFrasesNorris.getFrasesDTO -> {
                        mFrasesDTO = Gson().fromJson(
                            intent.getStringExtra("FrasesDTO"),
                            ListFrasesDTO::class.java
                        )
                        mBinding.recycleViewListFrases.visibility = View.GONE
                        mBinding.textViewIdDescricao.text = mFrasesDTO.id
                        mBinding.textViewIdDescricao.visibility = View.VISIBLE
                        mBinding.textViewFrase.text = mFrasesDTO.value
                        mBinding.textViewFrase.visibility = View.VISIBLE
                        mBinding.buttonNext.visibility = View.VISIBLE

                    }
                }
            }catch(e: Exception){
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()

            }
        }


    }

    private fun registerBroadCast (){
        val lIntent = IntentFilter()
        lIntent.addAction(BroadcastFrasesNorris.getFrasesDTO)
        requireContext().registerReceiver(mBroadCast, lIntent)


    }
    fun setClickNextPage(){
        mBinding.buttonNext.setOnClickListener {
            mParent.goToPage(1)
        }
    }

}
