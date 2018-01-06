package org.rizki.mufrizal.discovery.service

import de.codecentric.boot.admin.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 19 December 2017
 * @Time 21.12
 * @Project Discovery-Service
 * @Package org.rizki.mufrizal.discovery.service
 * @File DiscoveryServiceApplication
 *
 */
@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
@EnableAdminServer
class DiscoveryServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(DiscoveryServiceApplication::class.java, *args)
}