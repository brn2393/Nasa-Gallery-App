package com.obvious.nasagalleryapp.domain.repositories

import com.obvious.nasagalleryapp.domain.base.BaseRepository
import com.obvious.nasagalleryapp.domain.models.FullNasaImage

interface ImageDetailsRepository : BaseRepository {

    suspend fun getImagesWithMetadata(): List<FullNasaImage>
}