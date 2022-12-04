package com.obvious.nasagalleryapp.presentation.images_grid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.obvious.nasagalleryapp.domain.base.BaseActivity
import com.obvious.nasagalleryapp.domain.models.NasaImage
import com.obvious.nasagalleryapp.ui.composables.Loader
import com.obvious.nasagalleryapp.ui.theme.NASAGalleryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImagesGridActivity : BaseActivity() {

    @Composable
    override fun BuildContent() = ImagesGridPage()
}

@Composable
fun ImagesGridPage(
    viewModel: ImagesGridViewModel = viewModel(),
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
) {
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                viewModel.fetchNasaImages()
            } else if (event == Lifecycle.Event.ON_STOP) {

            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    val uiState = viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        when (val state = uiState.value) {
            ImagesGridUiState.Loading -> Loader()
            is ImagesGridUiState.Success -> ImageList(images = state.images)
            is ImagesGridUiState.Error -> Unit
        }
    }
}

@Composable
fun ImageList(images: List<NasaImage>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(images) { image ->
            ImageRow(image)
        }
    }
}

@Composable
fun ImageRow(image: NasaImage) {
    Text(text = "test ${image.url}")
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