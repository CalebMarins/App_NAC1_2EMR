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
import android.widget.TextView;

public class Sobre extends AppCompatActivity implements View.OnClickListener {

    //Variável para introdução de url
    public String url = "";

    //Bundle para as webviews
    Bundle dados = new Bundle();

    //Declarando as variáveis
    TextView caleb, app, rm;
    ImageView me_icon, shape_circle_roxo, shape_circle_branco, shape_circle_shadow_me, shape_circle_shadow_dados;
    Animation fromtop, frombottom, fromleft, fromright, anim_github;
    ImageButton insta, github, linkedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        //Trazendo o intent da última página
        Intent i = getIntent();

        //Instanciando variáveis
        caleb = (TextView) findViewById(R.id.txtCaleb);
        app = (TextView) findViewById(R.id.txtApp);
        rm = (TextView) findViewById(R.id.txtRm);
        me_icon = (ImageView) findViewById(R.id.img_me);
        shape_circle_branco = (ImageView) findViewById(R.id.shape_circle_branco);
        shape_circle_roxo = (ImageView) findViewById(R.id.shape_circle_roxo);
        shape_circle_shadow_me = (ImageView) findViewById(R.id.shape_circle_shadow_me);
        shape_circle_shadow_dados = (ImageView) findViewById(R.id.shape_circle_shadow_dados);
        insta = (ImageButton) findViewById(R.id.insta);
        github = (ImageButton) findViewById(R.id.github);
        linkedin = (ImageButton) findViewById(R.id.linkedin);

        //Instanciando as animações
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromleft = AnimationUtils.loadAnimation(this, R.anim.fromleft);
        fromright = AnimationUtils.loadAnimation(this, R.anim.fromright);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        anim_github = AnimationUtils.loadAnimation(this, R.anim.anim_github);

        //Definindo as animações na tela
        //de cima
        shape_circle_shadow_me.setAnimation(fromtop);
        shape_circle_branco.setAnimation(fromtop);
        me_icon.setAnimation(fromtop);

        github.setAnimation(anim_github);

        //De baixo
        shape_circle_roxo.setAnimation(frombottom);
        shape_circle_shadow_dados.setAnimation(frombottom);
        rm.setAnimation(frombottom);

        //Da direita
        app.setAnimation(fromright);
        linkedin.setAnimation(fromright);

        //Da esquerda
        caleb.setAnimation(fromleft);
        insta.setAnimation(fromleft);
    }

    public void backtoMain(){
        Intent i = new Intent(Sobre.this, MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
    }


    //método pra ir para próxiam página
    public void gotoWebview(Bundle b){
        Intent i = new Intent (getApplicationContext(), WebView.class);
        i.putExtras(b);
        startActivity(i);
    }

    //Método para que quando apertar o botão vá para o meu insta
    public void insta(View v){
        //Settando url (mercado livre)
        url = "https://www.instagram.com/caleb__marins/";
        dados.putString("wv", url);
        this.gotoWebview(dados);
    }

    //Método para que quando apertar o botão vá para o meu github
    public void github(View v){
        //Settando url (mercado livre)
        url = "https://github.com/CalebMarins";
        dados.putString("wv", url);
        this.gotoWebview(dados);
    }

    //Método para que quando apertar o botão vá para o meu linkedin
    public void linkedin(View v){
        //Settando url (mercado livre)
        url = "https://www.linkedin.com/in/caleb-marins-17a39815a/";
        dados.putString("wv", url);
        this.gotoWebview(dados);
    }

    //Método de clique no botão
    @Override
    public void onClick(View v) {
            this.backtoMain();
    }
}
