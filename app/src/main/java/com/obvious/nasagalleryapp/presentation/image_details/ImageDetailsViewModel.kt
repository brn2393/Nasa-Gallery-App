package com.obvious.nasagalleryapp.presentation.image_details

import com.obvious.nasagalleryapp.domain.base.BaseViewModel
import com.obvious.nasagalleryapp.domain.usecases.GetImageMetadataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageDetailsViewModel @Inject constructor(
    private val getImageMetadataUseCase: GetImageMetadataUseCase
) : BaseViewModel() {

}