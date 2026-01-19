package com.custer.ligascrapping

import com.custer.ligascrapping.service.CompetitionsService
import com.custer.ligascrapping.service.SeasonService
import kotlinx.coroutines.runBlocking
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@ConfigurationPropertiesScan
@SpringBootApplication
class LigascrappingApplication{
	@Bean
	fun ejecutarAlArranque(competitionsService: CompetitionsService,
						   seasonService: SeasonService): CommandLineRunner {
		return CommandLineRunner {
			runBlocking {
				val competitions = competitionsService.getCompetitions()
				competitions?.competitions?.forEach { competition ->
					val value = competition.value
					value.seasons.values.forEach { season ->
						seasonService.getSeason(season.seasonId)
					}

				}
			}
		}
	}
}

fun main(args: Array<String>) {
	runApplication<LigascrappingApplication>(*args)
}


