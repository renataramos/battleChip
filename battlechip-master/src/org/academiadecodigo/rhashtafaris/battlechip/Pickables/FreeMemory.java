package org.academiadecodigo.rhashtafaris.battlechip.Pickables;

import org.academiadecodigo.rhashtafaris.battlechip.Graphics;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Grid;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FreeMemory implements Pickables {

    private Position position;
    private Graphics graphicType;
    private static final int INITIAL_RANGE = 20;
    private static final int FINAL_RANGE = 70;
    private boolean visible;

    public FreeMemory() {

        int x = randomXPosition();
        int y = randomYPosition();

        this.graphicType = Graphics.PICKABLE;

        this.position = new Position(x, y, Directions.STILL, graphicType);

        Picture picture = new Picture(x, y, graphicType.getGraphic(Directions.STILL));

    }

    public boolean isVisible(){
        return this.visible;
    }

    @Override
    public void goInvisible() {
        this.visible = false;
        this.position.hide();
    }

    @Override
    public void goVisible() {
       this.visible = true;
       this.position.show(Directions.STILL);
    }

    @Override
    public int randomXPosition() {
        return (int) Math.floor(Math.random() * (Grid.getWidth() - FINAL_RANGE) + INITIAL_RANGE);
    }

    @Override
    public int randomYPosition() {
        return (int) Math.floor(Math.random() * (Grid.getHeight() - FINAL_RANGE) + INITIAL_RANGE);
    }

    @Override
    public Position getPosition() {
        return this.position;
    }
}
