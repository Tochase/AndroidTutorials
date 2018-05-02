package com.example.sir.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {

    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        String url = getIntent().getExtras().getString("url");
        webview = (WebView) findViewById(R.id.webview);
        // 开启 localStorage
        webview.getSettings().setDomStorageEnabled(true);
        // 设置支持javascript
        webview.getSettings().setJavaScriptEnabled(false);
        // 启动缓存
        webview.getSettings().setAppCacheEnabled(true);
        // 设置缓存模式
        webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        //使用自定义的WebViewClient
        webview.setWebViewClient(new WebViewClient()
        {
            //覆盖shouldOverrideUrlLoading 方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl(url);
    }
}
