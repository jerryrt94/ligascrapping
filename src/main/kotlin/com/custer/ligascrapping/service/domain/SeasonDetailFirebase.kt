package com.custer.ligascrapping.service.domain

data class SeasonDetailFirebase(
    val lastUpdated: String?,
    val generalStatistics: GeneralStatisticsFirebase,
    val teamStatistics: TeamStatisticsFirebase,
    val cautionedPlayers: List<CautionedPlayerFirebase>?,
    val sentOffPlayers: List<SentOffPlayerFirebase>?,
    val scorersSeason: List<ScorerFirebase>?,
    val teams: List<TeamFirebase>,
    val classificationTeamPoints: List<TeamStatsFirebase>,
    val gameSchedule: List<JourneyFirebase>?
)

data class GeneralStatisticsFirebase(
    val players: Int?,
    val games: Int?,
    val goals: Int?,
    val ownGoals: Int?,
    val yellowCards: Int?,
    val redCards: Int?
)

data class TeamStatisticsFirebase(
    val byVictories: List<TeamStatItemFirebase>,
    val byDefeats: List<TeamStatItemFirebase>,
    val byDraws: List<TeamStatItemFirebase>,
    val byScoredGoals: List<TeamStatItemFirebase>,
    val byReceivedGoals: List<TeamStatItemFirebase>
)

data class TeamStatItemFirebase(
    val teamId: String?,
    val played: Int?,
    val won: Int?,
    val lost: Int?,
    val drawn: Int?,
    val defaultWon: Int?,
    val scoredGoals: Int?,
    val receivedGoals: Int?,
    val place: Int?
)

data class PlayerFirebase(
    val id: String?,
    val firstname: String?,
    val lastname: String?,
    val avatar: String?,
    val shirtNumber: Int?,
    val positions: List<String>?,
    val teamId: String?
)

data class TeamFirebase(
    val teamId: String?,
    val name: String?,
    val shortName: String?,
    val logo: String?,
    val players: List<String>?,
    val staff: List<StaffFirebase>?
)

data class StaffFirebase(
    val staffId: String?,
    val firstname: String?,
    val lastname: String?,
    val type: Int?,
    val image: String?
)

data class TeamStatsFirebase(
    val teamId: String?,
    val played: Int?,
    val won: Int?,
    val lost: Int?,
    val drawn: Int?,
    val scoredGoals: Int?,
    val receivedGoals: Int?,
    val defaultWon: Int?,
    val defaultLost: Int?,
    val drawnWon: Int?,
    val drawnLost: Int?,
    val drawnDrawn: Int?,
    val goalsDifference: Int?,
    val yellowCards: Int?,
    val redCards: Int?,
    val points: Int?
)

data class JourneyFirebase(
    val journeyId: String?,
    val name: String?,
    val games: List<GameFirebase>?
)

data class GameFirebase(
    val gameId: String?,
    val date: String?,
    val field: String?,
    val homeTeamId: String?,
    val awayTeamId: String?,
    val status: String?,
    val homeScore: Int?,
    val awayScore: Int?,
    val homePenalties: Int?,
    val awayPenalties: Int?
)

data class CautionedPlayerFirebase(
    val playerId: String?,
    val count: Int?,
    val journeys: List<String>?
)

data class SentOffPlayerFirebase(
    val playerId: String?,
    val cardReason: Int?,
    val journey: String?
)

data class ScorerFirebase(
    val playerId: String?,
    val goals: Int?,
    val place: Int?
)

data class PlayerFanStatsFirebase(
    val playerId: String?,
    val teamId: String?,
    val goals: Int?,
    val ownGoals: Int?,
    val yellowCards: Int?,
    val doubleYellowCards: Int?,
    val redCards: Int?,
    val bestPlayer: Int?,
    val goalsPoints: Int?,
    val bestPlayerPoints: Int?,
    val yellowCardsPoints: Int?,
    val doubleYellowCardsPoints: Int?,
    val redCardsPoints: Int?,
    val ownGoalsPoints: Int?,
    val points: Int?,
    val place: Int?
)

data class TeamFanStatsFirebase(
    val teamId: String?,
    val awayWon: Int?,
    val gamesGoalsKeeper: Int?,
    val lostByDefault: Int?,
    val cardsFree: Int?,
    val teamPlayersFansStats: Int?,
    val awayWonPoints: Int?,
    val gamesGoalsKeeperPoints: Int?,
    val cardsFreePoints: Int?,
    val lostByDefaultPoints: Int?,
    val teamPlayersFansStatsPoints: Int?,
    val points: Int?,
    val place: Int?
)

data class BestMatchesFirebase(
    val bestGame: BestGameFirebase?,
    val expectedMatch: Any?
)

data class BestGameFirebase(
    val gameId: String?,
    val homeTeamId: String?,
    val awayTeamId: String?,
    val homeScore: Int?,
    val awayScore: Int?,
    val homePenalties: Int?,
    val awayPenalties: Int?,
    val startTime: String?,
    val journey: String?,
    val homeStats: MatchStatsFirebase?,
    val awayStats: MatchStatsFirebase?
)

data class MatchStatsFirebase(
    val goals: Int?,
    val penalties: Int?,
    val yellowCards: Int?,
    val doubleYellowCards: Int?,
    val redCards: Int?,
    val injuries: Int?
)
