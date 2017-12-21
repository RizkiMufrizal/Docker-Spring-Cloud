package org.rizki.mufrizal.transaction.service.repository

import org.rizki.mufrizal.transaction.service.domain.Penjualan
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 21.11
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.repository
 * @File PenjualanRepository
 *
 */
interface PenjualanRepository : MongoRepository<Penjualan, String> {
    fun findByIdPenjualan(idPenjualan: String): Optional<Penjualan>
}