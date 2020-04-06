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

    //Declarando as variáveis
    TextView caleb, app, rm;
    ImageView me_icon, shape_circle_roxo, shape_circle_branco, shape_circle_shadow_me, shape_circle_shadow_dados;
    Animation fromtop, frombottom, frombottom2, fromleft, fromright;
    ImageButton pnlbgSeta, up;



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

        //Instanciando as animações
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        frombottom2 = AnimationUtils.loadAnimation(this, R.anim.frombottom2);
        fromleft = AnimationUtils.loadAnimation(this, R.anim.fromleft);
        fromright = AnimationUtils.loadAnimation(this, R.anim.fromright);
        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);

        //Definindo as animações na tela
        //de cima
        shape_circle_shadow_me.setAnimation(fromtop);
        shape_circle_branco.setAnimation(fromtop);

        //De baixo 1
        me_icon.setAnimation(fromtop);
        shape_circle_roxo.setAnimation(frombottom);
        shape_circle_shadow_dados.setAnimation(frombottom);


        //De baixo 2
        rm.setAnimation(frombottom);

        app.setAnimation(fromright);
        caleb.setAnimation(fromleft);

    }



    public void gotoMain(){
        Intent i = new Intent(Sobre.this, MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
    }



    //Método de clique no botão
    @Override
    public void onClick(View v) {
            this.gotoMain();
    }
}
