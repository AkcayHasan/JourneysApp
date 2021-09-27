package com.example.busjourneysapp.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busjourneysapp.databinding.ItemRowBinding

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.JourneyViewHolder>() {

    inner class JourneyViewHolder(private val itemView : ItemRowBinding) : RecyclerView.ViewHolder(itemView.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JourneyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: JourneyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }



}