package org.rizki.mufrizal.discovery.service.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 07 January 2018
 * @Time 15.33
 * @Project Discovery-Service
 * @Package org.rizki.mufrizal.discovery.service.configuration
 * @File ZuulConfiguration
 *
 */

@Configuration
class ZuulConfiguration @Autowired constructor(val environment: Environment) {

    @Bean
    fun zuulFilterConfiguration(): ZuulFilterConfiguration {
        return ZuulFilterConfiguration(environment)
    }

}