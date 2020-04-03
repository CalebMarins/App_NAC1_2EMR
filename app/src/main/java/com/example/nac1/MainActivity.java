package com.example.nac1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Variável para métodos
    public int nEscolhido = 0;
    //Bundle para as webviews
    Bundle dados = new Bundle();

    //método pra ir para próxiam página
    public void nextPage(Bundle b){
        Intent i = new Intent (getApplicationContext(), MercadoLivreWeb.class);
        i.putExtras(b);
        startActivity(i);
    }


    //Método para que quando apertar o botão vá para a mercado livre activity
    public void mercadoLivreWeb(View v){
        //Settando o número escolhido para 1 (mercado livre)
        nEscolhido = 1;
        dados.putInt("wv", nEscolhido);
        this.nextPage(dados);
    }

    //Método para que quando apertar o botão vá para a buscapé activity
    public void buscape (View v){
        //Settando o número escolhido para 2 (buscapé)
        nEscolhido = 2;
        dados.putInt("wv", nEscolhido);
        this.nextPage(dados);
    }

    //Método para que quando apertar o botão vá para a magalu activity
    public void magalu (View v){
        //Settando o número escolhido para 3 (magalu)
        nEscolhido =3;
        dados.putInt("wv", nEscolhido);
        this.nextPage(dados);
    }

    //Método para que quando apertar o botão vá para a Americanas activity
    public void americanas (View v){
        //Settando o número escolhido para 4 (americanas)
        nEscolhido = 4;
        dados.putInt("wv", nEscolhido);
        this.nextPage(dados);
    }

    //Método para que quando apertar o botão vá para a submarino activity
    public void submarino (View v){
        //Settando o número escolhido para 5 (submarino)
        nEscolhido= 5;
        dados.putInt("wv", nEscolhido);
        this.nextPage(dados);
    }

    //Método para que quando apertar o botão vá para a netshoes activity
    public void netshoes (View v){
        //Settando o número escolhido para 6 (netshoes)
        nEscolhido = 6;
        //Dando ao Bundle
        dados.putInt("wv", nEscolhido);
        this.nextPage(dados);
    }

    //Método Sobre
    public void sobre(View v){
        Intent i = new Intent(this, Sobre.class);
        startActivity(i);
    }
}
