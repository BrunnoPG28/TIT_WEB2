package com.example.spotifyclone.Model

import com.google.gson.annotations.SerializedName

data class ListaCategorias(@SerializedName("categoria")
        val categorias : List<Categoria>
)