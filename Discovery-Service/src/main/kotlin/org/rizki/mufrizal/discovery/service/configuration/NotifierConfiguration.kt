package org.rizki.mufrizal.discovery.service.configuration

import de.codecentric.boot.admin.notify.Notifier
import de.codecentric.boot.admin.notify.RemindingNotifier
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import org.springframework.context.annotation.Primary
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.util.concurrent.TimeUnit


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 07 January 2018
 * @Time 01.22
 * @Project Discovery-Service
 * @Package org.rizki.mufrizal.discovery.service.configuration
 * @File NotifierConfiguration
 *
 */

@Configuration
@EnableScheduling
class NotifierConfiguration @Autowired constructor(@Lazy val notifier: Notifier) {

    @Bean
    @Primary
    fun remindingNotifier(): RemindingNotifier {
        val remindingNotifier = RemindingNotifier(notifier)
        remindingNotifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(5))
        return remindingNotifier
    }

    @Scheduled(fixedRate = 60_000L)
    fun reminder() {
        this.remindingNotifier().sendReminders()
    }
}