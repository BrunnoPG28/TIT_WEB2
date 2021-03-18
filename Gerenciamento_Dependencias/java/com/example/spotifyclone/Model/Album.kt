package com.example.spotifyclone.Model

import com.google.gson.annotations.SerializedName

data class Album (
    @SerializedName("url_imagem")
    var album  : String = "",

    @SerializedName("id")
    var id : Int = 0
    )