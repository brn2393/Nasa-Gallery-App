package com.obvious.nasagalleryapp.domain.repositories

import com.obvious.nasagalleryapp.domain.base.BaseRepository
import com.obvious.nasagalleryapp.domain.models.NasaMetadata

interface ImageDetailsRepository : BaseRepository {

    suspend fun getImageMetadata(url: String): NasaMetadata?
}