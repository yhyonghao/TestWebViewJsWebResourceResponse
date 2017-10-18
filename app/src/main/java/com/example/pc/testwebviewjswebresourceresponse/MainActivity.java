package com.example.pc.testwebviewjswebresourceresponse;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    private ProgressDialog mProgressDialog;
    private String TAG = "qijian";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webview);
        mProgressDialog = new ProgressDialog(this);
        mWebView.getSettings().setJavaScriptEnabled(true);


        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                try {
                    if (url.contains("qijian.png")) {
                        Log.d("qqqqqqqqqq","gggggggggggggggggggggggggg");
//                        AssetFileDescriptor fileDescriptor = getAssets().openFd("timg.jpg");
//                        InputStream stream = fileDescriptor.createInputStream();
                        InputStream localCopy = getAssets().open("timg.jpg");
                        WebResourceResponse response = new WebResourceResponse("image/jpg", "UTF-8", localCopy);
                        return response;
                    }
                } catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
                return super.shouldInterceptRequest(view, url);
            }
        });

        mWebView.loadUrl("file:///android_asset/web.html");
    }
}