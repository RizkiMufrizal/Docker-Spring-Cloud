package org.rizki.mufrizal.transaction.service.restclient

import org.rizki.mufrizal.transaction.service.mapping.Barang
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 21.51
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.restclient
 * @File BarangServiceClient
 *
 */
@FeignClient(value = "catalog", fallback = BarangServiceClientFallback::class)
interface BarangServiceClient {
    @RequestMapping(value = ["/api/barangs"], method = [RequestMethod.GET])
    fun getBarangs(pageable: Pageable): Page<Barang>

    @RequestMapping(value = ["/api/barangs/{id}"], method = [RequestMethod.GET])
    fun getBarang(@PathVariable("id") id: String?): Barang
}