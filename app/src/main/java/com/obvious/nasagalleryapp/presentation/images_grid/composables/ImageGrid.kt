package com.obvious.nasagalleryapp.presentation.images_grid.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.obvious.nasagalleryapp.core.constants.AppConstants
import com.obvious.nasagalleryapp.domain.models.NasaImage

@Composable
fun ImageList(images: List<NasaImage>, navigateToDetails: (NasaImage) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(AppConstants.DEFAULT_GRID_COLUMNS)) {
        items(images) { image ->
            ImageRow(image, navigateToDetails)
        }
    }
}

@Composable
fun ImageRow(image: NasaImage, navigateToDetails: (NasaImage) -> Unit) {
    AsyncImage(
        modifier = Modifier
            .fillMaxSize()
            .height(AppConstants.DEFAULT_GRID_HEIGHT.dp)
            .clickable { navigateToDetails(image) },
        model = image.url,
        contentDescription = image.title,
        contentScale = ContentScale.Crop
    )
}
