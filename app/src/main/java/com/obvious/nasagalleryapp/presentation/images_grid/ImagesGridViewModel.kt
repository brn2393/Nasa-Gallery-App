package com.obvious.nasagalleryapp.presentation.images_grid

import androidx.lifecycle.viewModelScope
import com.obvious.nasagalleryapp.domain.base.BaseViewModel
import com.obvious.nasagalleryapp.domain.usecases.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImagesGridViewModel @Inject constructor(
    private val getImagesUseCase: GetImagesUseCase
) : BaseViewModel() {

    private val _uiState = MutableStateFlow<ImagesGridUiState>(ImagesGridUiState.Loading)
    val uiState: StateFlow<ImagesGridUiState> = _uiState

    fun fetchNasaImages() {
        viewModelScope.launch {
            try {
                getImagesUseCase().also {
                    _uiState.value = ImagesGridUiState.Success(it)
                }
            } catch (error: Exception) {
                _uiState.value = ImagesGridUiState.Error(error)
            }
        }
    }
}