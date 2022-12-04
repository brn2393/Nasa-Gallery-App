package com.obvious.nasagalleryapp.data.repositories

import com.obvious.nasagalleryapp.data.di.qualifiers.IoDispatcher
import com.obvious.nasagalleryapp.data.mappers.toNasaMetadata
import com.obvious.nasagalleryapp.data.sources.local.LocalDataSource
import com.obvious.nasagalleryapp.domain.models.NasaMetadata
import com.obvious.nasagalleryapp.domain.repositories.ImageDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImageDetailsRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    @IoDispatcher private val defaultDispatcher: CoroutineDispatcher,
    private val dateFormatter: DateTimeFormatter
) : ImageDetailsRepository {

    override suspend fun getImageMetadata(url: String): NasaMetadata? {
        return withContext(defaultDispatcher) {
            localDataSource.getNasaImageMetadata(url)?.toNasaMetadata(dateFormatter)
        }
    }
}