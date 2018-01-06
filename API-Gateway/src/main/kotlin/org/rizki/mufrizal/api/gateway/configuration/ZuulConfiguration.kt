package org.rizki.mufrizal.api.gateway.configuration

import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 06 January 2018
 * @Time 22.24
 * @Project API-Gateway
 * @Package org.rizki.mufrizal.api.gateway.configuration
 * @File ZuulConfiguration
 *
 */

@Configuration
@EnableZuulProxy
class ZuulConfiguration {

    @Bean
    fun zuulFilterConfiguration(): ZuulFilterConfiguration {
        return ZuulFilterConfiguration()
    }

}