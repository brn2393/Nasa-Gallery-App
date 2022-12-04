package com.obvious.nasagalleryapp.domain.usecases

import com.obvious.nasagalleryapp.domain.models.FullNasaImage
import com.obvious.nasagalleryapp.domain.repositories.ImageDetailsRepository
import javax.inject.Inject

class GetImagesWithMetadataUseCase @Inject constructor(
    private val repository: ImageDetailsRepository,
) {

    internal suspend operator fun invoke(): List<FullNasaImage> {
        return repository.getImagesWithMetadata()
    }
}