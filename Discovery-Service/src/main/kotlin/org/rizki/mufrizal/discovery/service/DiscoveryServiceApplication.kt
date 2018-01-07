package org.rizki.mufrizal.discovery.service

import de.codecentric.boot.admin.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.csrf.CsrfFilter
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository
import org.springframework.security.web.csrf.CsrfTokenRepository
import org.springframework.web.util.WebUtils
import org.springframework.security.web.csrf.CsrfToken
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletResponse
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.Filter
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest

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
@EnableWebSecurity
class DiscoveryServiceApplication : WebSecurityConfigurerAdapter() {

    @Bean
    @ConfigurationProperties("spring.boot.admin.auth")
    fun basicAuthFilter(): BasicAuthFilter {
        return BasicAuthFilter()
    }

    private fun csrfTokenRepository(): CsrfTokenRepository {
        val repository = HttpSessionCsrfTokenRepository()
        repository.setHeaderName("X-XSRF-TOKEN")
        return repository
    }

    private fun csrfHeaderFilter(): Filter {
        return object : OncePerRequestFilter() {
            @Throws(ServletException::class, IOException::class)
            override fun doFilterInternal(request: HttpServletRequest?, response: HttpServletResponse?, filterChain: FilterChain?) {
                val csrf = request?.getAttribute(CsrfToken::class.java.name) as CsrfToken
                var cookie: Cookie? = WebUtils.getCookie(request, "XSRF-TOKEN")
                val token = csrf.token
                if (cookie == null || token != null && token != cookie.value) {
                    cookie = Cookie("XSRF-TOKEN", token)
                    cookie.path = "/"
                    response?.addCookie(cookie)
                }
                filterChain?.doFilter(request, response)
            }
        }
    }

    override fun configure(http: HttpSecurity?) {
        http?.formLogin()
                ?.and()
                ?.authorizeRequests()
                ?.antMatchers(HttpMethod.POST, "/api/applications")?.permitAll()
                ?.antMatchers("/health")?.permitAll()
                ?.anyRequest()?.authenticated()
                ?.and()
                ?.csrf()?.ignoringAntMatchers("/api/**", "/**")
                ?.csrfTokenRepository(csrfTokenRepository())?.and()
                ?.addFilterAfter(csrfHeaderFilter(), CsrfFilter::class.java)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(DiscoveryServiceApplication::class.java, *args)
}