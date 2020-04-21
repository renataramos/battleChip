package org.academiadecodigo.rhashtafaris.battlechip;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;

public enum Graphics {
    PLAYER1,
    PLAYER2,
    BULLET,
    PICKABLE;

    public String getGraphic(Directions direction) {
        switch (this) {
            case PLAYER1:
                return graphP1(direction);
            case PLAYER2:
                return graphP2(direction);
            case PICKABLE:
                return "resources/pickable_1.png";
            default:
                if (((int) (Math.random() * 2)) < 1) {
                    return graphBullet(direction, true); //1
                }
                return graphBullet(direction, false); //0
        }
    }

    private String graphP1(Directions directions) {
        switch (directions) {
            case UP:
                return "resources/chip1up.png";
            case DOWN:
                return "resources/chip1down.png";
            case LEFT:
                return "resources/chip1left.png";
            default:
                return "resources/chip1right.png";
        }
    }

    private String graphP2(Directions direction) {
        switch (direction) {
            case UP:
                return "resources/chip2up.png";
            case DOWN:
                return "resources/chip2down.png";
            case LEFT:
                return "resources/chip2left.png";
            default:
                return "resources/chip2right.png";
        }
    }

    private String graphBullet(Directions direction, boolean bit) {
        switch (direction) {
            case UP:
            case DOWN:
                return (bit) ? "resources/bullet1UD.png" : "resources/bullet0UD.png";
            default:
                return (bit) ? "resources/bullet1LR.png" : "resources/bullet0LR.png";
        }
    }
}
