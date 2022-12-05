package com.obvious.nasagalleryapp.core.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

object DateUtils {

    fun parseLocalDate(dateString: String?, formatter: DateTimeFormatter): LocalDate? {
        if (dateString.isNullOrBlank()) return null

        return try {
            formatter.parse(dateString)?.let { LocalDate.from(it) }
        } catch (exception: Exception) {
            null
        }
    }

    fun formatLocalDate(date: LocalDate?): String? {
        if (date == null) return null

        return try {
            val formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
            date.format(formatter)
        } catch (exception: Exception) {
            null
        }
    }
}