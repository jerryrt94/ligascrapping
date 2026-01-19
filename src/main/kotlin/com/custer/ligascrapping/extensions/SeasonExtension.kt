package com.custer.ligascrapping.extensions

import com.custer.ligascrapping.repository.data.*
import com.custer.ligascrapping.service.domain.*

fun SeasonData.toFirebase(): SeasonDetailFirebase {
    return SeasonDetailFirebase(
        lastUpdated = lastUpdated,
        generalStatistics = generalStatistics.toFirebase(),
        teamStatistics = teamStatistics.toFirebase(),
        cautionedPlayers = cautionedPlayers?.map {
            it.value.toFirebase()
        },
        sentOffPlayers = sentOffPlayers?.map {
            it.toFirebase()
        },
        scorersSeason = scorersSeason
            ?.take(10)
            ?.map { it.toFirebase() },
        teams = teams.map {
            it.value.toFirebase()
        },
        classificationTeamPoints = classificationTeamPoints.map {
            it.value.toFirebase()
        },
        gameSchedule = gameSchedule?.map {
            it.value.toFirebase()
        }
    )
}

fun GeneralStatistics.toFirebase(): GeneralStatisticsFirebase {
    return GeneralStatisticsFirebase(
        players = players,
        games = games,
        goals = goals,
        ownGoals = ownGoals,
        yellowCards = yellowCards,
        redCards = redCards,
    )
}

fun TeamStatistics.toFirebase(): TeamStatisticsFirebase {
    return TeamStatisticsFirebase(
        byVictories = byVictories.map {
            it.toFirebase()
        },
        byDefeats = byDefeats.map {
            it.toFirebase()
        },
        byDraws = byDraws.map {
            it.toFirebase()
        },
        byScoredGoals = byScoredGoals.map {
            it.toFirebase()
        },
        byReceivedGoals = byReceivedGoals.map {
            it.toFirebase()
        }
    )
}

fun TeamStatItem.toFirebase(): TeamStatItemFirebase {
    return TeamStatItemFirebase(
        teamId = teamId,
        played = played,
        won = won,
        lost = lost,
        drawn = drawn,
        defaultWon = defaultWon,
        scoredGoals = scoredGoals,
        receivedGoals = receivedGoals,
        place = place
    )
}

fun Player.toFirebase(id: String): PlayerFirebase {
    return PlayerFirebase(
        id = id,
        firstname = firstname,
        lastname = lastname,
        avatar = avatar,
        shirtNumber = shirtNumber,
        positions = positions,
        teamId = teamId
    )
}

fun CautionedPlayer.toFirebase(): CautionedPlayerFirebase {
    return CautionedPlayerFirebase(
        playerId = playerId,
        count = count,
        journeys = journeys
    )
}

fun SentOffPlayer.toFirebase(): SentOffPlayerFirebase {
    return SentOffPlayerFirebase(
        playerId = playerId,
        cardReason = cardReason,
        journey = journey
    )
}

fun Scorer.toFirebase(): ScorerFirebase {
    return ScorerFirebase(
        playerId = playerId,
        goals = goals,
        place = place
    )
}

fun Team.toFirebase(): TeamFirebase {
    return TeamFirebase(
        teamId = teamId,
        name = name,
        shortName = shortName,
        logo = logo,
        players = players,
        staff = staff?.map {
            it.toFirebase()
        }
    )
}

fun Staff.toFirebase(): StaffFirebase {
    return StaffFirebase(
        staffId = staffId,
        firstname = firstname,
        lastname = lastname,
        type = type,
        image = image,
    )
}

fun ClassificationTeamPoints.toFirebase(): TeamStatsFirebase {
    return TeamStatsFirebase(
        teamId = teamId,
        played = played,
        won = won,
        lost = lost,
        drawn = drawn,
        scoredGoals = scoredGoals,
        receivedGoals = receivedGoals,
        defaultWon = defaultWon,
        defaultLost = defaultLost,
        drawnWon = drawnWon,
        drawnLost = drawnLost,
        drawnDrawn = drawnDrawn,
        goalsDifference = goalsDifference,
        yellowCards = yellowCards,
        redCards = redCards,
        points = points
    )
}

fun Journey.toFirebase(): JourneyFirebase {
    return JourneyFirebase(
        journeyId = journeyId,
        name = name,
        games = games?.map {
            it.toFirebase()
        }
    )
}

fun Game.toFirebase(): GameFirebase {
    return GameFirebase(
        gameId = gameId,
        date = date,
        field = field,
        homeTeamId = homeTeamId,
        awayTeamId = awayTeamId,
        status = status,
        homeScore = homeScore,
        awayScore = awayScore,
        homePenalties = homePenalties,
        awayPenalties = awayPenalties,
    )
}