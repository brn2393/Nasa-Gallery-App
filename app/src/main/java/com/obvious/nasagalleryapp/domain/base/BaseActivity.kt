package com.obvious.nasagalleryapp.domain.base

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.obvious.nasagalleryapp.ui.theme.NASAGalleryAppTheme

abstract class BaseActivity : ComponentActivity() {

    @Composable
    protected abstract fun BuildContent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NASAGalleryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    BuildContent()
                }
            }
        }
    }
}

fun showToast(context: Context, text: String) {
    Toast.makeText(context, text, Toast.LENGTH_LONG).show()
}

fun showToast(context: Context, textRes: Int) {
    Toast.makeText(context, textRes, Toast.LENGTH_LONG).show()
}