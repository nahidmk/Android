package com.example.web_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
 private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.web);
        webView.loadUrl("http://ums.seu.edu.bd/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
        {
            webView.goBack();
        }else
        {
            super.onBackPressed();
        }
    }
}
