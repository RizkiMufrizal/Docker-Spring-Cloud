package org.rizki.mufrizal.api.gateway.configuration

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 12 January 2018
 * @Time 21.50
 * @Project API-Gateway
 * @Package org.rizki.mufrizal.api.gateway.configuration
 * @File HealthCheckConfiguration
 *
 */

@RestController
class HealthCheckConfiguration {

    @GetMapping(value = ["/health-check"])
    fun healthCheck(): ResponseEntity<*> {
        return ResponseEntity("Ok", HttpStatus.OK)
    }

}