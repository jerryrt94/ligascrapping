package com.custer.ligascrapping.extensions

import com.custer.ligascrapping.repository.data.Competition
import com.custer.ligascrapping.repository.data.Season
import com.custer.ligascrapping.service.domain.CompetitionFirebase
import com.custer.ligascrapping.service.domain.SeasonFirebase


fun Competition.toFirebase(): CompetitionFirebase {
    return CompetitionFirebase(
        competitionId = competitionId,
        name = name.normalize(),
        shortName = shortName,
        logo = logo,
        seasons = seasons.map {
            it.value.toFirebase()
        }
    )
}

fun Season.toFirebase(): SeasonFirebase {
    return SeasonFirebase(
        seasonId = seasonId,
        name = name
    )
}