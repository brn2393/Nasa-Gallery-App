package com.obvious.nasagalleryapp.data.repositories

import android.util.Log
import com.obvious.nasagalleryapp.data.di.qualifiers.IoDispatcher
import com.obvious.nasagalleryapp.data.mappers.toFullNasaImage
import com.obvious.nasagalleryapp.data.mappers.toNasaImage
import com.obvious.nasagalleryapp.data.sources.local.LocalDataSource
import com.obvious.nasagalleryapp.domain.models.FullNasaImage
import com.obvious.nasagalleryapp.domain.models.NasaImage
import com.obvious.nasagalleryapp.domain.repositories.ImagesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

private const val TAG = "ImagesRepositoryImpl"

@Singleton
class ImagesRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    @IoDispatcher private val defaultDispatcher: CoroutineDispatcher,
    private val dateFormatter: DateTimeFormatter
) : ImagesRepository {

    override suspend fun getNasaImages(): List<NasaImage> {
        return withContext(defaultDispatcher) {
            try {
                localDataSource.getNasaImageList()
                    .map { it.toNasaImage(dateFormatter) }
            } catch (exception: Exception) {
                Log.e(TAG, "getNasaImages: ", exception)
                emptyList()
            }
        }
    }

    override suspend fun getImagesWithMetadata(): List<FullNasaImage> {
        return withContext(defaultDispatcher) {
            try {
                localDataSource.getNasaImageList()
                    .map { it.toFullNasaImage(dateFormatter) }
            } catch (exception: Exception) {
                Log.e(TAG, "getImagesWithMetadata: ", exception)
                emptyList()
            }
        }
    }
}