package org.rizki.mufrizal.transaction.service.repository

import org.rizki.mufrizal.transaction.service.domain.PenjualanDetail
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 21.13
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.repository
 * @File PenjualanDetailRepository
 *
 */
interface PenjualanDetailRepository : MongoRepository<PenjualanDetail, String> {
    fun findByIdPenjualanDetail(idPenjualanDetail: String): Optional<PenjualanDetail>
    fun findByIdPenjualan(idPenjualan: String): List<PenjualanDetail>
}