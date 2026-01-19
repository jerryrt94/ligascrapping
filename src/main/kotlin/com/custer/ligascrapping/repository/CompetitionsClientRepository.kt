package com.custer.ligascrapping.repository

import com.custer.ligascrapping.repository.data.CompetitionsData
import com.custer.ligascrapping.repository.data.SeasonData

interface CompetitionsClientRepository {

    suspend fun getCompetitions(): CompetitionsData?

    suspend fun getSeason(id: String): SeasonData?

}