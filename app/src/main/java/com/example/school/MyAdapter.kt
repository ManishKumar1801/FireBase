package com.example.school

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val studentList:ArrayList<Detail>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=studentList[position]
        holder.image.setImageResource(currentItem.Image)
        holder.classname.text=currentItem.classname
        holder.phoneNumber.text=currentItem.phone
        holder.name.text=currentItem.name
        holder.status.text=currentItem.status
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
      val image:ImageView=itemView.findViewById(R.id.Image)
      val classname:TextView=itemView.findViewById(R.id.className)
      val phoneNumber:TextView=itemView.findViewById(R.id.phoneNumber)
      val name:TextView=itemView.findViewById(R.id.studentName)
      val status:TextView=itemView.findViewById(R.id.status)
    }

}