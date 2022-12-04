package com.obvious.nasagalleryapp.data.mappers

import com.obvious.nasagalleryapp.core.utils.DateUtils
import com.obvious.nasagalleryapp.data.entities.NasaImageData
import com.obvious.nasagalleryapp.domain.models.FullNasaImage
import com.obvious.nasagalleryapp.domain.models.NasaImage
import java.time.format.DateTimeFormatter

fun NasaImageData.toNasaImage(formatter: DateTimeFormatter): NasaImage {
    return NasaImage(
        url = url.toString(),
        title = title.toString(),
        date = DateUtils.parseLocalDate(date, formatter),
    )
}

fun NasaImageData.toFullNasaImage(formatter: DateTimeFormatter): FullNasaImage {
    return FullNasaImage(
        copyright = copyright,
        explanation = explanation,
        date = DateUtils.parseLocalDate(date, formatter),
        hdUrl = hdurl,
        mediaType = media_type,
        serviceVersion = service_version,
        title = title,
        url = url,
    )
}