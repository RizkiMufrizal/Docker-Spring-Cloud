package org.rizki.mufrizal.oauth2.service

import org.rizki.mufrizal.oauth2.service.domain.OAuth2ClientDetail
import org.rizki.mufrizal.oauth2.service.domain.User
import org.rizki.mufrizal.oauth2.service.repository.OAuth2ClientDetailRepository
import org.rizki.mufrizal.oauth2.service.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 05 January 2018
 * @Time 21.12
 * @Project OAuth2-Service
 * @Package org.rizki.mufrizal.oauth2.service
 * @File OAuth2ServiceApplication1
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
class OAuth2ServiceApplication : CommandLineRunner {

    @Autowired
    private lateinit var userRepositoty: UserRepository

    @Autowired
    private lateinit var oAuth2ClientDetailRepository: OAuth2ClientDetailRepository

    override fun run(vararg args: String?) {
        if (!this.userRepositoty.findByUsername("rizki").isPresent) {
            this.userRepositoty.save(User(
                    username = "rizki",
                    password = BCryptPasswordEncoder().encode("mufrizal"),
                    isActive = true,
                    roles = setOf("ROLE_ADMIN", "ROLE_USER")
            ))
        }

        if (!this.oAuth2ClientDetailRepository.findByClientId("clientid").isPresent) {
            this.oAuth2ClientDetailRepository.save(OAuth2ClientDetail(
                    clientId = "clientid",
                    resourceIds = "RESOURCE_ID_API_GATEWAY",
                    clientSecret = "secret",
                    scope = "read,write",
                    authorizedGrantTypes = "client_credentials,password,refresh_token",
                    webServerRedirectUri = " ",
                    authorities = "ADMIN,CLIENT,ADMINISTRATOR",
                    accessTokenValidity = 3600,
                    refreshTokenValidity = 3600,
                    additionalInformation = "{\"additional_param\":\"hello OAuth2\"}",
                    autoApprove = true
            ))
        }

    }
}

fun main(args: Array<String>) {
    SpringApplication.run(OAuth2ServiceApplication::class.java, *args)
}