package com.obvious.nasagalleryapp.data.di.components

import com.obvious.nasagalleryapp.data.di.modules.AppModule
import com.obvious.nasagalleryapp.data.di.modules.DispatcherModule
import com.obvious.nasagalleryapp.data.di.modules.ImagesModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DispatcherModule::class,
        ImagesModule::class,
    ]
)
internal interface AppComponent 