package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

import org.academiadecodigo.rhashtafaris.battlechip.Graphics;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {

    private int xWidth;
    private int yHeight;
    private Graphics graphicType;
    private Picture image;
    private Directions graphicDirection;

    public Position(int x, int y, Directions initialDirection, Graphics graphicType) {
        this.xWidth = x;
        this.yHeight = y;
        this.graphicType = graphicType;
        this.graphicDirection = initialDirection;
        this.image = new Picture(xWidth, yHeight, this.graphicType.getGraphic(this.graphicDirection));
        this.image.draw();
    }

    public void show(Directions direction) {
        image.load(graphicType.getGraphic(direction));
        image.draw();
    }

    public void hide() {
        this.image.delete();
    }

    public int getxWidth() {
        return xWidth;
    }

    public int getyHeight() {
        return yHeight;
    }

    public Directions getDirection() {
        return graphicDirection;
    }

    public void setGraphicDirection(Directions direction) {
        this.graphicDirection = direction;
    }

    public void setPos(int x, int y) {
        this.xWidth = x;
        this.yHeight = y;
    }

    /**
     * visual position
     */
    public void convertPosition() {
        int transX = xWidth - image.getX();
        int transY = yHeight - image.getY();

        show(this.graphicDirection);
        image.translate(transX, transY);
    }

    /**
     * logical position
     */
    public void movePosition(int distance, Directions currentDirection) {
        switch (currentDirection) {
            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
            default:
                return;
        }
    }

    private void moveUp(int distance) {
        this.graphicDirection = Directions.UP;

        if (yHeight - distance < Grid.BORDER) {
            setPos(getxWidth(), Grid.BORDER);
            return;
        }
        setMove(0, -distance);
    }

    private void moveDown(int distance) {
        this.graphicDirection = Directions.DOWN;

        if (yHeight + distance >= Grid.getHeight() - Grid.BORDER - this.image.getHeight()) {
            setPos(getxWidth(), Grid.getHeight() - Grid.BORDER - this.image.getHeight());
            return;
        }
        setMove(0, distance);
    }

    private void moveLeft(int distance) {
        this.graphicDirection = Directions.LEFT;

        if (xWidth - distance < Grid.BORDER) {
            setPos(Grid.BORDER, getyHeight());
            return;
        }
        setMove(-distance, 0);
    }

    private void moveRight(int distance) {
        this.graphicDirection = Directions.RIGHT;

        if (xWidth + distance >= Grid.getWidth() - Grid.BORDER - this.image.getWidth()) {
            setPos(Grid.getWidth() - Grid.BORDER - this.image.getWidth(), getyHeight());
            return;
        }
        setMove(distance, 0);
    }

    private void setMove(int distanceX, int distanceY) {
        this.xWidth += distanceX;
        this.yHeight += distanceY;
    }

    public boolean hittingWall() {
        return (this.getxWidth() == Grid.getWidth() - Grid.BORDER - this.image.getWidth() ||
                this.getxWidth() == Grid.BORDER ||
                this.getyHeight() == Grid.getHeight() - Grid.BORDER - this.image.getHeight() ||
                this.getyHeight() == Grid.BORDER);
    }

    public boolean equals(Position movable) {
        return (checkVerticeUL(movable) ||
                checkVerticeUR(movable) ||
                checkVerticeDL(movable) ||
                checkVerticeDR(movable));
    }

    private boolean checkVerticeUL(Position movable){
        return (this.image.getX() + this.image.getWidth() >= movable.image.getX() &&
                this.image.getX() + this.image.getWidth() <= movable.image.getX() + movable.image.getWidth() &&
                this.image.getY() + this.image.getHeight() >= movable.image.getY() &&
                this.image.getY() + this.image.getHeight() <= movable.image.getY() + movable.image.getHeight());
    }

    private boolean checkVerticeUR (Position movable){
        return (this.image.getX() >= movable.image.getX() &&
                this.image.getX() <= movable.image.getX() + movable.image.getWidth() &&
                this.image.getY() + this.image.getHeight() >= movable.image.getY() &&
                this.image.getY() + this.image.getHeight() <= movable.image.getY() + movable.image.getHeight());
    }

    private boolean checkVerticeDL (Position movable) {
        return (this.image.getX() + this.image.getWidth() >= movable.image.getX() &&
                this.image.getX() + this.image.getWidth() <= movable.image.getX() + movable.image.getWidth() &&
                this.image.getY() >= movable.image.getY() &&
                this.image.getY() <= movable.image.getY() + movable.image.getHeight());
    }

    private boolean checkVerticeDR (Position movable) {
        return (this.image.getX() >= movable.image.getX() &&
                this.image.getX() <= movable.image.getX() + movable.image.getWidth() &&
                this.image.getY() >= movable.image.getY() &&
                this.image.getY() <= movable.image.getY() + movable.image.getWidth());
    }
}




