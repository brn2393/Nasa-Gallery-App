package com.obvious.nasagalleryapp.core.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtils {

    fun parseLocalDate(dateString: String?, formatter: DateTimeFormatter): LocalDate? {
        if (dateString.isNullOrBlank()) return null

        return try {
            formatter.parse(dateString)?.let { LocalDate.from(it) }
        } catch (exception: Exception) {
            null
        }
    }
}