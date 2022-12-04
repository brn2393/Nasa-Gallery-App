package com.obvious.nasagalleryapp.domain.models

import java.time.LocalDate

data class NasaImage(
    val url: String,
    val title: String,
    val date: LocalDate?,
)
