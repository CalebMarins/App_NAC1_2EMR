package com.example.nac1;

import android.app.Activity;
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

public class Sobre extends AppCompatActivity implements View.OnClickListener, GestureDetector.OnGestureListener {

    //Declarando as variáveis
    TextView caleb, app;
    ImageView me_icon;
    Animation frombottom, frombottom2, fromleft, fromright;
    View pnlDados;
    ImageButton up;

    //Variáveis de gesto
    private float y1, y2;
    private static int min = 150;
    private GestureDetector gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);
        //Trazendo o intent da última página
        Intent i = getIntent();

        //Instanciando variáveis
        caleb = (TextView) findViewById(R.id.txtCaleb);
        app = (TextView) findViewById(R.id.txtApp);
        me_icon = (ImageView) findViewById(R.id.img_me);
        pnlDados = (View) findViewById(R.id.pnlDados);
        up = (ImageButton) findViewById(R.id.btnUp);

        up.setOnClickListener(this);

        //Inicializando o detector de gesto
        this.gd = new GestureDetector(Sobre.this , this);
        //Instanciando as animações
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        frombottom2 = AnimationUtils.loadAnimation(this, R.anim.frombottom2);
        fromleft = AnimationUtils.loadAnimation(this, R.anim.fromleft);
        fromright = AnimationUtils.loadAnimation(this, R.anim.fromright);

        //Definindo as animações na tela
        me_icon.setAnimation(frombottom);
        pnlDados.setAnimation(frombottom2);
        caleb.setAnimation(fromleft);
        caleb.setAnimation(frombottom);
        app.setAnimation(fromright);

    }

    public void nextPage(){
        Intent i = new Intent(Sobre.this, AboutMe.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_entrada, R.anim.slide_saida);
    }

    //Método de clique no botão
    @Override
    public void onClick(View v) {
        this.nextPage();
    }

    //Override de gesto
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gd.onTouchEvent(event);
        switch (event.getAction()){
            //Inicio a detecção do gesto
            case MotionEvent.ACTION_DOWN:
                y1 = event.getY();
                break;

            //Finalizando a detecção do gesto
            case MotionEvent.ACTION_UP:
                y2 = event.getY();

                float valorY = y1 - y2;

                if (Math.abs (valorY)> min){
                    this.nextPage();
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
}
