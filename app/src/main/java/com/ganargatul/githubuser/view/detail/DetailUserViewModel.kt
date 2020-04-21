package com.ganargatul.githubuser.view.detail

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ganargatul.githubuser.connection.RetroConfig
import com.ganargatul.githubuser.model.Users
import com.ganargatul.githubuser.model.UsersDetail
import retrofit2.Call
import retrofit2.Response

class DetailUserViewModel : ViewModel(){
    private  var listUsers : MutableLiveData<UsersDetail> = MutableLiveData()

    fun loadData(username : String){
        RetroConfig().services.getDetail("users/$username").enqueue(object : retrofit2.Callback<UsersDetail>{
            override fun onFailure(call: Call<UsersDetail>, t: Throwable) {
                d("error",t.message!!)
            }

            override fun onResponse(call: Call<UsersDetail>, response: Response<UsersDetail>) {
                if (response.isSuccessful){
                    listUsers.postValue(response.body())
                }
            }

        })
    }
    val listData: LiveData<UsersDetail> = listUsers
}