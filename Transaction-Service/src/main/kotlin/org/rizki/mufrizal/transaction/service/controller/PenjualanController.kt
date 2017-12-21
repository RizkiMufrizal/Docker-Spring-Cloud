package org.rizki.mufrizal.transaction.service.controller

import org.rizki.mufrizal.transaction.service.domain.Penjualan
import org.rizki.mufrizal.transaction.service.repository.PenjualanRepository
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
 * @Time 21.43
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.controller
 * @File PenjualanController
 *
 */
@RestController
@RequestMapping(value = ["/api"])
class PenjualanController @Autowired constructor(val penjualanRepository: PenjualanRepository) {

    @GetMapping(value = ["/penjualans"])
    fun getPenjualans(pageable: Pageable): ResponseEntity<*> {
        return ResponseEntity(penjualanRepository.findAll(pageable), HttpStatus.OK)
    }

    @GetMapping(value = ["/penjualans/{id}"])
    fun getPenjualan(@PathVariable("id") id: String): ResponseEntity<*> {
        return ResponseEntity(penjualanRepository.findByIdPenjualan(id).orElse(Penjualan()), HttpStatus.OK)
    }

}