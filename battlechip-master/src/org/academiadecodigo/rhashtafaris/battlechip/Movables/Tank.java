package org.academiadecodigo.rhashtafaris.battlechip.Movables;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.rhashtafaris.battlechip.Graphics;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Grid;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;

public class Tank implements Movable {
    private static final int MAX_AMMO = 10;
    private static final int COLLIDE_DISTANCE = 15;
    private static final int COLLIDE_DAMAGE = 3;
    private static final int MAX_MEMORY = 300;

    private int memory;
    private Memory memoryGauge;

    private Bullet[] bulletArray;
    private int bulletTimmer;

    private Position position;
    private Directions currentDirection;

    private boolean destroyed;
    private Sound collide;

    public Tank(
            int posInitY,
            int posInitX,
            Directions direction, Graphics graphic, String playerID) {

        position = new Position(posInitX, posInitY, direction, graphic);

        this.destroyed = false;
        this.currentDirection = Directions.STILL;

        this.bulletArray = new Bullet[MAX_AMMO];
        populateBulletArray();

        this.memory = 0;
        this.bulletTimmer = 0;

        this.memoryGauge = new Memory(playerID);

        this.collide = new Sound("/resources/sfx/colide_1.wav");
    }

    public Bullet[] getBulletArray() {
        return bulletArray;
    }

    public int getMemory() {
        return this.memory;
    }

    public void setMemory() {
        this.memory = MAX_MEMORY;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    private void populateBulletArray() {
        for (int i = 0; i < this.bulletArray.length; i++) {
            this.bulletArray[i] = new Bullet(Grid.BORDER, Grid.BORDER, Directions.STILL);
        }
    }

    public void shoot() {
        for (int i = 0; i < bulletArray.length; i++) {
            if (bulletArray[i].isVisible()) {
                continue;
            }
            if (bulletTimmer != 0) {
                return;
            }
            bulletTimmer = 7;
            bulletArray[i].resetPosition(this.position.getxWidth() + 20, this.position.getyHeight() + 20, this.position.getDirection());
            return;
        }
    }

    //updating visual representation of bullets;
    public void bulletRefresh(int distance) {
        if (bulletTimmer != 0) {
            bulletTimmer--;
        }
        for (int i = 0; i < this.getBulletArray().length; i++) {
            if (this.getBulletArray()[i] == null) {
                continue;
            }
            if (this.bulletArray[i].getPosition().hittingWall()) {
                this.bulletArray[i].getPosition().hide();
                this.bulletArray[i].goInvisible();
            }
            this.bulletArray[i].movePosition(distance);
        }
    }

    public void memoryRefresh() {
        this.memoryGauge.resetMemoryGauge();
        this.memory = 0;
    }

    public void beHit(int damage) {
        this.memory += damage;
        this.memoryGauge.fillMemory(damage);

        if (this.memory >= MAX_MEMORY) {
            destroyed = true;
            this.memory = MAX_MEMORY;
        }
    }

    @Override
    public void changeDirection(Directions direction) {
        this.currentDirection = direction;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void movePosition(int distance) {
        this.position.movePosition(distance, currentDirection);
        this.currentDirection = Directions.STILL;
        this.position.convertPosition();
    }

    public void collideTank(Tank tank) {
        tank.position.movePosition(COLLIDE_DISTANCE, this.position.getDirection());
        this.position.movePosition(COLLIDE_DISTANCE, this.position.getDirection().getOppositeDirection());
        this.collide.play(true);
        this.beHit(COLLIDE_DAMAGE);
        tank.beHit(COLLIDE_DAMAGE);
    }
}

