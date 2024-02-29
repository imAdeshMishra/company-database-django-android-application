package com.example.simpledjangoapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpledjangoapp.databinding.Fragment1Binding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Fragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    lateinit var binding: Fragment1Binding

    private lateinit var adapter: CompaniesAdapter
    private lateinit var companies :List<CompanyData>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding =Fragment1Binding.inflate(inflater,container,false)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)



        val call = RetrofitClient.apiService.fetchData()

        call.enqueue(object : Callback<List<CompanyData>> {
            override fun onResponse(
                call: Call<List<CompanyData>>,
                response: Response<List<CompanyData>>
            ) {
                if (response.isSuccessful) {
                    Log.d("APIResponse", response.body().toString())
                    // Handle the list of companies
                    val companyList = response.body()
                    if (companyList != null) {
                        companies = companyList
                        adapter = context?.let { CompaniesAdapter(it,companies) }!!
                        binding.recyclerView.adapter = adapter
                        Log.d("APIResponse", "Company data received: $companies")
                    } else {
                        Log.d("APIResponse", "Empty response body")
                    }
                } else {
                    // Handle error
                    Log.d("APIResponse", "Couldnothit")
                }
            }

            override fun onFailure(call: Call<List<CompanyData>>, t: Throwable) {
                // Handle network errors
                Log.d("APIResponse", "Error, Request URL: ${call.request().url()}")
                Log.e("APIResponse", "API request failed: ${t.message}", t)
            }
        })
        return binding.root
    }

}