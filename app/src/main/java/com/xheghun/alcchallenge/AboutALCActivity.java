package com.xheghun.alcchallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALCActivity extends AppCompatActivity {

    WebView about_alc;
    SwipeRefreshLayout swipeRefreshLayout;
    private String mURL = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        about_alc = findViewById(R.id.about_alc_web_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);


        about_alc.loadUrl(mURL);
        swipeRefreshLayout.setOnRefreshListener(() -> about_alc.reload());

        about_alc.getSettings().setJavaScriptEnabled(true);
        about_alc.setHorizontalScrollBarEnabled(false);
        about_alc.canGoBack();
        about_alc.canGoBack();
        about_alc.setWebViewClient(new MyWebViewClient());
    }

    class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            swipeRefreshLayout.setRefreshing(false);
            mURL = url;
            super.onPageFinished(view,url);
        }
    }
}
