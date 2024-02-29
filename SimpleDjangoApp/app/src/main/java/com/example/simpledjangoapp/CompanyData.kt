package com.example.simpledjangoapp

data class CompanyData(
    val url: String,
    val company_id: Int,
    val name: String,
    val location: String,
    val about: String,
    val type: String,
    val added_date: String,
    val active: Boolean
)
