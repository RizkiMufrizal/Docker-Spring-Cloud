package org.rizki.mufrizal.transaction.service.mapping

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 21.55
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.mapping
 * @File Barang
 *
 */

data class Barang(
        val idBarang: Int? = null,
        val namaBarang: String? = null,
        val jenisBarang: String? = null,
        val tanggalKadaluarsa: TanggalKadaluarsa? = null,
        val hargaSatuanBarang: String? = null,
        val jumlahBarangTersedia: Int? = null
)

data class TanggalKadaluarsa(
        val year: Int? = null,
        val month: String? = null,
        val leapYear: Boolean? = null,
        val dayOfMonth: Int? = null,
        val dayOfWeek: String? = null,
        val dayOfYear: Int? = null,
        val era: String? = null,
        val monthValue: Int? = null,
        val chronology: Chronology? = null
)

data class Chronology(
        val calendarType: String? = null,
        val id: String? = null
)