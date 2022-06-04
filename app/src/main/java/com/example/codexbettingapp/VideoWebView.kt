package com.example.codexbettingapp

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.codexbettingapp.ui.theme.CodexBettingTheme
import com.example.codexbettingapp.ui.theme.CodexBlack

@Composable
fun VideoWebView() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(CodexBlack)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(CodexBlack),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CodexNavigationBar()

            AndroidView(factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    loadUrl("https://vimeo.com/710148729")
                }
            }, update = {
                it.loadUrl("https://vimeo.com/710148729")
            })

        }
    }
}

@Composable
fun WabPageView(url: String) {
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }
    }, update = {
        it.loadUrl(url)
    })
}

@Preview(showBackground = true)
@Composable
fun VideoWebViewPreview() {
    CodexBettingTheme {
        VideoWebView()
    }
}

