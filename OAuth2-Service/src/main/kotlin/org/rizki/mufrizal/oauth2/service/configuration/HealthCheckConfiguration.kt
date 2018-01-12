package org.rizki.mufrizal.oauth2.service.configuration

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 12 January 2018
 * @Time 21.59
 * @Project OAuth2-Service
 * @Package org.rizki.mufrizal.oauth2.service.configuration
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