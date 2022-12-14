package com.obvious.nasagalleryapp.domain.usecases

import com.obvious.nasagalleryapp.domain.models.NasaImage
import com.obvious.nasagalleryapp.domain.repositories.ImagesRepository
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: ImagesRepository,
) {

    internal suspend operator fun invoke(): List<NasaImage> {
        return repository.getNasaImages().sortedByDescending { it.date }
    }
}