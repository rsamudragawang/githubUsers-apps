package com.ganargatul.githubuser.view.detail

import android.os.Bundle
import android.util.Log.d
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ganargatul.githubuser.R
import com.ganargatul.githubuser.model.Users
import com.ganargatul.githubuser.model.UsersDetail
import com.ganargatul.githubuser.view.main.MainViewModel

class DetailUsers : AppCompatActivity() {
    lateinit var detailUserViewModel: DetailUserViewModel
    lateinit var items : Users
    lateinit var avatar : ImageView
    lateinit var username : TextView
    lateinit var name : TextView
//    lateinit var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_users)
        init()
    }

    private fun init() {
        items= intent.getParcelableExtra("Data")!!
        d("items",items.login!!)

        detailUserViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            DetailUserViewModel::class.java)
        detailUserViewModel.loadData(items.login!!)
        detailUserViewModel.listData.observe(this, Observer { userDetail -> showItems(userDetail)})
    }

    private fun showItems(userDetail: UsersDetail?) {
        d("data",userDetail!!.name!!)

    }
}