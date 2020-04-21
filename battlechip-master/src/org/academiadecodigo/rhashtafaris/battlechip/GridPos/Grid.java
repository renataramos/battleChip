package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Grid {

    public static final int BORDER = 10;
    private static Picture canvas;

    public Grid (){

        canvas = new Picture(0,0,"resources/canvas.png") ;
        canvas.draw();

        Picture canvasAddition = new Picture(0, canvas.getHeight(), "resources/score.png");
        canvasAddition.draw();
    }

    public static int getWidth(){
        return canvas.getWidth();
    }

    public static int getHeight(){
        return canvas.getHeight();
    }
}
