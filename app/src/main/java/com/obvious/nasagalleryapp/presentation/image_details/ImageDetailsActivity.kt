package com.obvious.nasagalleryapp.presentation.image_details

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.obvious.nasagalleryapp.domain.base.BaseActivity
import com.obvious.nasagalleryapp.presentation.images_grid.ImagesGridViewModel
import com.obvious.nasagalleryapp.ui.theme.NASAGalleryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailsActivity : BaseActivity() {

    @Composable
    override fun BuildContent() {
        ImageDetailsPage()
    }
}

@Composable
fun ImageDetailsPage(viewModel: ImagesGridViewModel = viewModel()) {
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NASAGalleryAppTheme {
        Surface {
            ImageDetailsPage()
        }
    }
}