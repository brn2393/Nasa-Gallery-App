package com.obvious.nasagalleryapp.data.di.modules

import com.obvious.nasagalleryapp.data.repositories.ImagesGridRepositoryImpl
import com.obvious.nasagalleryapp.domain.repositories.ImagesGridRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ImagesListModule {

    @Binds
    abstract fun bindImagesGridRepository(imagesGridRepository: ImagesGridRepositoryImpl): ImagesGridRepository
}