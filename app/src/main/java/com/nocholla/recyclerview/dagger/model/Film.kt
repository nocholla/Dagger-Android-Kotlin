package com.nocholla.recyclerview.dagger.model

import com.google.gson.annotations.SerializedName

class Film {
    @SerializedName("title")
    var title: String? = null
    @SerializedName("director")
    var director: String? = null
}