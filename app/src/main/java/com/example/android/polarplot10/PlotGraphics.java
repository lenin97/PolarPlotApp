package com.example.android.polarplot10;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Lenin on 24/01/2016.
 */
public class PlotGraphics extends ImageView {

    Context ct;
    float posX,posY;
    float vX,vY;
    private Handler handler;

    public PlotGraphics(Context context, AttributeSet attrs ) {
        super(context,attrs);
        ct = context;
        posX = 50;
        posY = 50;
        vX = 6;
        vY = 2;
        handler = new Handler();
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    Paint paint;
    float xc,yc;

    @Override
    protected void onDraw(Canvas canvas){
        //Bitmap bmp = BitmapFactory.decodeResource(ct.getResources(),
          //      R.drawable.pelota);
        xc=canvas.getWidth()/2;
        yc=canvas.getHeight()/2;

        handler.postDelayed(runnable,10);//milisegundos
    }

}
