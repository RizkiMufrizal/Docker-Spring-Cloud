package org.rizki.mufrizal.admin.dashboard.configuration

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.core.env.Environment
import java.nio.charset.Charset
import java.util.Base64

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 13 January 2018
 * @Time 18.50
 * @Project Admin-Dashboard
 * @Package org.rizki.mufrizal.admin.dashboard.configuration
 * @File ZuulFilterConfiguration
 *
 */

class ZuulFilterConfiguration constructor(private val environment: Environment) : ZuulFilter() {

    override fun run(): Any? {
        val requestContext = RequestContext.getCurrentContext()
        val usernamePassword = "${environment.getRequiredProperty("spring.boot.admin.client.metadata.user.name")}:${environment.getRequiredProperty("spring.boot.admin.client.metadata.user.password")}"
        val usernamePasswordBase64 = Base64.getEncoder().encodeToString(usernamePassword.toByteArray(Charset.defaultCharset()))
        requestContext.addZuulRequestHeader("Authorization", "Basic $usernamePasswordBase64")
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