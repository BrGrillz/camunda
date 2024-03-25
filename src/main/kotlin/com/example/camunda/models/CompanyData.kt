package com.example.camunda.models

//@Document(indexName = "companyData")
data class CompanyData(
    val inn: String? = null,
    val region: Int? = null,
    val capital: Int? = null,
    val score: Boolean
)
