package com.example.camunda.configuration

import org.camunda.bpm.dmn.engine.DmnDecision
import org.camunda.bpm.dmn.engine.DmnEngine
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import java.io.IOException
import java.io.InputStream


@Configuration
class ScoringConfiguration(
    val resourceLoader: ResourceLoader,
) {

    @Bean
    fun createDmnEngine(): DmnEngine {
        val configuration = DmnEngineConfiguration
            .createDefaultDmnEngineConfiguration()

        val dmnEngine = configuration.buildEngine()
        return dmnEngine
    }

    @Bean(name = ["scoring"])
    fun createDecisionScoring(dmnEngine: DmnEngine): DmnDecision {
        val resource: Resource = resourceLoader.getResource("classpath:dmn/Scoring.dmn")
        var inputStream: InputStream? = null
        try {
            inputStream = resource.getInputStream()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return dmnEngine.parseDecision("Decision_1v1eqmo", inputStream)
    }
}
