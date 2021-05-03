package com.example.bingoalfabetico

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(var listener: ClickItemMenuListener) : RecyclerView.Adapter<HomeAdapter.HomeAdapterViewholder>(){

    private val list: MutableList<HomeMenu> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.homemenu_item, parent, false)
        return HomeAdapterViewholder(view, list, listener)
    }

    override fun onBindViewHolder(holder: HomeAdapterViewholder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list: List<HomeMenu>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class HomeAdapterViewholder(
        itemView: View,
        var list: List<HomeMenu>,
        var listener: ClickItemMenuListener
        ): RecyclerView.ViewHolder(itemView){
        private val tvName: TextView = itemView.findViewById(R.id.tv_homeMenu)
        private val ivMenu: ImageView = itemView.findViewById(R.id.iv_homeMenu)

        init {
            itemView.setOnClickListener{
                listener.clickItemMenu(list[adapterPosition])
            }
        }

        fun bind(homeMenu: HomeMenu) {
            tvName.text = homeMenu.name
            ivMenu.setImageResource(homeMenu.image)
        }
    }
}