package com.obvious.nasagalleryapp.data.repositories

import com.obvious.nasagalleryapp.domain.models.NasaImage
import com.obvious.nasagalleryapp.domain.repositories.ImagesGridRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesGridRepositoryImpl @Inject constructor() : ImagesGridRepository {

    override suspend fun getNasaImages(): List<NasaImage> {
        return emptyList()
    }
}