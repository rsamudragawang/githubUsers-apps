package com.ganargatul.githubuser.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("login")
    val login : String?,
    @SerializedName("avatar_url")
    val avatar_url : String?
)