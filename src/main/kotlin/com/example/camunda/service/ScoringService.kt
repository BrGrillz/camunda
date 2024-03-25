package com.example.camunda.service

import com.example.camunda.models.CompanyData
import com.example.camunda.models.CompanyScore

interface ScoringService {
    fun calculateScore(companyData: CompanyData): CompanyScore
}