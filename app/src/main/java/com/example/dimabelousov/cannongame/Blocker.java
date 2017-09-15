package com.example.dimabelousov.cannongame;
/*         CannonGame
 * Created by DimaBelousov on 24.08.2017.
 */

public class Blocker extends GameElement {
    private int missPenalty;

    public Blocker(CannonView cannonView, int color, int missPenalty, int x, int y, int width, int length, float velocityY) {
        super(cannonView, color, CannonView.BLOCKER_SOUND_ID, x, y, width, length, velocityY);

        this.missPenalty = missPenalty;
    }

    public int getMissPenalty(){
        return missPenalty;
    }
}
