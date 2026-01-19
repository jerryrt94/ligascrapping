package com.custer.ligascrapping.service.domain

data class CompetitionFirebase(
    val competitionId: String,
    val name: String,
    val shortName: String,
    val logo: String,
    val seasons: List<SeasonFirebase>
)

data class SeasonFirebase(
    val seasonId: String,
    val name: String
)
