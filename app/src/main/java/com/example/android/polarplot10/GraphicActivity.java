package com.example.android.polarplot10;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class GraphicActivity extends AppCompatActivity {

    double i1=100,i2=0,i3=4,i4=0,i5=0,i6=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic);

        RelativeLayout plotgraph =(RelativeLayout)findViewById(R.id.id_graphic);
        ploteo plot1 = new ploteo(this);
        plotgraph.addView(plot1);


        Intent i=getIntent();
        i1=i.getExtras().getDouble("a");
        i2=i.getExtras().getDouble("b");
        i3=i.getExtras().getDouble("c");
        i4=i.getExtras().getDouble("d");
        i5=i.getExtras().getDouble("e");
        i6=i.getExtras().getDouble("f");
        //TextView tv= (TextView)findViewById(R.id.id__txt_graphic);
        //tv.setText(Integer.toString(i1));

    }


    //Canvas cv;

    class ploteo extends View{

        //List<Paint> paints = new ArrayList<Paint>();
        //List<Path> paths = new ArrayList<Path>();
        Path path;

        Context ct;
        Canvas cv;
        Paint brocha;
        private Handler handler;
        float poscX,poscY;
        double j=0 , t=0;
        float r,xp,yp;
        int i=0;



        public ploteo(Context context) {
            super(context);
            ct= context;
            brocha = new Paint();
            brocha.setARGB(255, 255, 0, 0);
            brocha.setStrokeWidth(0);
            brocha.setStyle(Paint.Style.FILL);
            //handler = new Handler();

        }

       /* private Runnable runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };*/

        @Override
        protected void onDraw(final Canvas cv){
            path = new Path();
            poscY=cv.getHeight()/2;
            poscX=cv.getWidth()/2;

            //path.addCircle(xp, yp, 5, Path.Direction.CW);

            //r=(float)(i1*Math.cos(i3*t+i4)+i2*Math.sin(i5*t+i6));

            //xp=(float)(poscX+r*Math.cos(t));
            //yp=(float)(poscY-r*Math.sin(t));

            for (t=0; t<=2*Math.PI;t=t+0.01){

                r=(float)(i1*Math.cos(i3*t+i4)+i2*Math.sin(i5*t+i6));
                xp=(float)(poscX+r*Math.cos(t));
                yp=(float)(poscY-r*Math.sin(t));

                if(r>=0){
                    path.addCircle(xp, yp, 2, Path.Direction.CW);
                    cv.drawPath(path,brocha);
                }
                if(r<0){
                    r=-r;
                    t=t+Math.PI;
                    xp=(float)(poscX+r*Math.cos(t));
                    yp=(float)(poscY-r*Math.sin(t));
                    path.addCircle(xp, yp, 2, Path.Direction.CW);
                    cv.drawPath(path,brocha);
                    t=t-Math.PI;
                    r=-r;
                }

            }

            //path.addCircle(poscX, poscY, 5, Path.Direction.CW);
            //cv.drawPath(path, brocha);
            //cv.drawCircle(poscX,poscY,5, brocha);
            //ciclo(cv);
            //path.moveTo(xp, yp);
            //paths.add(path);
            //paints.add(brocha);


            /*path.lineTo((float)(xp-j),(float)(yp-2*j));
            j= j+0.1;
            paths.add(path);
            paints.add(brocha);
            i=0;
            for(Path trazo:paths){
            cv.drawPath(trazo,paints.get(i++));}*/

            //handler.postDelayed(runnable, 10);//milisegindos

        }
        /*
        public void ciclo(Canvas cv) {

            path.addCircle(xp, yp, 5, Path.Direction.CW);
            //cv.drawCircle(xp,yp,5, brocha);
            cv.drawPath(path,brocha);
            j= j+0.1;
            xp=(float)(poscX+j);
            yp=(float)(poscY+2*j);

            //handler.postDelayed(runnable, 10);
        }*/


    }

}
