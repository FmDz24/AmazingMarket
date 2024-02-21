package com.example.kotlinreg

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items: List<Item>, var context: Context) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val title: TextView = view.findViewById(R.id.item_list_title)
        val desk: TextView = view.findViewById(R.id.item_list_desk)
        val price: TextView = view.findViewById(R.id.item_list_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.style_1, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.desk.text = items[position].desc
        holder.price.text = items[position].price.toString()

    }
}