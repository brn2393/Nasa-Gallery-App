package com.obvious.nasagalleryapp.presentation.image_details

import com.obvious.nasagalleryapp.domain.models.NasaMetadata

sealed class ImageDetailUiState {
    object Loading : ImageDetailUiState()
    data class Success(val metadata: NasaMetadata) : ImageDetailUiState()
    data class Error(val throwable: Throwable) : ImageDetailUiState()
}