package br.com.alura.alugames.main

import br.com.alura.alugames.service.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamer()
    val jogoApi = consumo.buscaJogo("151")

    println(listaGamers)
    println(jogoApi)
}