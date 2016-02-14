package com.example.android.polarplot10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity implements Container2Fragment.Comunicador, Container3Fragment.Comunicador2,
        Container4Fragment.Comunicador3{

    FrameLayout frg_1;
    FrameLayout frg_2;
    FrameLayout frg_3;
    FrameLayout frg_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor1,new Container1Fragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor2,new Container2Fragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor3,new Container3Fragment()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor4,new Container4Fragment()).commit();


        frg_1 = (FrameLayout)findViewById(R.id.contenedor1);//visible
        frg_2 = (FrameLayout)findViewById(R.id.contenedor2);//visible

        frg_3 = (FrameLayout)findViewById(R.id.contenedor3);
        frg_3.setVisibility(frg_3.INVISIBLE);
        frg_4 = (FrameLayout)findViewById(R.id.contenedor4);
        frg_4.setVisibility(frg_4.INVISIBLE);




    }
    double a,b,c,d,e,f;

    @Override
    public void enviar(int nr) {
        //frgrecibir1 = (Container1Fragment)getSupportFragmentManager().findFragmentById(R.id.contenedor2);
        //frgrecibir1.recibir1(nr);
        if(nr==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, new Container3Fragment()).commit();//abre el container3
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor2, new Container4Fragment()).commit();//abre el container4

        }

    }

    @Override
    public void enviar2(double ea,double eb,double ec, double ed, double ee,double ef) {// viene de container3fragment
        //getSupportFragmentManager().beginTransaction().add(R.id.contenedor5,new Container5Fragment()).commit();

        //frg_recibir2=(Container5Fragment)getSupportFragmentManager().findFragmentById(R.id.contenedor5);

          // frg_recibir2.recibir2(sn);
           //getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, new Container5Fragment()).commit();

         a=ea;b=eb;c=ec;d=ed;e=ee;f=ef;//se almacena aqui //se obtiene del container 3!!!!!!!!!!!

    }

    @Override
    public void enviar3(int nr2) { //viene del container4!!!!!!!!!!
        if(nr2==1){ //se recibe del container4fragment
            Intent intent= new Intent(this,GraphicActivity.class);
            intent.putExtra("a",a);
            intent.putExtra("b",b);
            intent.putExtra("c",c);
            intent.putExtra("d",d);
            intent.putExtra("e",e);
            intent.putExtra("f",f);
            startActivity(intent);//se abre un nuevo activity donde se les ha pasado toda la data de arriba

            //Bundle datos=new Bundle();
            //frg_1.setVisibility(frg_1.INVISIBLE);
            //frg_5.setVisibility(frg_5.VISIBLE);
            //getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, new Container5Fragment()).commit();
        }
        if (nr2==2){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, new Container1Fragment()).commit();//abre el container3
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor2, new Container2Fragment()).commit();
        }
    }
     /*
    @Override
    public void enviar3(String sn) {
        frg_recibir3.recibir3(sn);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, new Container5Fragment()).commit();


    }*/
}
