package com.example.nac1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MercadoLivreWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado_livre_web);

        //Instanciando a webview
        WebView wv = findViewById(R.id.webview);
        //Instanciando web browser para a webview
        wv.setWebViewClient(new WebViewClient());

        //Garantir que o js está funcionando
        wv.getSettings().setJavaScriptEnabled(true);

        //Trazendo a mesagem da outra tela
        Intent iRecebe = getIntent();
        Bundle dados = iRecebe.getExtras();

        if(dados != null){
            int code = dados.getInt("wv");

            if(code==1){
               //Dizendo qual url a webview vai abrir
                wv.loadUrl("https://www.mercadolivre.com.br");
            }
            else if(code==2){
                //Dizendo qual url a webview vai abrir
                wv.loadUrl("https://www.buscape.com.br");
            }

            else if(code==3){
                //Dizendo qual url a webview vai abrir
                wv.loadUrl("https://www.magazineluiza.com.br");
            }

            else if(code==4){
                //Dizendo qual url a webview vai abrir
                wv.loadUrl("https://www.americanas.com.br");
            }

            else if(code==5){
                //Dizendo qual url a webview vai abrir
                wv.loadUrl("https://www.submarino.com.br");
            }
            else{
                //Dizendo qual url a webview vai abrir
                wv.loadUrl("https://www.netshoes.com.br");
            }
        }
    }
}
