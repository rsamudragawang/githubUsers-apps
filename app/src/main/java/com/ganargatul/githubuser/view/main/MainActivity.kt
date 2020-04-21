package com.ganargatul.githubuser.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ganargatul.githubuser.R
import com.ganargatul.githubuser.adapter.AdapterUsers
import com.ganargatul.githubuser.model.Users

class MainActivity : AppCompatActivity() {
    lateinit var recyclerview: RecyclerView
    lateinit var adapter: AdapterUsers
    lateinit var mainViewModel: MainViewModel
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar= findViewById(R.id.pb_main)
        progressBar.visibility = View.VISIBLE
        recyclerview= findViewById(R.id.rv_users)
        recyclerview.layoutManager= LinearLayoutManager(baseContext)
        init()
    }

    private fun init() {
        mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)
        mainViewModel.loadData()
        mainViewModel.listData.observe(this, Observer { users -> showItems(users) })
    }

    private fun showItems(users: List<Users>) {
        progressBar.visibility = View.GONE
        adapter= AdapterUsers(baseContext,users){
            val nowItems =Users(it.login,it.avatar_url)
//            startActivity<DetailPastEvent>("Data" to nowItems)
        }

        recyclerview.adapter = adapter
    }
}
