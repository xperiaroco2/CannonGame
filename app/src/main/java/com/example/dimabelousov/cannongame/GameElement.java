package com.example.dimabelousov.cannongame;
/*         CannonGame
 * Created by DimaBelousov on 24.08.2017.
 */

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class GameElement {
    protected CannonView cannonView;
    protected Rect shape;
    protected Paint paint = new Paint();
    private float velocityY;
    private int soundID;

    public GameElement(CannonView cannonView, int color, int soundID, int x,
                       int y, int width, int length, float velocityY){
        this.cannonView = cannonView;
        paint.setColor(color);
        shape = new Rect(x, y, width + x, length + y);
        this.soundID = soundID;
        this.velocityY = velocityY;
    }

    public void update(double interval){
        shape.offset(0, (int)(velocityY * interval));

        if(shape.top < 0 && velocityY < 0 ||
                shape.bottom > cannonView.getScreenHeight() && velocityY > 0)
            velocityY *= -1;
    }

    public void draw(Canvas canvas){
        canvas.drawRect(shape, paint);
    }

    public void playSound(){
        cannonView.playSound(soundID);
    }
}
