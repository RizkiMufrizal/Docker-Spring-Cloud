package org.rizki.mufrizal.oauth2.service.repository

import org.rizki.mufrizal.oauth2.service.domain.User
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 05 January 2018
 * @Time 21.20
 * @Project OAuth2-Service
 * @Package org.rizki.mufrizal.oauth2.service.repository
 * @File UserRepository
 *
 */

interface UserRepository : PagingAndSortingRepository<User, String> {
    fun findByUsername(username: String): Optional<User>
}