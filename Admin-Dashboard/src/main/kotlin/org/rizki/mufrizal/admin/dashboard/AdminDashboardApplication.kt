package org.rizki.mufrizal.admin.dashboard

import de.codecentric.boot.admin.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.context.config.annotation.RefreshScope

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 13 January 2018
 * @Time 17.46
 * @Project Admin-Dashboard
 * @Package org.rizki.mufrizal.admin.dashboard
 * @File AdminDashboardApplication
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
@RefreshScope
class AdminDashboardApplication

fun main(args: Array<String>) {
    SpringApplication.run(AdminDashboardApplication::class.java, *args)
}
