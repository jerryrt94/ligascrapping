package com.custer.ligascrapping.service

import com.custer.ligascrapping.configuration.TorneosConfiguration
import com.custer.ligascrapping.extensions.normalize
import com.custer.ligascrapping.extensions.toFirebase
import com.custer.ligascrapping.repository.CompetitionsClientRepository
import com.custer.ligascrapping.repository.data.CompetitionsData
import com.custer.ligascrapping.service.domain.CompetitionFirebase
import com.google.cloud.firestore.Firestore
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CompetitionsServiceImpl(
    private val competitionsClientRepository: CompetitionsClientRepository,
    private val firestore: Firestore,
    private val torneosConfiguration: TorneosConfiguration
) : CompetitionsService {
    private val logger = KotlinLogging.logger {}

    companion object {
        const val COLLECTION_NAME = "competitions"
    }

    override suspend fun getCompetitions(): CompetitionsData? {
        logger.info { "obteniendo competiciones" }
        var ligaResponse = competitionsClientRepository.getCompetitions()
        ligaResponse?.competitions = ligaResponse?.competitions?.filterValues {
            torneosConfiguration.permitidos.contains(it.name.uppercase().normalize())
        }!!

        var listaCompetenciasFirebase = mutableListOf<CompetitionFirebase>()

        ligaResponse?.competitions?.forEach { (_, competition) ->
            listaCompetenciasFirebase.add(competition.toFirebase())
        }
        saveCompetitions(listaCompetenciasFirebase)
        logger.info { "obteniendo competitions completada" }
        return ligaResponse
    }

    private fun saveCompetitions(competitions: List<CompetitionFirebase>) {
        logger.info { "Inicio guardado de competiciones" }
        val batch = firestore.batch()
        competitions.forEach { competition ->
            val docRef = firestore.collection(COLLECTION_NAME).document(competition.competitionId)
            batch.set(docRef, competition)
        }

        try {

            val results = batch.commit().get() // O usa .asCompletableFuture().await() si prefieres asíncrono puro
            logger.info { "Batch completado, ${results.size} documentos guardados." }
        } catch (e: Exception) {
            logger.error { "Error ejecutando batch: ${e.message}" }
        }

    }
}