package com.example.dimabelousov.cannongame;
/*         CannonGame
 * Created by DimaBelousov on 24.08.2017.
 */

public class Target extends GameElement{
    private int hitReward;

    public Target(CannonView cannonView, int color, int hitReward, int x, int y, int width, int length, float velocityY) {
        super(cannonView, color, CannonView.TARGET_SOUND_ID, x, y, width, length, velocityY);

        this.hitReward = hitReward;
    }

    public int getHitReward() {
        return hitReward;
    }
}
