package com.custer.ligascrapping.service

import com.custer.ligascrapping.repository.data.CompetitionsData

interface CompetitionsService {

    suspend fun getCompetitions(): CompetitionsData?
}