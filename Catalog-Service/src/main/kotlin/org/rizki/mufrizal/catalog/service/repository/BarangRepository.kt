package org.rizki.mufrizal.catalog.service.repository

import org.rizki.mufrizal.catalog.service.domain.Barang
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 December 2017
 * @Time 21.30
 * @Project Catalog-Service
 * @Package org.rizki.mufrizal.catalog.service.repository
 * @File BarangRepository
 *
 */
interface BarangRepository : PagingAndSortingRepository<Barang, Int> {
    fun findByIdBarang(idBarang: Int): Optional<Barang>
}