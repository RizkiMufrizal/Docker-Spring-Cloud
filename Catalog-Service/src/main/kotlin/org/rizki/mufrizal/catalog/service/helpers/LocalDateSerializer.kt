package org.rizki.mufrizal.catalog.service.helpers

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.io.IOException
import java.time.LocalDate

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 December 2017
 * @Time 21.23
 * @Project Catalog-Service
 * @Package org.rizki.mufrizal.catalog.service.helpers
 * @File LocalDateSerializer
 *
 */

class LocalDateSerializer : JsonSerializer<LocalDate>() {
    @Throws(IOException::class)
    override fun serialize(localDate: LocalDate?, jsonGenerator: JsonGenerator?, serializerProvider: SerializerProvider?) {
        jsonGenerator?.writeString(localDate?.toString())
    }
}