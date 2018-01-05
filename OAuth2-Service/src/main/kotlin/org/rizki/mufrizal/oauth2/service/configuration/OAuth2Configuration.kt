package org.rizki.mufrizal.oauth2.service.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore
import java.io.File
import javax.sql.DataSource

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 05 January 2018
 * @Time 21.25
 * @Project OAuth2-Service
 * @Package org.rizki.mufrizal.oauth2.service.configuration
 * @File OAuth2Configuration
 *
 */

@Configuration
open class OAuth2Configuration {

    @Configuration
    @EnableAuthorizationServer
    protected class AuthorizationServerConfiguration : AuthorizationServerConfigurerAdapter() {

        @Autowired
        @Qualifier("authenticationManagerBean")
        private lateinit var authenticationManager: AuthenticationManager

        @Autowired
        private lateinit var jedisConnectionFactory: JedisConnectionFactory

        @Autowired
        private lateinit var dataSource: DataSource

        @Bean
        fun jwtAccessTokenConverter(): JwtAccessTokenConverter {
            val converter = JwtAccessTokenConverter()
            val keyStoreKeyFactory = KeyStoreKeyFactory(ClassPathResource("keys${File.separator}jwt.jks"), "mufrizalrizki".toCharArray())
            converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"))
            return converter
        }

        @Bean
        fun tokenStore(): TokenStore {
            return RedisTokenStore(jedisConnectionFactory)
        }

        @Throws(Exception::class)
        override fun configure(authorizationServerEndpointsConfigurer: AuthorizationServerEndpointsConfigurer?) {
            authorizationServerEndpointsConfigurer
                    ?.accessTokenConverter(jwtAccessTokenConverter())
                    ?.tokenStore(tokenStore())
                    ?.authenticationManager(authenticationManager)
        }

        @Throws(Exception::class)
        override fun configure(clientDetailsServiceConfigurer: ClientDetailsServiceConfigurer?) {
            clientDetailsServiceConfigurer
                    ?.jdbc(dataSource)
        }

    }

}