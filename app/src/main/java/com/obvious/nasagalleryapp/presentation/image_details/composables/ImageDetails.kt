package com.obvious.nasagalleryapp.presentation.image_details.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.obvious.nasagalleryapp.R
import com.obvious.nasagalleryapp.core.constants.AppConstants
import com.obvious.nasagalleryapp.core.utils.DateUtils
import com.obvious.nasagalleryapp.domain.models.FullNasaImage
import com.obvious.nasagalleryapp.ui.composables.NotFound

@OptIn(ExperimentalPagerApi::class)
@Composable
fun LayoutParent(images: List<FullNasaImage>, selectedUrl: String?) {
    val pagerState = rememberPagerState()
    val scrollState = rememberScrollState()
    val pageIndex = images.indexOfFirst { it.url == selectedUrl }

    HorizontalPager(
        count = images.size, state = pagerState, modifier = Modifier.fillMaxHeight()
    ) { page ->
        val image = images.getOrNull(page)
        if (image == null) {
            NotFound()
        } else {
            Column(modifier = Modifier.fillMaxSize()) {
                BoxWithConstraints {
                    Surface {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .verticalScroll(scrollState),
                        ) {
                            ImageMetadata(
                                image, this@BoxWithConstraints.maxHeight
                            )
                        }
                    }
                }
            }
        }
    }

    LaunchedEffect(pagerState) {
        if (pagerState.pageCount != 0) {
            pagerState.scrollToPage(page = pageIndex)
        }
    }
}

@Composable
fun ImageMetadata(
    image: FullNasaImage, containerHeight: Dp
) {
    val formattedDate = DateUtils.formatLocalDate(image.date)

    FullSizeImage(
        imageUrl = image.url.toString(), containerHeight = containerHeight
    )
    Text(
        text = image.title.toString(),
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(
            start = AppConstants.DEFAULT_PADDING.dp,
            top = AppConstants.DEFAULT_PADDING.dp,
            end = AppConstants.DEFAULT_PADDING.dp,
            bottom = 0.dp,
        )
    )
    Column(
        modifier = Modifier.padding(AppConstants.DEFAULT_PADDING.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppConstants.DEFAULT_PADDING.dp)
        ) {
            Text(
                text = stringResource(
                    id = R.string.lbl_copyright, image.copyright ?: "Unknown"
                ), style = MaterialTheme.typography.body2, modifier = Modifier.weight(1f)
            )
            Text(
                text = formattedDate ?: "",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End,
            )
        }
        SelectionContainer {
            Text(
                text = image.explanation.toString(), style = MaterialTheme.typography.body1
            )
        }
        Spacer(Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
fun FullSizeImage(
    imageUrl: String, containerHeight: Dp
) {
    AsyncImage(
        modifier = Modifier
            .heightIn(max = containerHeight / 3)
            .fillMaxWidth(),
        model = imageUrl,
        contentDescription = imageUrl,
        contentScale = ContentScale.Crop
    )
}