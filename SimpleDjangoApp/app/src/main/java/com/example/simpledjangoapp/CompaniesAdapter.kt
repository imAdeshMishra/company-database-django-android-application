package com.example.simpledjangoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.simpledjangoapp.databinding.CompanyItemBinding
import com.example.simpledjangoapp.databinding.Fragment1Binding

class CompaniesAdapter(private val context: Context, private val dataList: List<CompanyData>):
            RecyclerView.Adapter<CompaniesAdapter.CompanyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val binding = CompanyItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CompanyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        val company : CompanyData =dataList.get(position)

        holder.binding.companyName.setText(company.name)



    }

    class CompanyViewHolder(val binding: CompanyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get: CompanyData) {
            binding.companyName.text = get.name
        }
    }

}