package com.omelchenkoaleks.airplane;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BrowserActivity extends AppCompatActivity {
    private WebView mWebView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWebView = new WebView(this);
        setContentView(mWebView);

        mWebView.loadUrl("https://www.google.com");
        mWebView.setWebViewClient(new WebViewClient());
    }
}
