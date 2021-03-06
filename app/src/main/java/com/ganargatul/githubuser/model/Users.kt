package com.ganargatul.githubuser.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Users(
    @SerializedName("login")
    val login : String?,
    @SerializedName("avatar_url")
    val avatar_url : String?
) : Parcelable