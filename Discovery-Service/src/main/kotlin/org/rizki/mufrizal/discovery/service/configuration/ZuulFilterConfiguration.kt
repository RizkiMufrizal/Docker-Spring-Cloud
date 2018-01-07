package org.rizki.mufrizal.discovery.service.configuration

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.core.env.Environment
import org.springframework.http.HttpHeaders
import java.nio.charset.Charset
import java.util.Base64

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 07 January 2018
 * @Time 15.23
 * @Project Discovery-Service
 * @Package org.rizki.mufrizal.discovery.service.configuration
 * @File ZuulFilterConfiguration
 *
 */

class ZuulFilterConfiguration constructor(private val environment: Environment) : ZuulFilter() {

    override fun run(): Any? {
        val requestContext = RequestContext.getCurrentContext()
        val usernamePassword = "${environment.getRequiredProperty("spring.boot.admin.auth.username")}:${environment.getRequiredProperty("spring.boot.admin.auth.password")}"
        val base64String = Base64.getEncoder().encodeToString(usernamePassword.toByteArray(Charset.defaultCharset()))
        requestContext.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, "Basic $base64String")
        return null
    }

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun filterType(): String {
        return "pre"
    }

    override fun filterOrder(): Int {
        return 1
    }
}