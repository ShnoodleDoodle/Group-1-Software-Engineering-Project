package com.example.v2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(private val context: Context, private var dataList: List<DataClass>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(dataList[position].Image)
            .into(holder.recImage)
        holder.recResident.text = dataList[position].Resident
        holder.recAge.text = dataList[position].Age


        holder.recCard.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("Image", dataList[holder.adapterPosition].Image)
            intent.putExtra("Resident", dataList[holder.adapterPosition].Resident)
            intent.putExtra("Age", dataList[holder.adapterPosition].Age)
            intent.putExtra("Description", dataList[holder.adapterPosition].Desc)
            intent.putExtra("Medication", dataList[holder.adapterPosition].Medication)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    fun searchDataList(searchList: List<DataClass>) {
        dataList = searchList
        notifyDataSetChanged()
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var recImage: ImageView
    var recResident: TextView
    var recAge: TextView
    var recCard: CardView


    init {
        recImage = itemView.findViewById(R.id.recImage)
        recResident = itemView.findViewById(R.id.recResident)
        recAge = itemView.findViewById(R.id.recAge)
        recCard = itemView.findViewById(R.id.recCard)
    }
}