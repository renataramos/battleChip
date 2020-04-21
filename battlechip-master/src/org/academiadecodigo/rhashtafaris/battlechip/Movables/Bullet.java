package org.academiadecodigo.rhashtafaris.battlechip.Movables;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.rhashtafaris.battlechip.Graphics;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;

public class Bullet implements Movable {

    private static final int DAMAGE = 10;
    private Position position;
    private Directions currentDirection;
    private boolean visible;
    private Sound hit;
    private Sound shoot;

    Bullet(int xWidth, int yHeigth, Directions directions) {

        position = new Position(xWidth + 20, yHeigth + 20, directions, Graphics.BULLET);
        this.currentDirection = directions;
        this.visible = false;
        this.position.hide();
        this.hit = new Sound("/resources/sfx/hit.wav");
        this.shoot = new Sound("/resources/sfx/shoot_1.wav");
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void changeDirection(Directions direction) {

        this.currentDirection = direction;
    }

    void goInvisible() {
        this.visible = false;
        this.position.hide();
    }

    void resetPosition(int x, int y, Directions directions) {
        position.setPos(x, y);
        position.setGraphicDirection(directions);

        currentDirection = directions;
        visible = true;

        shoot.play(true);
    }

    @Override
    public void movePosition(int distance) {
        if (visible) {
            this.position.movePosition(distance, currentDirection);
            this.position.convertPosition();
        }
    }

    public void checkBulletHits (Tank tank){
        if (this.position.equals(tank.getPosition())) {
            this.goInvisible();
            hit.play(true);
            tank.beHit(DAMAGE);
        }
    }
}
