package com.obvious.nasagalleryapp.data.repositories

import com.obvious.nasagalleryapp.data.di.qualifiers.IoDispatcher
import com.obvious.nasagalleryapp.data.mappers.toNasaImage
import com.obvious.nasagalleryapp.data.sources.local.LocalDataSource
import com.obvious.nasagalleryapp.domain.models.NasaImage
import com.obvious.nasagalleryapp.domain.repositories.ImagesGridRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesGridRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    @IoDispatcher private val defaultDispatcher: CoroutineDispatcher,
    private val dateFormatter: DateTimeFormatter
) : ImagesGridRepository {

    override suspend fun getNasaImages(): List<NasaImage> {
        return withContext(defaultDispatcher) {
            localDataSource.getNasaImageList()
                .map { it.toNasaImage(dateFormatter) }
                .sortedByDescending { it.date }
        }
    }
}