package com.russrezepov.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detailed extends AppCompatActivity {

    TextView tvTitle,tvTime,tvSource,tvDesc;
    WebView webView;
    ImageView imageView;
    ProgressBar webViewLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        tvTitle = findViewById(R.id.tvTitle);
        tvTime = findViewById(R.id.tvDate);
        tvSource = findViewById(R.id.tvSource);
        tvDesc = findViewById(R.id.tvDesc);
        webView = findViewById(R.id.webView);
        imageView = findViewById(R.id.imageView);
        webViewLoader = findViewById(R.id.webViewLoader);

        webViewLoader.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
        String time = intent.getStringExtra("time");
        String desc = intent.getStringExtra("desc");
        String imageUrl = intent.getStringExtra("imageUrl");
        String url = intent.getStringExtra("url");

        tvTitle.setText(title);
        tvTime.setText(time);
        tvSource.setText(source);
        tvDesc.setText(desc);
        //Loading an image from the URL
        Picasso.with(Detailed.this).load(imageUrl).into(imageView);;

        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);

        if (webView.isShown()){
            webViewLoader.setVisibility(View.INVISIBLE);
        }

    }
}
