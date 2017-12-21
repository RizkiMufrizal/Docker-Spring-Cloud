package org.rizki.mufrizal.transaction.service.mapping

import java.math.BigDecimal

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 22.02
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.mapping
 * @File PenjualanDetailMapping
 *
 */

data class PenjualanDetailMapping(
        val idPenjualanDetail: String? = null,
        val jumlahBarang: Int? = null,
        val totalHargaPerBarang: BigDecimal? = null,
        val idPenjualan: String? = null,
        val barang: Barang? = null
)