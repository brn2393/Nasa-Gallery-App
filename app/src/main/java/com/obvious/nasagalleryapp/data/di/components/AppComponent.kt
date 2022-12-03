package com.obvious.nasagalleryapp.data.di.components

import com.obvious.nasagalleryapp.data.di.modules.DispatcherModule
import com.obvious.nasagalleryapp.data.di.modules.ImageDetailsModule
import com.obvious.nasagalleryapp.data.di.modules.ImagesListModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DispatcherModule::class,
        ImagesListModule::class,
        ImageDetailsModule::class,
    ]
)
internal interface AppComponent 