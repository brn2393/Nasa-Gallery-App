package com.obvious.nasagalleryapp.domain.repositories

import com.obvious.nasagalleryapp.domain.base.BaseRepository
import com.obvious.nasagalleryapp.domain.models.NasaImage

interface ImagesGridRepository : BaseRepository {

    suspend fun getNasaImages(): List<NasaImage>
}