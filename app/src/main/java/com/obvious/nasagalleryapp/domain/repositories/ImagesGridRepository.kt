package com.obvious.nasagalleryapp.domain.repositories

import com.obvious.nasagalleryapp.domain.base.BaseRepository
import com.obvious.nasagalleryapp.domain.models.NasaImage
import javax.inject.Inject

class ImagesGridRepository @Inject constructor() : BaseRepository() {

    suspend fun getNasaImages(): List<NasaImage> {
        return emptyList()
    }
}