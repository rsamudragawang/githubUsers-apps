package com.ganargatul.githubuser.connection

import com.ganargatul.githubuser.model.Users
import com.ganargatul.githubuser.model.UsersDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {
    @GET("users")
    fun getUsers(): Call<List<Users>>
    @GET
    fun getRepos(@Url url: String): Call<Users>

    @GET
    fun getDetail(@Url url: String): Call<UsersDetail>
}