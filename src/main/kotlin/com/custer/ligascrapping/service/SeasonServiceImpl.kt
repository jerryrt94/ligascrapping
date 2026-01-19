package com.custer.ligascrapping.service

import com.custer.ligascrapping.extensions.toFirebase
import com.custer.ligascrapping.repository.CompetitionsClientRepository
import com.custer.ligascrapping.repository.data.SeasonData
import com.custer.ligascrapping.service.domain.PlayerFirebase
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.Firestore
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Service
import kotlin.math.log

@Service
class SeasonServiceImpl(
    private val competitionsClientRepository: CompetitionsClientRepository,
    private val firestore: Firestore
) : SeasonService {
    private val logger = KotlinLogging.logger {}

    companion object {
        const val COLLECTION_NAME = "seasons"
    }

    override suspend fun getSeason(id: String) {
        logger.info { "obteniendo temporada" }
        val season = competitionsClientRepository.getSeason(id)
        saveSeason(season, id)
        uploadPlayersBatch(season, id)
        logger.info { "fin obteniendo competitions completada" }
    }

    private fun saveSeason(season: SeasonData?, id: String) {
        season?.let { safeSeason ->
            logger.info { "Inicio guardado de temporada para ID: $id" }
            val docRef: DocumentReference = firestore.collection(COLLECTION_NAME).document(id)
            docRef.set(safeSeason.toFirebase())

            logger.info { "Temporada $id guardada con éxito" }
        } ?: logger.warn { "No se guardó nada: la temporada recibida es nula para el ID: $id" }
    }

    private fun uploadPlayersBatch(season: SeasonData?, id: String) {
        logger.info { "Subiendo jugadores para temporada ID: $id" }

        val playerList = mutableListOf<PlayerFirebase>()

        season?.players?.forEach { (key, player) ->
            playerList.add(player.toFirebase(key))
        }

        playerList.chunked(500).forEach { chunk ->
            val batch = firestore.batch()

            chunk.forEach { player ->
                val playerId = player.id ?: firestore.collection("seasonsPlayers").document().id
                val playerRef = firestore.collection("seasonsPlayers")
                    .document(id)
                    .collection("players")
                    .document(playerId)

                batch.set(playerRef, player)
            }
            try {
                batch.commit()
                logger.info { "Bloque de jugadores subido con éxito" }
            } catch (e: Exception) {
                logger.error { "Error al subir bloque: $e" }
            }
        }
    }
}