package com.creator.app;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        
        // বেসিক ওয়েবভিউ সেটিংস ও পারফরম্যান্স অপ্টিমাইজেশন
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        webView.setWebViewClient(new WebViewClient());

        // GitHub Actions এই লেখাটিকে ইউজারের দেওয়া URL দিয়ে বদলে দেবে
        String targetUrl = "DEFAULT_URL_HERE";
        webView.loadUrl(targetUrl);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            // কনফার্ম অন এক্সিট ফিচার (অ্যাপ থেকে বের হওয়ার আগে প্রম্পট দেখাবে)
            new AlertDialog.Builder(this)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> super.onBackPressed())
                .setNegativeButton("No", null)
                .show();
        }
    }
}
