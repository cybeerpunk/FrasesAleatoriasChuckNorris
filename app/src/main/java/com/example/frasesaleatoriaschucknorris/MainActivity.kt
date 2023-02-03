package com.example.frasesaleatoriaschucknorris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.frasesaleatoriaschucknorris.api.ListFrasesRepository
import com.example.frasesaleatoriaschucknorris.databinding.ActivityMainBinding
import com.example.frasesaleatoriaschucknorris.framework.ScreenSlidePagerAdapter

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    lateinit var mModel: FrasesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mModel = ViewModelProvider(
            this,
            FrasesViewodelFactory(ListFrasesRepository())
        )[FrasesViewModel::class.java]

        mModel.getValueFrase()
        setAdapterFragment()
        catchErrorMessege()


    }

    fun setAdapterFragment(){
        val lAdapter = ScreenSlidePagerAdapter(supportFragmentManager, lifecycle)
        lAdapter.addFragment(ListFrasesFragment())
        mBinding.viewPagerMain.adapter = lAdapter
    }

    fun catchErrorMessege(){
        mModel.mResponse.observe(this){
            Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
        }
    }
}