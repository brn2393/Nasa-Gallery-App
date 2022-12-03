package com.obvious.nasagalleryapp.domain.usecases

import com.obvious.nasagalleryapp.domain.base.BaseUseCase
import com.obvious.nasagalleryapp.domain.models.NasaMetadata
import com.obvious.nasagalleryapp.domain.repositories.ImageDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetImageMetadataUseCase @Inject constructor(
    private val repository: ImageDetailsRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseUseCase<NasaMetadata>() {

    override suspend fun invoke(): NasaMetadata {
        return withContext(defaultDispatcher) {
            repository.getImageMetadata()
        }
    }
}