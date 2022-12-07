package com.obvious.nasagalleryapp.domain.repositories

import com.obvious.nasagalleryapp.domain.base.BaseRepository
import com.obvious.nasagalleryapp.domain.models.FullNasaImage
import com.obvious.nasagalleryapp.domain.models.NasaImage

interface ImagesRepository : BaseRepository {

    suspend fun getNasaImages(): List<NasaImage>

    suspend fun getImagesWithMetadata(): List<FullNasaImage>
}