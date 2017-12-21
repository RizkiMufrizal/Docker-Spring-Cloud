package org.rizki.mufrizal.transaction.service

import org.rizki.mufrizal.transaction.service.domain.Penjualan
import org.rizki.mufrizal.transaction.service.domain.PenjualanDetail
import org.rizki.mufrizal.transaction.service.repository.PenjualanDetailRepository
import org.rizki.mufrizal.transaction.service.repository.PenjualanRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.feign.EnableFeignClients
import java.math.BigDecimal
import java.time.LocalDate

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 20.57
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service
 * @File TransactionServiceApplication
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
class TransactionServiceApplication : CommandLineRunner {

    @Autowired
    private lateinit var penjualanDetailRepository: PenjualanDetailRepository

    @Autowired
    private lateinit var penjualanRepository: PenjualanRepository

    override fun run(vararg args: String?) {
        for (i in 1..10) {
            penjualanRepository.save(
                    Penjualan(
                            idPenjualan = i.toString(),
                            namaPembeli = "nama ke $i",
                            tanggalTransaksi = LocalDate.now(),
                            totalHarga = BigDecimal(i * 1000)
                    )
            )
        }
        for (i in 1..10) {
            penjualanDetailRepository.save(
                    PenjualanDetail(
                            idPenjualanDetail = "$i.detail",
                            idPenjualan = i.toString(),
                            idBarang = i.toString(),
                            totalHargaPerBarang = BigDecimal(i * 1000),
                            jumlahBarang = i + 5
                    )
            )
        }
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(TransactionServiceApplication::class.java, *args)
}
