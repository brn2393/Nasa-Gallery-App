package com.obvious.nasagalleryapp.data.mappers

import com.obvious.nasagalleryapp.core.utils.DateUtils
import com.obvious.nasagalleryapp.data.entities.NasaImageData
import com.obvious.nasagalleryapp.domain.models.NasaImage
import com.obvious.nasagalleryapp.domain.models.NasaMetadata
import java.time.format.DateTimeFormatter

fun NasaImageData.toNasaImage(formatter: DateTimeFormatter): NasaImage {
    return NasaImage(
        url = url.toString(),
        title = title.toString(),
        date = DateUtils.parseLocalDate(date, formatter),
    )
}

fun NasaImageData.toNasaMetadata(formatter: DateTimeFormatter): NasaMetadata {
    return NasaMetadata(
        tag = title.toString(),
        date = DateUtils.parseLocalDate(date, formatter),
    )
}