package com.example.frasesaleatoriaschucknorris


import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.frasesaleatoriaschucknorris.databinding.RecyclerViewListFrasesBinding
import org.koin.java.KoinJavaComponent

class ListFrasesViewHolder(
    val mBinding: RecyclerViewListFrasesBinding,
    val mContext: Context
) : RecyclerView.ViewHolder(mBinding.root) {
    val mBroadCast: BroadcastFrasesNorris by KoinJavaComponent.inject(BroadcastFrasesNorris::class.java)

    fun fill(aDTO: ListFrasesDTO) {
        try {

            mBinding.textViewId.setText(aDTO.id)
            mBinding.textViewValue.setText(aDTO.value)
            mBinding.imageViewIdUrl.webViewClient = WebViewClient()
            mBinding.imageViewIdUrl.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    return super.shouldOverrideUrlLoading(view, request)
                }

                override fun onReceivedError(
                    view: WebView?,
                    errorCode: Int,
                    description: String?,
                    failingUrl: String?
                ) {
                    Toast.makeText(mContext, description, Toast.LENGTH_SHORT).show()
                }


            }

            mBinding.imageViewIdUrl.loadUrl("https://upload.wikimedia.org/wikipedia/commons/6/64/Collage_of_Six_Cats-02.jpg")


            setBroadCastFrases(aDTO)

        } catch (e: Exception) {
            Toast.makeText(mContext, e.message.toString(), Toast.LENGTH_SHORT).show()

        }
    }

    fun setBroadCastFrases(aFrasesDTO: ListFrasesDTO) {
        mBinding.cardViewFrases.setOnClickListener {
            mBroadCast.emitiBroadCastGetFrasesDTO(aFrasesDTO)
        }
    }


}

