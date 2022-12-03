package com.obvious.nasagalleryapp.presentation.image_details

import androidx.lifecycle.viewModelScope
import com.obvious.nasagalleryapp.domain.base.BaseViewModel
import com.obvious.nasagalleryapp.domain.usecases.GetImageMetadataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageDetailsViewModel @Inject constructor(
    private val getImageMetadataUseCase: GetImageMetadataUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<ImageDetailUiState>(ImageDetailUiState.Loading)
    val uiState: StateFlow<ImageDetailUiState> = _uiState

    fun fetchNasaMetadata(urlExtra: String) {
        viewModelScope.launch {
            try {
                getImageMetadataUseCase(urlExtra)?.also {
                    _uiState.value = ImageDetailUiState.Success(it)
                }
            } catch (error: Exception) {
                _uiState.value = ImageDetailUiState.Error(error)
            }
        }
    }
}