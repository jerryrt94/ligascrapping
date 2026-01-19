package com.custer.ligascrapping.repository.data

import com.fasterxml.jackson.annotation.JsonProperty

data class CompetitionsData(
    @JsonProperty("instagram_token")
    val instagramToken: String,

    @JsonProperty("competitions")
    var competitions: Map<String, Competition>
){
    override fun toString(): String {
        return "CompetitionsData(instagramToken='$instagramToken', competitionsSize=${competitions.size})"
    }
}

data class Competition(
    @JsonProperty("competition_id")
    val competitionId: String,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("shortName")
    val shortName: String,

    @JsonProperty("logo")
    val logo: String,

    @JsonProperty("seasons")
    val seasons: Map<String, Season>
)

data class Season(
    @JsonProperty("season_id")
    val seasonId: String,

    @JsonProperty("name")
    val name: String
)

