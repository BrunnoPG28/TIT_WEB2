package com.example.spotifyclone.Model

import com.google.gson.annotations.SerializedName

data class Categoria(
    @SerializedName("titulo")
    var titulo : String ="",

    @SerializedName("albuns")
    var albuns : List<Album> = arrayListOf()
)