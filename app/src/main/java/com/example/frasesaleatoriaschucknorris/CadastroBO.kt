package com.example.frasesaleatoriaschucknorris

object CadastroBO {
    fun checkCadastroInformation(aNome: String, aSobrenome: String, aTelefone: String, aEmail: String, aCPF: String){
        if(aNome.isNullOrEmpty()) throw Exception("Campo nome está vazio!")
        if(aSobrenome.isNullOrEmpty()) throw Exception("Campo sobrenome está vazio!")
        if(aTelefone.isNullOrEmpty()) throw Exception("Campo telefone está vazio!")
        if(aTelefone.length != 11) throw Exception("Campo telefone está incorreto!")
        if(aCPF.isNullOrEmpty()) throw Exception("Campo CPF está vazio!")
        if(aCPF.length != 11) throw Exception("Campo CPF está incorreto!")
        if(aEmail.isNullOrEmpty()) throw Exception("Campo E-mail está vazio!")

    }
}