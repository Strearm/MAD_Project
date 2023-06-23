package com.example.mad_project.widgets

import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.mad_project.relax.RelaxTechnique
import com.example.mad_project.relax.getRelaxTechnique
import kotlinx.coroutines.delay
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView

@Composable
fun WebView(videoUrl: String) {
    AndroidView(factory = { context ->
        WebView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            settings.javaScriptEnabled = true  // Enable JavaScript
            loadUrl(videoUrl)
        }
    })
}

@Composable
fun WebViewWrapper(videoUrl: String) {
    val key = remember { mutableStateOf(videoUrl) }
    LaunchedEffect(videoUrl) {
        key.value = videoUrl
    }

    Box(modifier = Modifier.fillMaxWidth().height(200.dp)) {
        WebView(videoUrl = videoUrl)
    }
}

fun filterVideoUrls(relaxTechnique: RelaxTechnique, relaxTechniques: List<RelaxTechnique>): List<String> {
    return relaxTechniques.find { it.id == relaxTechnique.id }?.videoUrl.orEmpty()
        .map { "https://www.youtube.com/embed/$it" }
}




