package com.example.frasesaleatoriaschucknorris

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.frasesaleatoriaschucknorris.databinding.FragmentCadastroBinding


class CadastroFragment : Fragment() {

    lateinit var mBinding: FragmentCadastroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentCadastroBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMasks()
        setClickButtonNext()
    }

    fun addMasks() {
        mBinding.editTextTextTelefone.addTextChangedListener(
            InputMask(
                mBinding.editTextTextTelefone,
                "(##) #####-####"
            )
        )
        mBinding.editTextTextCpf.addTextChangedListener(
            InputMask(
                mBinding.editTextTextCpf,
                "###.###.###-##"
            )
        )
    }

    fun setClickButtonNext() {
        mBinding.buttonOk.setOnClickListener {
            try {
                CadastroBO.checkCadastroInformation(
                    mBinding.editTextTextNome.text.toString(),
                    mBinding.editTextTextSobrenome.text.toString(),
                    mBinding.editTextTextTelefone.text.toString().replace("(", "").replace(")", "")
                        .replace(" ", "").replace("-", ""),
                    mBinding.editTextTextEmail.text.toString(),
                    mBinding.editTextTextCpf.text.toString().replace(".", "").replace("-", "")

                )
                Toast.makeText(
                    requireContext(),
                    mBinding.editTextTextCpf.text.toString().replace(".", "").replace("-", ""),
                    Toast.LENGTH_SHORT
                ).show()
                Toast.makeText(
                    requireContext(),
                    mBinding.editTextTextTelefone.text.toString().replace("(", "").replace(")", "")
                        .replace(" ", "").replace("-", ""),
                    Toast.LENGTH_SHORT
                ).show()

            } catch (e: Exception) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()

            }
        }
    }


}