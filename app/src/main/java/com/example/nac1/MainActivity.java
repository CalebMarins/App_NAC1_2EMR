package com.example.nac1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GestureDetector.OnGestureListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializando o detector de gesto
        this.gd = new GestureDetector(MainActivity.this , this);
    }


    //Variáveis de gesto
    private float y1, y2, x1, x2;
    private static int min = 100;
    private GestureDetector gd;

    //Variável para introdução de url
    public String url = "";

    //Bundle para as webviews
    Bundle dados = new Bundle();



    //método pra ir para próxiam página
    public void gotoWebview(Bundle b){
        Intent i = new Intent (getApplicationContext(), WebView.class);
        i.putExtras(b);
        startActivity(i);
    }


    //Método para que quando apertar o botão vá para a mercado livre activity
    public void mercadoLivreWeb(View v){
        //Settando url (mercado livre)
        url = "https://www.mercadolivre.com.br";
        dados.putString("wv", url);
        this.gotoWebview(dados);
    }

    //Método para que quando apertar o botão vá para a webmotors activity
    public void buscape (View v){
        //Settando url (webmotors)
        url = "https://www.webmotors.com.br/";
        dados.putString("wv", url);
        this.gotoWebview(dados);
    }

    //Método para que quando apertar o botão vá para a magalu activity
    public void magalu (View v){
        //Settando url (magalu)
        url = "https://www.magazineluiza.com.br";
        dados.putString("wv", url);
        this.gotoWebview(dados);
    }

    //Método para que quando apertar o botão vá para a netshoes activity
    public void netshoes (View v){
        //Settando url (netshoes)
        url = "https://www.netshoes.com.br";
        //Dando ao Bundle
        dados.putString("wv", url);
        this.gotoWebview(dados);
    }

    //Método para que quando apertar o botão vá para a submarino activity
    public void submarino (View v){
        //Settando url(submarino)
        url = "https://www.submarino.com.br";
        dados.putString("wv", url);
        this.gotoWebview(dados);
    }


    //Método para ir para página About
    public void gotoSobre(){
        Intent i = new Intent(MainActivity.this, Sobre.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_up_entrada, R.anim.slide_up_saida);
    }

    //Override de gesto
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gd.onTouchEvent(event);
        switch (event.getAction()){
            //Inicio a detecção do gesto
            case MotionEvent.ACTION_DOWN:
                y1 = event.getY();
                x2 = event.getX();
                break;

            //Finalizando a detecção do gesto
            case MotionEvent.ACTION_UP:
                y2 = event.getY();
                x2 = event.getX();

                float valorY = y2 - y1;
                float valorX = x2 - x1;

                if (Math.abs (valorY)> min){
                    if(y2<y1){
                        this.gotoSobre();
                    }
                }

        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public void onClick(View v) {
        this.gotoSobre();
    }
}
