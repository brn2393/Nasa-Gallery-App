package com.obvious.nasagalleryapp.data.di.modules

import com.obvious.nasagalleryapp.data.repositories.ImagesRepositoryImpl
import com.obvious.nasagalleryapp.domain.repositories.ImagesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ImagesModule {

    @Binds
    abstract fun bindImagesRepository(imagesRepository: ImagesRepositoryImpl): ImagesRepository
}