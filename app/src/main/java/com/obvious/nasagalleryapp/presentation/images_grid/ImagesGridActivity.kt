package com.obvious.nasagalleryapp.presentation.images_grid

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.obvious.nasagalleryapp.core.constants.AppConstants
import com.obvious.nasagalleryapp.domain.base.BaseActivity
import com.obvious.nasagalleryapp.presentation.image_details.ImageDetailsActivity
import com.obvious.nasagalleryapp.presentation.images_grid.composables.ImageList
import com.obvious.nasagalleryapp.ui.composables.Empty
import com.obvious.nasagalleryapp.ui.composables.Loader
import com.obvious.nasagalleryapp.ui.composables.NotFound
import com.obvious.nasagalleryapp.ui.theme.NASAGalleryAppTheme
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "ImagesGridActivity"

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
    val context = LocalContext.current
    val uiState = viewModel.uiState.collectAsState()

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                viewModel.fetchNasaImages()
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        when (val state = uiState.value) {
            ImagesGridUiState.Loading -> Loader()
            ImagesGridUiState.Empty -> Empty()
            is ImagesGridUiState.Success -> ImageList(images = state.images) {
                navigateToDetailsPage(context, it.url)
            }
            is ImagesGridUiState.Error -> {
                Log.e(TAG, "ImagesGridPage: ", state.throwable)
                NotFound()
            }
        }
    }
}

private fun navigateToDetailsPage(context: Context, url: String) {
    Intent(context, ImageDetailsActivity::class.java).apply {
        putExtra(AppConstants.KEY_SELECTED_URL, url)
    }.let {
        context.startActivity(it)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    NASAGalleryAppTheme {
        Surface {
            ImagesGridPage()
        }
    }
}