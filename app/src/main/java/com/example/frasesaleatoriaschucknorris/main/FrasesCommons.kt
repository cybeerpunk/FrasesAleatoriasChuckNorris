package com.example.frasesaleatoriaschucknorris.main

object FrasesCommons {
     fun  getListFamiliaridade(): List<String>{
        val list:  ArrayList<String> = ArrayList()
        list.add("Selecione a sua familiaridade:")
        list.add("Tio")
        list.add("Tia")
        list.add("Mãe")
        list.add("Pai")
        list.add("Avó")
        list.add("Avô")
        list.add("Irmão")
        list.add("Irmã")

        return list

    }

   fun getListEscolaridade(): List<String>{
      val list: ArrayList<String> = ArrayList()
      list.add("Selecione a sua escolaridade")
      list.add("Ensino Fundamental")
      list.add("Ensino Médio")
      list.add("Ensino Superior")
      list.add("Ensino Técnico")
      list.add("Mestrado")
      list.add("Doutorado")

         return list

   }

}

