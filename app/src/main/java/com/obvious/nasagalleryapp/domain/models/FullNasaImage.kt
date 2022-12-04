package com.obvious.nasagalleryapp.domain.models

import java.time.LocalDate

data class FullNasaImage(
    val copyright: String?,
    val explanation: String?,
    val date: LocalDate?,
    val hdUrl: String?,
    val mediaType: String?,
    val serviceVersion: String?,
    val title: String?,
    val url: String?
)
