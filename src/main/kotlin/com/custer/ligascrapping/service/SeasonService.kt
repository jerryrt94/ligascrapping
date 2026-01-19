package com.custer.ligascrapping.service

import com.custer.ligascrapping.repository.data.SeasonData

interface SeasonService {

    suspend fun getSeason(id: String)
}