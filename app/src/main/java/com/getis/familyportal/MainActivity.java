package com.getis.familyportal;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebResourceRequest;
import android.view.View;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.Gravity;

public class MainActivity extends Activity {
    private static final String APP_URL = "https://getis-family-portal.levantusgetis.workers.dev/";
    private WebView webView;
    private ProgressBar progress;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setStatusBarColor(Color.rgb(16,16,20));
        getWindow().setNavigationBarColor(Color.BLACK);
        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.rgb(16,16,20));
        webView = new WebView(this);
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        s.setLoadsImagesAutomatically(true);
        s.setAllowFileAccess(false);
        s.setMixedContentMode(WebSettings.MIXED_CONTENT_NEVER_ALLOW);
        webView.setWebViewClient(new WebViewClient() {
            @Override public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String host = request.getUrl().getHost();
                if (host != null && (host.equals("getis-family-portal.levantusgetis.workers.dev") || host.endsWith(".workers.dev"))) return false;
                return false;
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override public void onProgressChanged(WebView view, int value) {
                progress.setProgress(value);
                progress.setVisibility(value >= 100 ? View.GONE : View.VISIBLE);
            }
        });
        progress = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        progress.setMax(100);
        FrameLayout.LayoutParams pp = new FrameLayout.LayoutParams(-1, 4, Gravity.TOP);
        root.addView(webView, new FrameLayout.LayoutParams(-1,-1));
        root.addView(progress, pp);
        setContentView(root);
        if (state == null) webView.loadUrl(APP_URL); else webView.restoreState(state);
    }
    @Override protected void onSaveInstanceState(Bundle out) { super.onSaveInstanceState(out); webView.saveState(out); }
    @Override public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack(); else super.onBackPressed();
    }
}
