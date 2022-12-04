package com.obvious.nasagalleryapp.presentation.image_details

import com.obvious.nasagalleryapp.domain.models.FullNasaImage

sealed class ImageDetailUiState {
    object Loading : ImageDetailUiState()
    data class Success(val fullImages: List<FullNasaImage>) : ImageDetailUiState()
    data class Error(val throwable: Throwable) : ImageDetailUiState()
}