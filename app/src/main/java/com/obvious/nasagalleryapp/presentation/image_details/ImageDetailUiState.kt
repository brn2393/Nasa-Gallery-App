package com.obvious.nasagalleryapp.presentation.image_details

import com.obvious.nasagalleryapp.domain.models.NasaMetadata

sealed class ImageDetailUiState {
    object Loading : ImageDetailUiState()
    class Success(val metadata: NasaMetadata) : ImageDetailUiState()
    class Error(val throwable: Throwable) : ImageDetailUiState()
}