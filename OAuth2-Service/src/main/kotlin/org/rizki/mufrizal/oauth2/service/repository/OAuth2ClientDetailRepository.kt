package org.rizki.mufrizal.oauth2.service.repository

import org.rizki.mufrizal.oauth2.service.domain.OAuth2ClientDetail
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 05 January 2018
 * @Time 21.29
 * @Project OAuth2-Service
 * @Package org.rizki.mufrizal.oauth2.service.repository
 * @File OAuth2ClientDetailRepository
 *
 */

interface OAuth2ClientDetailRepository : PagingAndSortingRepository<OAuth2ClientDetail, String> {
    fun findByClientId(clientId: String): Optional<OAuth2ClientDetail>
}