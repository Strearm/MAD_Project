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


