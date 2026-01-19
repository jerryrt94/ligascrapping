package com.custer.ligascrapping.repository

import com.custer.ligascrapping.repository.data.CompetitionsData
import com.custer.ligascrapping.repository.data.SeasonData
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import tools.jackson.databind.ObjectMapper

@Component
class CompetitionsClientRepositoryImpl(
    private val webClient: WebClient,
    private val objectMapper: ObjectMapper
) : CompetitionsClientRepository {

    private val logger = KotlinLogging.logger {}

    override suspend fun getCompetitions(): CompetitionsData? {
        logger.info { "Obteniendo competitions /organization" }

        return runCatching {
            val jsonResponse = webClient.get()
                .uri("/organization")
                .retrieve()
                .awaitBody<String>()

            objectMapper.readValue(jsonResponse, CompetitionsData::class.java)
        }.onSuccess { data ->
            logger.info { "Obtención de competitions completada. Data: $data" }
        }.onFailure { e ->
            logger.error(e) { "Error al obtener competitions de la API: ${e.message}" }
        }.getOrNull()
    }

    override suspend fun getSeason(id: String): SeasonData? {
        logger.info { "Obteniendo datos de temporada: $id" }
        return runCatching {
            val data = webClient.get()
                .uri("/season/$id/statistics")
                .retrieve()
                .awaitBody<String>()

            objectMapper.readValue(data, SeasonData::class.java)
        }.onSuccess {
            logger.info { "Obtención de temporada completada. id: $id" }
        }.onFailure { e ->
            logger.error(e) { "Error al obtener temporada de la API: ${e.message}" }
        }.getOrNull()
    }
}