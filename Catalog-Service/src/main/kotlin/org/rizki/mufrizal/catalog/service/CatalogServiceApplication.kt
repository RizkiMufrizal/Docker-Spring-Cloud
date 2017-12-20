package org.rizki.mufrizal.catalog.service

import org.rizki.mufrizal.catalog.service.domain.Barang
import org.rizki.mufrizal.catalog.service.domain.JenisBarang
import org.rizki.mufrizal.catalog.service.repository.BarangRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import java.math.BigDecimal
import java.time.LocalDate

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 December 2017
 * @Time 20.58
 * @Project Catalog-Service
 * @Package org.rizki.mufrizal.catalog.service
 * @File CatalogServiceApplication1
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
class CatalogServiceApplication @Autowired constructor(val barangRepository: BarangRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        barangRepository.deleteAll()
        for (i in 1..10) {
            barangRepository.save(
                    Barang(
                            idBarang = i,
                            namaBarang = "Barang $i",
                            jenisBarang = if (i % 2 == 0) JenisBarang.cair else JenisBarang.gas,
                            hargaSatuanBarang = BigDecimal(i * 5000),
                            jumlahBarangTersedia = i + 5,
                            tanggalKadaluarsa = LocalDate.now()
                    )
            )
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(CatalogServiceApplication::class.java, *args)
}