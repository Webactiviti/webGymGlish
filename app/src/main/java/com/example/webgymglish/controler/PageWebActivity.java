package com.example.webgymglish.controler;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.webgymglish.view.MDToast;
import com.example.webgymglish.R;


/**
 * PageWebActivity class
 *
 * Created by Jean-Christophe THEULIER on 02/07/2019.
 */
public class PageWebActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_web);


        //-----------------------------------------
        //  Récupère paramètre URL
        //-----------------------------------------
        Intent intent = getIntent();
        String url = intent.getStringExtra("URL_WEB");


        if (url  != null ){
            WebView webViewPage = findViewById(R.id.wvwPageWeb);
            WebSettings webSettings = webViewPage.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            webSettings.setDomStorageEnabled(true);


            webViewPage.loadUrl(url);
            webViewPage.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView viewx, String urlx) {
                    viewx.loadUrl(urlx);
                    return false;
                }
            });


        } else { // Pas d'url récupéré
            MDToast.makeText(getApplicationContext(),
                    getString(R.string.probleme_url),
                    MDToast.LENGTH_LONG,
                    MDToast.TYPE_ERROR).show();
        }

    }
}
