package com.obvious.nasagalleryapp.presentation.image_details

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
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
import com.obvious.nasagalleryapp.core.constants.AppConstants
import com.obvious.nasagalleryapp.domain.base.BaseActivity
import com.obvious.nasagalleryapp.presentation.image_details.composables.LayoutParent
import com.obvious.nasagalleryapp.ui.composables.Empty
import com.obvious.nasagalleryapp.ui.composables.Loader
import com.obvious.nasagalleryapp.ui.composables.NotFound
import com.obvious.nasagalleryapp.ui.theme.NASAGalleryAppTheme
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "ImageDetailsActivity"

@AndroidEntryPoint
class ImageDetailsActivity : BaseActivity() {

    private val argSelectedUrl by lazy { intent.getStringExtra(AppConstants.KEY_SELECTED_URL) }

    @Composable
    override fun BuildContent() = ImageDetailsPage(selectedUrl = argSelectedUrl)
}

@Composable
fun ImageDetailsPage(
    viewModel: ImageDetailsViewModel = viewModel(),
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    selectedUrl: String?
) {
    val uiState = viewModel.uiState.collectAsState()

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                viewModel.fetchImageMetadata()
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        when (val state = uiState.value) {
            ImageDetailUiState.Loading -> Loader()
            ImageDetailUiState.Empty -> Empty()
            is ImageDetailUiState.Success -> {
                LayoutParent(state.fullImages, selectedUrl)
            }
            is ImageDetailUiState.Error -> {
                Log.e(TAG, "ImageDetailsPage: ", state.throwable)
                NotFound()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    NASAGalleryAppTheme {
        Surface {
            ImageDetailsPage(selectedUrl = "")
        }
    }
}