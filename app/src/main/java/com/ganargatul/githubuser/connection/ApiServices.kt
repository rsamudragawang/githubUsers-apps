package com.ganargatul.githubuser.connection

import com.ganargatul.githubuser.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {
    @GET
    fun getUsers(@Url url: String?): Call<List<Users>?>?
}