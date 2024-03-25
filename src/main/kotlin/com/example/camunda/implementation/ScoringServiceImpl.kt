package com.example.camunda.implementation

import com.example.camunda.models.CompanyData
import com.example.camunda.models.CompanyScore
import com.example.camunda.service.ScoringService
import org.camunda.bpm.dmn.engine.DmnDecision
import org.camunda.bpm.dmn.engine.DmnEngine
import org.camunda.bpm.engine.variable.Variables
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service


@Service
class ScoringServiceImpl(
    val dmnEngine: DmnEngine,
    @Qualifier(value = "scoring")
    val decision: DmnDecision
): ScoringService {

    override fun calculateScore(companyData: CompanyData): CompanyScore {

        val variables = Variables
            .putValue("inn", companyData.inn)
            .putValue("region", companyData.region)
            .putValue("capital", companyData.capital)

        val decision = dmnEngine.evaluateDecisionTable(decision, variables)
        val score = decision.singleResult["Scoring"]
        val result = CompanyScore(score as Boolean)
        return result
    }
}