package com.example.smartwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CctvActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cctv);

        WebView myWebView = (WebView) findViewById(R.id.webView);
        // wide viewport를 사용하도록 설정
        myWebView.getSettings().setUseWideViewPort(true);

// 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
        myWebView.getSettings().setLoadWithOverviewMode(true);

//zoom 허용
        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setSupportZoom(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://dect.tk:9000/?action=stream");
    }
}