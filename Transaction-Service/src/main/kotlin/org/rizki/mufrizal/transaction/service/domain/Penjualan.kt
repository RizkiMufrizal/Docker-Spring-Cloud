package org.rizki.mufrizal.transaction.service.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.math.BigDecimal
import java.time.LocalDate

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 21.03
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.domain
 * @File PenjualanRepository
 *
 */

@Document(collection = "tb_penjualan")
data class Penjualan(
        @Id
        @Field
        val idPenjualan: String? = null,
        @Field
        val tanggalTransaksi: LocalDate? = null,
        @Field
        val namaPembeli: String? = null,
        @Field
        val totalHarga: BigDecimal? = null
)