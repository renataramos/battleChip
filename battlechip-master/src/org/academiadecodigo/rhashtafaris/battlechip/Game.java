package org.academiadecodigo.rhashtafaris.battlechip;

import org.academiadecodigo.bootcamp.Sound;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.CollisionDetector;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Grid;
import org.academiadecodigo.rhashtafaris.battlechip.Movables.Tank;
import org.academiadecodigo.rhashtafaris.battlechip.Pickables.FreeMemory;
import org.academiadecodigo.rhashtafaris.battlechip.Pickables.Pickables;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private static final int DISTANCE = 20;
    private static final int DELAY = 20;

    private Tank player1;
    private Tank player2;

    private boolean pickAppear;
    private int pickableNumber;
    private Pickables currentPickable;
    private Sound pickableAppears;

    private boolean gameOut;
    private boolean gameFinish;

    private CollisionDetector collisionDetector;

    Game() {
        gameOut = false;
        gameFinish = false;
    }

    private void init() {

        Grid canvas = new Grid();

        this.collisionDetector = new CollisionDetector(this);

        this.pickableAppears = new Sound ("/resources/sfx/getPickable.wav");

        player1 = new Tank(350, 915, Directions.LEFT, Graphics.PLAYER1, "player1");
        player2 = new Tank(350, 305, Directions.RIGHT, Graphics.PLAYER2, "player2");

        this.currentPickable = new FreeMemory();
        this.currentPickable.goInvisible();
        this.pickAppear = false;
    }

    void start() {

        init();

        try {
            while (!gameOver()) {
                Thread.sleep(DELAY);

                throwPickable();
                collisionDetector.pickableCollisionCheck(player1, player2, this.currentPickable);
                refreshBullets();
                refreshTanks();
                collisionDetector.collisionCheck(player1, player2);
            }

            if (player2.isDestroyed()) {
                Picture gameOver = new Picture(344, 286, "resources/stackP2.png");
                gameOver.draw();
            }

            if (player1.isDestroyed() || !player2.isDestroyed()) {
                Picture gameOver = new Picture(344, 286, "resources/stackP1.png");
                gameOver.draw();
            }

            gameFinish = true;

            while (!gameOut) {
                Thread.sleep(200);
            }

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    private boolean gameOver() {
        return (player1.isDestroyed() || player2.isDestroyed());
    }

    private void refreshBullets() {
        player1.bulletRefresh(DISTANCE);
        player2.bulletRefresh(DISTANCE);
    }

    private void refreshTanks() {
        player1.movePosition(DISTANCE);
        collisionDetector.tankCollisionCheck(player1, player2);
        player2.movePosition(DISTANCE);
        collisionDetector.collisionCheck(player2, player1);
    }

    private void setPickAppear() {
        if (((player1.getMemory() > 150 || player2.getMemory() > 150) && pickableNumber == 0)) {

            this.pickAppear = true;
            this.pickableAppears.play(true);
            return;
        }
        this.pickAppear = false;
    }

    private void throwPickable() {
        setPickAppear();

        if (this.pickAppear) {
            this.pickableAppears.play(true);
            this.pickAppear = false;
            pickableNumber++;

            this.currentPickable = new FreeMemory();
            this.currentPickable.goVisible();
        }
    }

    Tank getPlayer1() {
        return this.player1;
    }

    Tank getPlayer2() {
        return this.player2;
    }

    void gameOutToTrue(){
        this.gameOut = true;
    }

    boolean isGameFinish(){
        return gameFinish;
    }

}
