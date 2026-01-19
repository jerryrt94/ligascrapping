package com.custer.ligascrapping.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "torneos")
data class TorneosConfiguration (
    val permitidos: List<String>
)