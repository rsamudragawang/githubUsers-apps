package com.ganargatul.githubuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ganargatul.githubuser.R
import com.ganargatul.githubuser.model.Users
import com.squareup.picasso.Picasso

class AdapterUsers (private  val context: Context, private val items: List<Users>, private val listener: (Users) -> Unit): RecyclerView.Adapter<AdapterUsers.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val name = view.findViewById<TextView>(R.id.title_items)
        private val avatar = view.findViewById<ImageView>(R.id.image_items)
        fun bindItem(items: Users, listener: (Users) -> Unit){
            name.text = items.login
            Picasso.get().load(items.avatar_url).into(avatar)
            itemView.setOnClickListener { listener(items) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_items,parent,false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }
}