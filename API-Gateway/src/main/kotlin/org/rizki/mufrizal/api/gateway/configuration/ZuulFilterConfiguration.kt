package org.rizki.mufrizal.api.gateway.configuration

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.slf4j.LoggerFactory

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 06 January 2018
 * @Time 22.23
 * @Project API-Gateway
 * @Package org.rizki.mufrizal.api.gateway.configuration
 * @File ZuulFilterConfiguration
 *
 */

class ZuulFilterConfiguration : ZuulFilter() {

    private val logger = LoggerFactory.getLogger(ZuulFilterConfiguration::class.java)

    override fun run(): Any? {
        val requestContext = RequestContext.getCurrentContext()
        val httpServlerRequest = requestContext.request
        requestContext.addZuulRequestHeader("Authorization", httpServlerRequest.getHeader("Authorization"))

        logger.info(String.format("${httpServlerRequest.method} request to ${httpServlerRequest.requestURL}"))
        logger.info(String.format("http header Authorization ${httpServlerRequest.getHeader("Authorization")}"))
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