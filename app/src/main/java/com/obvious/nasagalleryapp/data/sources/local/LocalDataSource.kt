package com.obvious.nasagalleryapp.data.sources.local

import android.content.Context
import com.obvious.nasagalleryapp.R
import com.obvious.nasagalleryapp.data.entities.NasaImageData
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val moshi: Moshi
) {

    private val localImageList: List<NasaImageData> by lazy {
        val jsonContent = context.resources.openRawResource(R.raw.nasa_pictures)
            .bufferedReader()
            .use { it.readText() }
        val contentType = Types.newParameterizedType(List::class.java, NasaImageData::class.java)
        val adapter = moshi.adapter<List<NasaImageData>>(contentType)
        adapter.fromJson(jsonContent).orEmpty()
    }

    fun getNasaImageList(): List<NasaImageData> {
        return localImageList
    }

    fun getNasaImageMetadata(url: String): NasaImageData? {
        return localImageList.find { it.url == url }
    }
}