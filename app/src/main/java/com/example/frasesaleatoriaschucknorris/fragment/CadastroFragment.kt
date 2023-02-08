package com.example.frasesaleatoriaschucknorris.fragment

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.frasesaleatoriaschucknorris.MainActivity
import com.example.frasesaleatoriaschucknorris.R
import com.example.frasesaleatoriaschucknorris.databinding.FragmentCadastroBinding
import com.example.frasesaleatoriaschucknorris.framework.InputMask
import com.example.frasesaleatoriaschucknorris.framework.StringSpinnerAdapter
import com.example.frasesaleatoriaschucknorris.main.CadastroBO
import com.example.frasesaleatoriaschucknorris.main.FrasesCommons


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
        populateSpinner()
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

                if (mBinding.spinnerFamiliaridade.selectedItem.toString() == "Selecione a sua familiaridade:")
                    throw Exception("Informe sua categoria")

                if (mBinding.spinnerEscolaridade.selectedItem.toString() == "Selecione a sua escolaridade:")
                    throw Exception("Informe sua categoria")

//

                val lTitulo = "Cadastro validado"
                val lOpenIntent = Intent(context, MainActivity::class.java)
                lOpenIntent.putExtra("openIntent", 1)
                lOpenIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                val lPendingIntent =
                    PendingIntent.getActivity(
                        context,
                        0,
                        lOpenIntent,
                        PendingIntent.FLAG_IMMUTABLE
                    )
                val lBuilder: Notification.Builder
                val lIdChannel = "i.apps.notifications"
                val lNotificationChannel: NotificationChannel
                val lDescription = "notification"
                val lNotificationManager: NotificationManager = activity?.getSystemService(
                    Context.NOTIFICATION_SERVICE
                ) as NotificationManager
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    lNotificationChannel = NotificationChannel(
                        lIdChannel,
                        lDescription,
                        NotificationManager.IMPORTANCE_HIGH
                    )
                    lNotificationChannel.enableLights(true)
                    lNotificationManager.createNotificationChannel(lNotificationChannel)

                    lBuilder = Notification.Builder(requireContext(), lIdChannel)
                        .setContentTitle(lTitulo)
                        .setOngoing(true)
                        .setSmallIcon(R.drawable.ic_baseline_check)
                        .setContentIntent(lPendingIntent)
                } else {
                    lBuilder = Notification.Builder(requireContext())
                        .setContentTitle(lTitulo)
                        .setOngoing(true)
                        .setSmallIcon(R.drawable.ic_baseline_check)
                        .setContentIntent(lPendingIntent)
                }
                lNotificationManager.notify(123, lBuilder.build())

            } catch (e: Exception) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun populateSpinner() {
        val lAdapterFamiliaridade: List<String> = FrasesCommons.getListFamiliaridade()
        val lSetAdapter =
            StringSpinnerAdapter(
                requireContext(),
                R.id.textViewBasicStringItem,
                lAdapterFamiliaridade
            )

        val lAdapterEscolaridade: List<String> = FrasesCommons.getListEscolaridade()
        val lSetEscolaridadeAdapter =
            StringSpinnerAdapter(
                requireContext(),
                R.id.textViewBasicStringItem,
                lAdapterEscolaridade
            )


        mBinding.spinnerFamiliaridade.adapter = lSetAdapter
        mBinding.spinnerEscolaridade.adapter = lSetEscolaridadeAdapter
    }


}