package com.obvious.nasagalleryapp.data.repositories

import com.obvious.nasagalleryapp.domain.models.NasaMetadata
import com.obvious.nasagalleryapp.domain.repositories.ImageDetailsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageDetailsRepositoryImpl @Inject constructor() : ImageDetailsRepository {

    override suspend fun getImageMetadata(): NasaMetadata {
        return NasaMetadata("")
    }
}