package com.obvious.nasagalleryapp.domain.usecases

import com.obvious.nasagalleryapp.data.di.qualifiers.IoDispatcher
import com.obvious.nasagalleryapp.domain.base.BaseUseCase
import com.obvious.nasagalleryapp.domain.models.NasaImage
import com.obvious.nasagalleryapp.domain.repositories.ImagesGridRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: ImagesGridRepository,
    @IoDispatcher private val defaultDispatcher: CoroutineDispatcher
) : BaseUseCase<List<NasaImage>>() {

    override suspend fun invoke(): List<NasaImage> {
        return withContext(defaultDispatcher) {
            repository.getNasaImages()
        }
    }
}