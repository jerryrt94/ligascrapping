package com.custer.ligascrapping.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ClientCodecConfigurer
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import java.util.function.Consumer


@Configuration
class WebClientConfiguration {

    @Bean
    fun webClient(): WebClient {
        val size = 16 * 1024 * 1024 // 16 MB (adjust as needed)
        val strategies = ExchangeStrategies.builder()
            .codecs { clientCodecConfigurer: ClientCodecConfigurer? ->
                clientCodecConfigurer!!.defaultCodecs().maxInMemorySize(size)
            }
            .build()
        return WebClient.builder()
            .baseUrl("https://www.ligaprimera.com/api")
            .exchangeStrategies(strategies)
            .build()
    }
}