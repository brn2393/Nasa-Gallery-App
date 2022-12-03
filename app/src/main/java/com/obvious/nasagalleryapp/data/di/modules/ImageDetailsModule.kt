package com.obvious.nasagalleryapp.data.di.modules

import com.obvious.nasagalleryapp.data.repositories.ImageDetailsRepositoryImpl
import com.obvious.nasagalleryapp.domain.repositories.ImageDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ImageDetailsModule {

    @Binds
    abstract fun bindImageDetailsRepository(imageDetailsRepository: ImageDetailsRepositoryImpl): ImageDetailsRepository
}