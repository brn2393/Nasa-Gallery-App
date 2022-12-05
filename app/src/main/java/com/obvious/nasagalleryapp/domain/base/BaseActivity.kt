package com.obvious.nasagalleryapp.domain.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat
import com.obvious.nasagalleryapp.R
import com.obvious.nasagalleryapp.ui.theme.NASAGalleryAppTheme

abstract class BaseActivity : ComponentActivity() {

    @Composable
    protected abstract fun BuildContent()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContent {
            NASAGalleryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val scrollBehavior =
                        TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

                    Scaffold(
                        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                        topBar = {
                            CenterAlignedTopAppBar(
                                title = { Text(text = stringResource(id = R.string.app_name)) },
                                scrollBehavior = scrollBehavior
                            )
                        },
                    ) {
                        Box(modifier = Modifier.padding(it)) {
                            BuildContent()
                        }
                    }
                }
            }
        }
    }
}