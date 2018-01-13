package org.rizki.mufrizal.admin.dashboard

import de.codecentric.boot.admin.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

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
@EnableAdminServer
class AdminDashboardApplication

fun main(args: Array<String>) {
    SpringApplication.run(AdminDashboardApplication::class.java, *args)
}
