package com.obvious.nasagalleryapp.domain.models

import java.time.LocalDate

data class NasaMetadata(
    val tag: String,
    val date: LocalDate?,
)
