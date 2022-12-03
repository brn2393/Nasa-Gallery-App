package com.obvious.nasagalleryapp.presentation.images_grid

import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.obvious.nasagalleryapp.domain.base.BaseActivity
import com.obvious.nasagalleryapp.ui.theme.NASAGalleryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImagesGridActivity : BaseActivity() {

    @Composable
    override fun BuildContent() {
        ImagesGridPage()
    }
}

@Composable
fun ImagesGridPage(viewModel: ImagesGridViewModel = viewModel()) {
    val uiState = viewModel.uiState.collectAsState()

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NASAGalleryAppTheme {
        Surface {
            ImagesGridPage()
        }
    }
}