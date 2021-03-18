package com.example.spotifyclone.API

import com.example.spotifyclone.Model.Secao
import com.example.spotifyclone.R

class SecaoBuilder {
    var secao : Int = 0
    var nomeSecao : String = ""

    fun build() : Secao = Secao(secao, nomeSecao)
}

fun secaao(block : SecaoBuilder.()-> Unit) : Secao = SecaoBuilder().apply(block).build()

fun dados() : MutableList<Secao> = mutableListOf(
    secaao {
        secao = R.drawable.secao1
        nomeSecao = "Podcasts"
    },
    secaao {
        secao = R.drawable.secao2
        nomeSecao = "Lançamentos"
    },
    secaao {
        secao = R.drawable.secao4
        nomeSecao = "Em casa"
    },
    secaao {
        secao = R.drawable.secao1
        nomeSecao = "Paradas"
    },
    secaao {
        secao = R.drawable.secao3
        nomeSecao = "Shows"
    },
    secaao {
        secao = R.drawable.secao4
        nomeSecao = "Made for You"
    },
    secaao {
        secao = R.drawable.secao3
        nomeSecao = "Brasil"
    },
    secaao {
        secao = R.drawable.secao2
        nomeSecao = "Funk"
    }
)