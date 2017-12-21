package org.rizki.mufrizal.transaction.service.restclient

import org.rizki.mufrizal.transaction.service.mapping.Barang
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 21 December 2017
 * @Time 21.57
 * @Project Transaction-Service
 * @Package org.rizki.mufrizal.transaction.service.restclient
 * @File BarangServiceClientFallback
 *
 */

@Component
class BarangServiceClientFallback : BarangServiceClient {
    override fun getBarangs(pageable: Pageable): Page<Barang> {
        return PageImpl(ArrayList())
    }

    override fun getBarang(id: String?): Barang {
        return Barang()
    }
}