package com.example.mvparchitecture.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvparchitecture.databinding.UniversityViewBinding
import com.example.mvparchitecture.network.model.University

class MainRvAdapter: RecyclerView.Adapter<MainRvAdapter.MyViewHolder>() {

    var list = listOf<University>()

    fun addItem(list: List<University>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainRvAdapter.MyViewHolder {
        val binding = UniversityViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainRvAdapter.MyViewHolder, position: Int) {

        val binding = holder.viewUniversityBinding
        val item = this.list[position]

        binding.tvCountry.text = item.country
        binding.tvState.text = item.state_province
        binding.tvName.text = item.name
    }

    override fun getItemCount(): Int = this.list.size

    inner class MyViewHolder(val viewUniversityBinding: UniversityViewBinding):
        RecyclerView.ViewHolder(viewUniversityBinding.root)
}

















