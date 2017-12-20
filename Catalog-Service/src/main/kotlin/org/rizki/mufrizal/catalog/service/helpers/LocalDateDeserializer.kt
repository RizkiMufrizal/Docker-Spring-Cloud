package org.rizki.mufrizal.catalog.service.helpers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.io.IOException
import java.time.LocalDate

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 20 December 2017
 * @Time 21.20
 * @Project Catalog-Service
 * @Package org.rizki.mufrizal.catalog.service.helpers
 * @File LocalDateDeserializer
 *
 */
class LocalDateDeserializer : JsonDeserializer<LocalDate>() {
    @Throws(IOException::class)
    override fun deserialize(jsonParser: JsonParser?, deserializationContext: DeserializationContext?): LocalDate {
        return LocalDate.parse(jsonParser?.text)
    }
}