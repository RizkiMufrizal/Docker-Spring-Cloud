package org.rizki.mufrizal.api.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 06 January 2018
 * @Time 21.48
 * @Project API-Gateway
 * @Package org.rizki.mufrizal.api.gateway
 * @File ApiGatewayApplication
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
class ApiGatewayApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApiGatewayApplication::class.java, *args)
}
