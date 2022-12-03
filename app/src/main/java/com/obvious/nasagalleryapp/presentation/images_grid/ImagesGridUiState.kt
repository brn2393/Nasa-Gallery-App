package com.obvious.nasagalleryapp.presentation.images_grid

import com.obvious.nasagalleryapp.domain.models.NasaImage

sealed class ImagesGridUiState {
    object Loading : ImagesGridUiState()
    class Success(val images: List<NasaImage>) : ImagesGridUiState()
    class Error(val throwable: Throwable) : ImagesGridUiState()
}