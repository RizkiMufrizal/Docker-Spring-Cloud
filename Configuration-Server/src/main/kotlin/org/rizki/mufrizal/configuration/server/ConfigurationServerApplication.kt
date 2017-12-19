package org.rizki.mufrizal.configuration.server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.server.EnableConfigServer

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 19 December 2017
 * @Time 21.56
 * @Project Configuration-Server
 * @Package org.rizki.mufrizal.configuration.server
 * @File ConfigurationServerApplication
 *
 */

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
class ConfigurationServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ConfigurationServerApplication::class.java, *args)
}