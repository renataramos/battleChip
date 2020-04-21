package org.academiadecodigo.rhashtafaris.battlechip.Movables;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Memory {

    private static final int HEIGHT = 50;
    private static final double VISUAL_CONVERSION = 0.31;

    private Rectangle rectangle;
    private String playerID;
    private int currentWidth;

    public Memory(String playerID) {
        this.playerID = playerID;
        this.currentWidth = 0;

        if (playerID.equals("player1")) {
            this.rectangle = new Rectangle(1230, 823, 0, HEIGHT);
            this.rectangle.setColor(Color.RED);
            this.rectangle.fill();
            return;
        }
        this.rectangle = new Rectangle(61, 821, 0, HEIGHT);
        this.rectangle.setColor(Color.RED);
        this.rectangle.fill();
    }

    void fillMemory(int growFactor) {
        this.rectangle.grow(growFactor*VISUAL_CONVERSION, 0);

        if (playerID.equals("player2")) {
            this.rectangle.translate(growFactor*VISUAL_CONVERSION, 0);
            currentWidth += growFactor*VISUAL_CONVERSION;
            return;
        }
        this.rectangle.translate(-growFactor*VISUAL_CONVERSION, 0);
        currentWidth += growFactor*VISUAL_CONVERSION;
    }

    void resetMemoryGauge(){
        if (playerID.equals("player2")){
            this.rectangle.translate(-currentWidth, 0);
            this.rectangle.grow(-currentWidth, 0);
            currentWidth = 0;
            return;
        }
        this.rectangle.translate(currentWidth, 0);
        this.rectangle.grow(-currentWidth, 0);
        currentWidth = 0;
    }
}
