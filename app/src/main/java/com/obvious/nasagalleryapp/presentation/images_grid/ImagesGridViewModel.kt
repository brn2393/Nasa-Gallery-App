package com.obvious.nasagalleryapp.presentation.images_grid

import com.obvious.nasagalleryapp.domain.base.BaseViewModel
import com.obvious.nasagalleryapp.domain.usecases.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImagesGridViewModel @Inject constructor(
    private val getImagesUseCase: GetImagesUseCase
) : BaseViewModel() {

}