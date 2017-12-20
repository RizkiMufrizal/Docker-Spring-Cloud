package org.rizki.mufrizal.catalog.service.domain

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.rizki.mufrizal.catalog.service.helpers.LocalDateDeserializer
import org.rizki.mufrizal.catalog.service.helpers.LocalDateSerializer
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 December 2017
 * @Time 21.14
 * @Project Catalog-Service
 * @Package org.rizki.mufrizal.catalog.service.domain
 * @File Barang
 *
 */

@Entity
@Table(name = "tb_barang")
data class Barang(
        @Id
        @Column(name = "id_barang", length = 36)
        val idBarang: Int? = null,

        @Column(name = "nama_barang", length = 50)
        val namaBarang: String? = null,

        @Enumerated(EnumType.STRING)
        @Column(name = "jenis_barang", length = 5)
        val jenisBarang: JenisBarang? = null,

        @JsonSerialize(using = LocalDateSerializer::class)
        @JsonDeserialize(using = LocalDateDeserializer::class)
        @Column(name = "tanggal_kadaluarsa")
        val tanggalKadaluarsa: LocalDate? = null,

        @Column(name = "harga_satuan_barang")
        val hargaSatuanBarang: BigDecimal? = null,

        @Column(name = "jumlah_barang_tersedia")
        val jumlahBarangTersedia: Int? = null
)