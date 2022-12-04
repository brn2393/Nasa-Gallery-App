package com.obvious.nasagalleryapp.presentation.image_details

import androidx.lifecycle.viewModelScope
import com.obvious.nasagalleryapp.domain.base.BaseViewModel
import com.obvious.nasagalleryapp.domain.usecases.GetImagesWithMetadataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageDetailsViewModel @Inject constructor(
    private val getImagesWithMetadataUseCase: GetImagesWithMetadataUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<ImageDetailUiState>(ImageDetailUiState.Loading)
    val uiState: StateFlow<ImageDetailUiState> = _uiState

    fun fetchImageMetadata() {
        viewModelScope.launch {
            try {
                getImagesWithMetadataUseCase().also {
                    _uiState.value = ImageDetailUiState.Success(it)
                }
            } catch (error: Exception) {
                _uiState.value = ImageDetailUiState.Error(error)
            }
        }
    }
}