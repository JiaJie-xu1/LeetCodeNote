package com.univers.paging3.model

import com.google.gson.annotations.SerializedName

class Repo{
    @SerializedName("id") val id: Int? = null
    @SerializedName("name") val name: String? = null
    @SerializedName("description") val description: String? = null
    @SerializedName("stargazers_count") val starCount: Int? = null
}