package com.example.dimabelousov.cannongame;
/*         CannonGame
 * Created by DimaBelousov on 24.08.2017.
 */

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Cannon {
    private int baseRadius;
    private int barrelLength;
    private Point barrelEnd = new Point();
    private double barrelAngle;
    private Cannonball cannonball;
    private Paint paint = new Paint();
    private CannonView cannonView;

    public Cannon(CannonView cannonView, int baseRadius, int barrelLength, int barrelWidth){
        this.cannonView = cannonView;
        this.baseRadius = baseRadius;
        this.barrelLength = barrelLength;
        paint.setStrokeWidth(barrelWidth);
        paint.setColor(Color.BLACK);
        align(Math.PI / 2);
    }

    public void align(double barrelAngle) {
        this.barrelAngle = barrelAngle;
        barrelEnd.x = (int) (barrelLength * Math.sin(barrelAngle));
        barrelEnd.y = (int) (-barrelLength * Math.cos(barrelAngle)) +
                        cannonView.getScreenHeight() / 2;
    }

    public void fireCannonball(){
        int velocityX = (int) (CannonView.CANNONBALL_SPEED_PERCENT *
            cannonView.getScreenWidth() * Math.sin(barrelAngle));

        int velocityY = (int) (CannonView.CANNONBALL_SPEED_PERCENT *
            cannonView.getScreenWidth() * -Math.cos(barrelAngle));

        int radius = (int) (CannonView.CANNONBALL_RADIUS_PERCENT *
            cannonView.getScreenHeight());

        cannonball = new Cannonball(cannonView, Color.BLACK,
                CannonView.CANNON_SOUND_ID, -radius, cannonView.getScreenHeight() / 2 - radius,
                radius, velocityX, velocityY);

        cannonball.playSound();
    }

    public void draw(Canvas canvas){
        canvas.drawLine(0, cannonView.getScreenHeight() / 2,
                barrelEnd.x, barrelEnd.y, paint);

        canvas.drawCircle(0, (int) cannonView.getScreenHeight() / 2,
                baseRadius, paint);
    }

    public Cannonball getCannonball(){
        return cannonball;
    }

    public void removeCannonball(){
        cannonball = null;
    }
}
