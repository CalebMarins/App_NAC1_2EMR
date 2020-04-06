package com.example.nac1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        //Instanciando a webview
        android.webkit.WebView wv = findViewById(R.id.webview);
        //Instanciando web browser para a webview
        wv.setWebViewClient(new WebViewClient());

        //Garantir que o js está funcionando
        wv.getSettings().setJavaScriptEnabled(true);

        //Trazendo a mesagem da outra tela
        Intent iRecebe = getIntent();
        Bundle dados = iRecebe.getExtras();

        if(dados != null){
            String url = dados.getString("wv");
            wv.loadUrl(url);}
    }
}
