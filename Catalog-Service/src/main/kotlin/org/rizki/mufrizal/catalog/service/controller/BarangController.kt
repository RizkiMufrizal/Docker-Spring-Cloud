package org.rizki.mufrizal.catalog.service.controller

import org.rizki.mufrizal.catalog.service.domain.Barang
import org.rizki.mufrizal.catalog.service.repository.BarangRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 December 2017
 * @Time 21.33
 * @Project Catalog-Service
 * @Package org.rizki.mufrizal.catalog.service.controller
 * @File BarangController
 *
 */
@RestController
@RequestMapping(value = ["/api"])
class BarangController @Autowired constructor(val barangRepository: BarangRepository) {

    @GetMapping(value = ["/barangs"])
    fun getBarangs(pageable: Pageable): ResponseEntity<*> {
        return ResponseEntity(barangRepository.findAll(pageable), HttpStatus.OK)
    }

    @GetMapping(value = ["/barangs/{id}"])
    fun getBarang(@PathVariable("id") id: Int): ResponseEntity<*> {
        return ResponseEntity(barangRepository.findByIdBarang(id).orElse(Barang()), HttpStatus.OK)
    }

    @PostMapping(value = ["/barangs"])
    fun saveBarangs(@RequestBody barang: Barang): ResponseEntity<*> {
        return ResponseEntity(barangRepository.save(barang), HttpStatus.OK)
    }

    @PutMapping(value = ["/barangs/{id}"])
    fun updateBarangs(@PathVariable("id") id: Int, @RequestBody barang: Barang): ResponseEntity<*> {
        barang.copy(idBarang = id)
        return ResponseEntity(barangRepository.save(barang), HttpStatus.OK)
    }

    @DeleteMapping(value = ["/barangs/{id}"])
    fun deleteBarangs(@PathVariable("id") id: Int): ResponseEntity<*> {
        return ResponseEntity(barangRepository.delete(id), HttpStatus.OK)
    }

}