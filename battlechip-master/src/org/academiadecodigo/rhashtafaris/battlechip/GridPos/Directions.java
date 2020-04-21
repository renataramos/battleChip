package org.academiadecodigo.rhashtafaris.battlechip.GridPos;

public enum Directions {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    STILL;

    public Directions getOppositeDirection() {
        switch (this) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                return STILL;
        }
    }
}
