package com.obvious.nasagalleryapp.ui.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.obvious.nasagalleryapp.R

@Composable
fun NotFound() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.not_found))
    LottieAnimation(composition = composition)
}