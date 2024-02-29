package com.example.simpledjangoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpledjangoapp.databinding.EmployeeItemBinding

class EmployeeAdapter(private val context: Context, private val dataList: List<EmployeeData>):
    RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding = EmployeeItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val employee : EmployeeData =dataList.get(position)

        holder.binding.employeeName.setText(employee.employee_name)
    }

    class EmployeeViewHolder(val binding: EmployeeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get: CompanyData) {
            binding.employeeName.text = get.name
        }
    }

}