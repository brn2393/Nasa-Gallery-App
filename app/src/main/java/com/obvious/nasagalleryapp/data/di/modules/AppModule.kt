package com.obvious.nasagalleryapp.data.di.modules

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.time.format.DateTimeFormatter

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    fun provideDateFormatter(): DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE
}