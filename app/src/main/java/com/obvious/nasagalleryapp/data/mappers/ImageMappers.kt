package com.obvious.nasagalleryapp.data.mappers

import com.obvious.nasagalleryapp.data.entities.NasaImageData
import com.obvious.nasagalleryapp.domain.models.NasaImage
import com.obvious.nasagalleryapp.domain.models.NasaMetadata

fun NasaImageData.toNasaImage(): NasaImage {
    return NasaImage(
        url = url.toString()
    )
}

fun NasaImageData.toNasaMetadata(): NasaMetadata {
    return NasaMetadata(
        tag = title.toString()
    )
}