package com.example.nac1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GestureDetector.OnGestureListener {

    //Váriáveis de elementos do app
    ImageView l_ml, e_ml, l_mgl, e_mgl, l_wm, e_wm, l_ns, e_ns, l_sub, e_sub, pnlbgSeta, up;
    ImageButton btn_ml, btn_mgl, btn_wm, btn_ns, btn_sub;


    //Variáveis de gesto
    private float y1, y2, x1, x2;
    private static int min = 100;
    private GestureDetector gd;

    //Variável para introdução de url
    public String url = "";

    //Bundle para as webviews
    Bundle dados = new Bundle();

    //Declarando variáveis de animação
    Animation frombottom2, frombottom, anim_ml, anim_mgl, anim_wm, anim_ns, anim_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INSTANCIANDO VARÍAVEIS
        //Mercado livre
        btn_ml = (ImageButton) findViewById(R.id.btnMercadoLivre);
        l_ml = (ImageView) findViewById(R.id.mercadolivre_logo);
        e_ml = (ImageView) findViewById(R.id.mercadolivre_escrita);

        //Magalu
        btn_mgl = (ImageButton) findViewById(R.id.btnMagalu);
        l_mgl = (ImageView) findViewById(R.id.magalu_logo);
        e_mgl = (ImageView) findViewById(R.id.magalu_escrita);

        //Webmotors
        btn_wm = (ImageButton) findViewById(R.id.btnWebmotors);
        l_wm = (ImageView) findViewById(R.id.webmotors_logo);
        e_wm = (ImageView) findViewById(R.id.webmotors_escrita);

        //Netshoes
        btn_ns = (ImageButton) findViewById(R.id.btnNetshoes);
        l_ns = (ImageView) findViewById(R.id.netshoes_logo);
        e_ns = (ImageView) findViewById(R.id.netshoes_escrita);

        //Submarino
        btn_sub = (ImageButton) findViewById(R.id.btnSubmarino);
        l_sub = (ImageView) findViewById(R.id.submarino_logo);
        e_sub = (ImageView) findViewById(R.id.subamrino_escita);

        //Sobre
        pnlbgSeta = (ImageView) findViewById(R.id.pnlbgSeta);
        up = (ImageView) findViewById(R.id.btnUp);


        //Inicializando o detector de gesto
        this.gd = new GestureDetector(MainActivity.this , this);

        //Instanciando animações
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        frombottom2 = AnimationUtils.loadAnimation(this, R.anim.frombottom2);
        anim_ml = AnimationUtils.loadAnimation(this, R.anim.anim_ml);
        anim_mgl = AnimationUtils.loadAnimation(this, R.anim.anim_mgl);
        anim_wm = AnimationUtils.loadAnimation(this, R.anim.anim_wm);
        anim_ns = AnimationUtils.loadAnimation(this, R.anim.anim_ns);
        anim_sub = AnimationUtils.loadAnimation(this, R.anim.anim_sub);


        //APLICANDO ANIMAÇÕES

        //Mercado Livre
        btn_ml.setAnimation(anim_ml);
        l_ml.setAnimation(anim_ml);
        e_ml.setAnimation(anim_ml);

        //Magalu
        btn_mgl.setAnimation(anim_mgl);
        l_mgl.setAnimation(anim_mgl);
        e_mgl.setAnimation(anim_mgl);

        //Webmotors
        btn_wm.setAnimation(anim_wm);
        l_wm.setAnimation(anim_wm);
        e_wm.setAnimation(anim_wm);

        //Netshoes
        btn_ns.setAnimation(anim_ns);
        l_ns.setAnimation(anim_ns);
        e_ns.setAnimation(anim_ns);

        //Submarino
        btn_sub.setAnimation(anim_sub);
        l_sub.setAnimation(anim_sub);
        e_sub.setAnimation(anim_sub);

        //Sobre
        pnlbgSeta.setAnimation(frombottom2);
        up.setAnimation(frombottom);
    }

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
    public void webmotors (View v){
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

    //Override de OnClick
    @Override
    public void onClick(View v) {
        this.gotoSobre();
    }
}