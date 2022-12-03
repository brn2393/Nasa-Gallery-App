package com.obvious.nasagalleryapp.domain.usecases

import com.obvious.nasagalleryapp.domain.models.NasaMetadata
import com.obvious.nasagalleryapp.domain.repositories.ImageDetailsRepository
import javax.inject.Inject

class GetImageMetadataUseCase @Inject constructor(
    private val repository: ImageDetailsRepository,
) {

    internal suspend operator fun invoke(input: String): NasaMetadata? {
        return repository.getImageMetadata(input)
    }
}