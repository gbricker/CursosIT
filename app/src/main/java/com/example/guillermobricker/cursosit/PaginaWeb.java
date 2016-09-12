package com.example.guillermobricker.cursosit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class PaginaWeb extends AppCompatActivity {

    private WebView wv_Viewer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_web);

        wv_Viewer = (WebView) findViewById(R.id.wv_Viewer);

        wv_Viewer.loadUrl("http://www.it-okcenter.com/calendario/");
    }
}
