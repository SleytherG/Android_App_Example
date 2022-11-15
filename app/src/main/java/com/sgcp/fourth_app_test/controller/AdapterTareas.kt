package com.sgcp.fourth_app_test.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sgcp.fourth_app_test.R
import com.sgcp.fourth_app_test.data.Tarea

class AdapterTareas(private val tareasList: ArrayList<Tarea>): RecyclerView.Adapter<AdapterTareas.ViewHolder>() {

    lateinit var context: Context;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_tareas_list, parent, false);
        return ViewHolder(itemView);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarea = tareasList[position];
        holder.idTarea = tarea.id;
        holder.tareaName.text = tarea.name;
        holder.tareaDesc.text = tarea.desc;
        holder.tareaImg.setImageResource(tarea.image);
        holder.tareaUser = tarea.user;
    }

    override fun getItemCount(): Int {
        return tareasList.size;

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var idTarea : Int = 0;
        var tareaName: TextView = itemView.findViewById(R.id.tv_name_tarea);
        var tareaDesc: TextView = itemView.findViewById(R.id.tv_desc_tarea);
        var tareaImg: ImageView = itemView.findViewById(R.id.iv_tarea);
        var tareaUser: Int = 0;
    }
}