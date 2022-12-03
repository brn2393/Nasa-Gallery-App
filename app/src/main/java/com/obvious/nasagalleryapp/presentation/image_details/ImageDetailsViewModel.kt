package com.obvious.nasagalleryapp.presentation.image_details

import com.obvious.nasagalleryapp.domain.base.BaseViewModel
import com.obvious.nasagalleryapp.domain.usecases.GetImageMetadataUseCase

class ImageDetailsViewModel(
    private val getImageMetadataUseCase: GetImageMetadataUseCase
) : BaseViewModel() {

}