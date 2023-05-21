package com.example.mad_project.widgets

import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.viewinterop.AndroidView

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
