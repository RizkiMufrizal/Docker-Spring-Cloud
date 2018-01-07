package org.rizki.mufrizal.discovery.service

import com.fasterxml.jackson.core.Base64Variants
import org.springframework.beans.factory.InitializingBean
import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.http.HttpHeaders
import java.nio.charset.StandardCharsets

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 07 January 2018
 * @Time 18.13
 * @Project Discovery-Service
 * @Package org.rizki.mufrizal.discovery.service
 * @File BasicAuthFilter
 *
 */

class BasicAuthFilter : ZuulFilter(), InitializingBean {

    private var username: String? = null
    private var password: String? = null
    private var encodedAuth: String? = null

    override fun shouldFilter(): Boolean {
        return true
    }

    override fun filterOrder(): Int {
        return 0
    }

    override fun filterType(): String {
        return "pre"
    }

    override fun run(): Any? {
        val ctx = RequestContext.getCurrentContext()
        ctx.addZuulRequestHeader(HttpHeaders.AUTHORIZATION, encodedAuth)
        return null
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun setUsername(username: String) {
        this.username = username
    }

    @Throws(Exception::class)
    override fun afterPropertiesSet() {
        val auth = username + ":" + password
        encodedAuth = "Basic " + Base64Variants.MIME_NO_LINEFEEDS.encode(auth.toByteArray(StandardCharsets.US_ASCII))
    }
}