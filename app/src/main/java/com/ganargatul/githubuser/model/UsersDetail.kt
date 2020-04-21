package com.ganargatul.githubuser.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsersDetail(
    @SerializedName("login")
    val login: String?,
    @SerializedName("avatar_url")
    val avatar_url : String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("location")
    val localtion : String?,
    @SerializedName("public_repos")
    val public_repos : String?
): Parcelable