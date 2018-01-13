package org.rizki.mufrizal.admin.dashboard.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 13 January 2018
 * @Time 18.54
 * @Project Admin-Dashboard
 * @Package org.rizki.mufrizal.admin.dashboard.configuration
 * @File ZuulConfiguration
 *
 */

@Configuration
@EnableZuulProxy
class ZuulConfiguration @Autowired constructor(val environment: Environment) {

    @Bean
    fun zuulFilterConfiguration(): ZuulFilterConfiguration {
        return ZuulFilterConfiguration(environment)
    }

}