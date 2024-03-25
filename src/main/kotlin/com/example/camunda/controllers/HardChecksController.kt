package com.example.camunda.controllers

import com.example.camunda.implementation.ScoringServiceImpl
import com.example.camunda.models.CompanyData
import com.example.camunda.models.CompanyScore
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class HardChecksController(val scoringServiceImpl: ScoringServiceImpl){
    @PostMapping("/evaluateDecision")
    fun evaluateDecision(@RequestBody companyData: CompanyData): CompanyScore {
        return scoringServiceImpl.calculateScore(companyData)
    }
}
