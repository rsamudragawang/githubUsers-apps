package com.ganargatul.githubuser.view.main

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganargatul.githubuser.connection.RetroConfig
import com.ganargatul.githubuser.model.Users
import retrofit2.Call
import retrofit2.Response

class MainViewModel () : ViewModel(){
    private  var listUsers : MutableLiveData<List<Users>> = MutableLiveData()

    fun loadData(){
        d("viewmodel", "viewmodel")
        RetroConfig().services.getUsers().enqueue(object : retrofit2.Callback<List<Users>>{
            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                d("error",t.message!!)
            }

            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful){
                    response.body().let { listUsers.postValue(it) }
                }
            }

        })
    }
    val listData: LiveData<List<Users>> = listUsers

}