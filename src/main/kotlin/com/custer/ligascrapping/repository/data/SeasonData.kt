package com.custer.ligascrapping.repository.data

import com.fasterxml.jackson.annotation.JsonProperty

data class SeasonData(
    @JsonProperty("last_updated")
    val lastUpdated: String?,

    @JsonProperty("general_statistics")
    val generalStatistics: GeneralStatistics,

    @JsonProperty("team_statistics")
    val teamStatistics: TeamStatistics,

    val players: Map<String, Player>,

    @JsonProperty("suspended_players")
    val suspendedPlayers: Map<String, Any>?, // Vacío en el JSON, se deja genérico

    @JsonProperty("cautioned_players")
    val cautionedPlayers: Map<String, CautionedPlayer>?,

    @JsonProperty("sent_off_players")
    val sentOffPlayers: List<SentOffPlayer>?,

    @JsonProperty("scorers_season")
    val scorersSeason: List<Scorer>?,

    val teams: Map<String, Team>,

    @JsonProperty("classification_team_points")
    val classificationTeamPoints: Map<String, ClassificationTeamPoints>,

    @JsonProperty("teams_groups")
    val teamsGroups: Any?, // Null en el JSON

    @JsonProperty("game_schedule")
    val gameSchedule: Map<String, Journey>?,

    @JsonProperty("player_fans_stats")
    val playerFansStats: Map<String, PlayerFanStats>?,

    @JsonProperty("teams_fans_stats")
    val teamsFansStats: Map<String, TeamFanStats>?,

    @JsonProperty("best_matches")
    val bestMatches: BestMatches?
)

data class GeneralStatistics(
    val players: Int?,
    val games: Int?,
    val goals: Int?,
    @JsonProperty("own_goals")
    val ownGoals: Int?,
    @JsonProperty("yellow_cards")
    val yellowCards: Int?,
    @JsonProperty("red_cards")
    val redCards: Int?
)

data class TeamStatistics(
    val byVictories: List<TeamStatItem>,
    val byDefeats: List<TeamStatItem>,
    val byDraws: List<TeamStatItem>,
    val byScoredGoals: List<TeamStatItem>,
    val byReceivedGoals: List<TeamStatItem>
)

data class TeamStatItem(
    @JsonProperty("team_id")
    val teamId: String?,
    val played: Int?,
    val won: Int?,
    val lost: Int?,
    val drawn: Int?,
    @JsonProperty("default_won")
    val defaultWon: Int?,
    @JsonProperty("scored_goals")
    val scoredGoals: Int?,
    @JsonProperty("received_goals")
    val receivedGoals: Int?,
    val place: Int?
)

data class Player(
    val firstname: String?,
    val lastname: String?,
    val avatar: String?,
    val shirtNumber: Int?,
    val positions: List<String>?,
    val teamId: String?
)

data class CautionedPlayer(
    @JsonProperty("player_id")
    val playerId: String?,
    val count: Int?,
    val journeys: List<String>?
)

data class SentOffPlayer(
    @JsonProperty("player_id")
    val playerId: String?,
    @JsonProperty("card_reason")
    val cardReason: Int?,
    val journey: String?
)

data class Scorer(
    @JsonProperty("player_id")
    val playerId: String?,
    val goals: Int?,
    val place: Int?
)

data class Team(
    @JsonProperty("team_id")
    val teamId: String?,
    val name: String?,
    val shortName: String?,
    val logo: String?,
    val players: List<String>?,
    val staff: List<Staff>?
)

data class Staff(
    val staffId: String?,
    val firstname: String?,
    val lastname: String?,
    val type: Int?,
    val image: String?
)

data class ClassificationTeamPoints(
    @JsonProperty("team_id")
    val teamId: String?,
    val played: Int?,
    val won: Int?,
    val lost: Int?,
    val drawn: Int?,
    @JsonProperty("scored_goals")
    val scoredGoals: Int?,
    @JsonProperty("received_goals")
    val receivedGoals: Int?,
    @JsonProperty("default_won")
    val defaultWon: Int?,
    @JsonProperty("default_lost")
    val defaultLost: Int?,
    @JsonProperty("drawn_won")
    val drawnWon: Int?,
    @JsonProperty("drawn_lost")
    val drawnLost: Int?,
    @JsonProperty("drawn_drawn")
    val drawnDrawn: Int?,
    @JsonProperty("goals_difference")
    val goalsDifference: Int?,
    @JsonProperty("yellow_cards")
    val yellowCards: Int?,
    @JsonProperty("red_cards")
    val redCards: Int?,
    val points: Int?
)

data class Journey(
    @JsonProperty("journey_id")
    val journeyId: String?,
    val name: String?,
    val games: List<Game>?
)

data class Game(
    @JsonProperty("game_id")
    val gameId: String?,
    val date: String?,
    val field: String?,
    @JsonProperty("home_team_id")
    val homeTeamId: String?,
    @JsonProperty("away_team_id")
    val awayTeamId: String?,
    val status: String?,
    // Estos campos vienen en camelCase en el JSON
    val homeScore: Int?,
    val awayScore: Int?,
    val homePenalties: Int?,
    val awayPenalties: Int?
)

data class PlayerFanStats(
    val playerId: String?,
    val teamId: String?,
    val goals: Int?,
    @JsonProperty("own_goals")
    val ownGoals: Int?,
    @JsonProperty("yellow_cards")
    val yellowCards: Int?,
    @JsonProperty("double_yellow_cards")
    val doubleYellowCards: Int?,
    @JsonProperty("red_cards")
    val redCards: Int?,
    @JsonProperty("best_player")
    val bestPlayer: Int?,
    @JsonProperty("goals_points")
    val goalsPoints: Int?,
    @JsonProperty("best_player_points")
    val bestPlayerPoints: Int?,
    @JsonProperty("yellow_cards_points")
    val yellowCardsPoints: Int?,
    @JsonProperty("double_yellow_cards_points")
    val doubleYellowCardsPoints: Int?,
    @JsonProperty("red_cards_points")
    val redCardsPoints: Int?,
    @JsonProperty("own_goals_points")
    val ownGoalsPoints: Int?,
    val points: Int?,
    val place: Int?
)

data class TeamFanStats(
    @JsonProperty("team_id")
    val teamId: String?,
    @JsonProperty("away_won")
    val awayWon: Int?,
    @JsonProperty("games_goals_keeper")
    val gamesGoalsKeeper: Int?,
    @JsonProperty("lost_by_default")
    val lostByDefault: Int?,
    @JsonProperty("cards_free")
    val cardsFree: Int?,
    @JsonProperty("team_players_fans_stats")
    val teamPlayersFansStats: Int?,
    @JsonProperty("away_won_points")
    val awayWonPoints: Int?,
    @JsonProperty("games_goals_keeper_points")
    val gamesGoalsKeeperPoints: Int?,
    @JsonProperty("cards_free_points")
    val cardsFreePoints: Int?,
    @JsonProperty("lost_by_default_points")
    val lostByDefaultPoints: Int?,
    @JsonProperty("team_players_fans_stats_points")
    val teamPlayersFansStatsPoints: Int?,
    val points: Int?,
    val place: Int?
)

data class BestMatches(
    @JsonProperty("best_game")
    val bestGame: BestGame?,
    @JsonProperty("expected_match")
    val expectedMatch: Any? // Null en el JSON
)

data class BestGame(
    @JsonProperty("game_id")
    val gameId: String?,
    @JsonProperty("home_team_id")
    val homeTeamId: String?,
    @JsonProperty("away_team_id")
    val awayTeamId: String?,
    @JsonProperty("home_score")
    val homeScore: Int?,
    @JsonProperty("away_score")
    val awayScore: Int?,
    @JsonProperty("home_penalties")
    val homePenalties: Int?,
    @JsonProperty("away_penalties")
    val awayPenalties: Int?,
    @JsonProperty("start_time")
    val startTime: String?,
    val journey: String?,
    @JsonProperty("home_stats")
    val homeStats: MatchStats?,
    @JsonProperty("away_stats")
    val awayStats: MatchStats?
)

data class MatchStats(
    val goals: Int?,
    val penalties: Int?,
    // Estos campos vienen en camelCase dentro de home_stats/away_stats
    val yellowCards: Int?,
    val doubleYellowCards: Int?,
    val redCards: Int?,
    val injuries: Int?
)