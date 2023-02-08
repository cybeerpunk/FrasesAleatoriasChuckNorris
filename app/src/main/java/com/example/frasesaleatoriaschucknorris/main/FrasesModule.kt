package com.example.frasesaleatoriaschucknorris.main

import com.example.frasesaleatoriaschucknorris.broadcast.BroadcastFrasesNorris
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val frasesModule = module {
    factory {
        BroadcastFrasesNorris(get())
    }
    viewModel {
        FrasesViewModel(get())
    }
}