package org.rizki.mufrizal.transaction.service.controller

import org.rizki.mufrizal.transaction.service.domain.PenjualanDetail
import org.rizki.mufrizal.transaction.service.mapping.PenjualanDetailMapping
import org.rizki.mufrizal.transaction.service.repository.PenjualanDetailRepository
import org.rizki.mufrizal.transaction.service.restclient.BarangServiceClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 21.44
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.controller
 * @File PenjualanDetailController
 *
 */
@RestController
@RequestMapping(value = ["/api"])
class PenjualanDetailController {

    @Autowired
    private lateinit var penjualanDetailRepository: PenjualanDetailRepository

    @Autowired
    private lateinit var barangServiceClient: BarangServiceClient

    @GetMapping(value = ["/penjualandetails"])
    fun getPenjualanDetails(pageable: Pageable): ResponseEntity<*> {
        return ResponseEntity(penjualanDetailRepository.findAll(pageable), HttpStatus.OK)
    }

    @GetMapping(value = ["/penjualandetails/{id}"])
    fun getPenjualanDetail(@PathVariable("id") id: String): ResponseEntity<*> {
        return ResponseEntity(penjualanDetailRepository.findByIdPenjualanDetail(id).orElse(PenjualanDetail()), HttpStatus.OK)
    }

    @GetMapping(value = ["/penjualan/penjualandetails/{id}"])
    fun getPenjualanDetailByIdPenjualan(@PathVariable("id") id: String): ResponseEntity<*> {
        val penjualanDetails = penjualanDetailRepository.findByIdPenjualan(id)
        val penjualanDetailsMapping = arrayListOf<PenjualanDetailMapping>()

        penjualanDetails.forEach {
            penjualanDetailsMapping.add(
                    PenjualanDetailMapping(
                            idPenjualanDetail = it.idPenjualanDetail,
                            idPenjualan = it.idPenjualan,
                            jumlahBarang = it.jumlahBarang,
                            totalHargaPerBarang = it.totalHargaPerBarang,
                            barang = it.idBarang?.let { it1 -> barangServiceClient.getBarang(it1) }
                    )
            )
        }

        return ResponseEntity(penjualanDetailsMapping, HttpStatus.OK)
    }

}