package com.obvious.nasagalleryapp.presentation.images_grid

import com.obvious.nasagalleryapp.domain.base.BaseViewModel
import com.obvious.nasagalleryapp.domain.usecases.GetImagesUseCase

class ImagesGridViewModel(
    private val getImagesUseCase: GetImagesUseCase
) : BaseViewModel() {

}