package org.rizki.mufrizal.transaction.service.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.math.BigDecimal

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 21.07
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.domain
 * @File PenjualanDetail
 *
 */

@Document(collection = "tb_penjualan_detail")
data class PenjualanDetail(
        @Id
        @Field
        val idPenjualanDetail: String? = null,
        @Field
        val jumlahBarang: Int? = null,
        @Field
        val totalHargaPerBarang: BigDecimal? = null,
        @Field
        val idPenjualan: String? = null,
        @Field
        val idBarang: String? = null
)