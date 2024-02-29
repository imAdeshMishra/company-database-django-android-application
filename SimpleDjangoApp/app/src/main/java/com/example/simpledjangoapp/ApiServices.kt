package com.example.simpledjangoapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("api_app/v1/companies/")
    fun fetchData(): Call<List<CompanyData>>

    @GET("api_app/v1/employees/")
    fun fetchEmployeeData(): Call<List<EmployeeData>>
}