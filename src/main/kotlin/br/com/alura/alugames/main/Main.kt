package br.com.alura.alugames.main

import br.com.alura.alugames.model.Jogo
import br.com.alura.alugames.service.ConsumoApi
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        val meuInfoJogo = buscaApi.buscaJogo(busca)

        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    }

    resultado.onFailure {
        println("br.com.alura.alugames.model.Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descricão personazada? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo.titulo
        }

        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso. ")
    }
}