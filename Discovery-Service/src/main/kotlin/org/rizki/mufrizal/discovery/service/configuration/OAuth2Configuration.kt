package org.rizki.mufrizal.discovery.service.configuration

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
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
 * @Since 07 January 2018
 * @Time 02.07
 * @Project Discovery-Service
 * @Package org.rizki.mufrizal.discovery.service.configuration
 * @File OAuth2Configuration
 *
 */

@Configuration
@EnableOAuth2Sso
class OAuth2Configuration : WebSecurityConfigurerAdapter() {

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

    override fun configure(httpSecurity: HttpSecurity?) {
        httpSecurity
                ?.authorizeRequests()
                ?.antMatchers(HttpMethod.POST, "/api/applications")?.permitAll()
                ?.antMatchers("/mgmt/health")?.permitAll()
                ?.anyRequest()?.authenticated()
                ?.and()?.csrf()?.ignoringAntMatchers("/api/**", "/mgmt/**")
                ?.csrfTokenRepository(csrfTokenRepository())?.and()
                ?.addFilterAfter(csrfHeaderFilter(), CsrfFilter::class.java)
    }

}