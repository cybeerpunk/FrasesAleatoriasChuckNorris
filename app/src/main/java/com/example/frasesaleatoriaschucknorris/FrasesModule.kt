package com.example.frasesaleatoriaschucknorris

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