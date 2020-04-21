package org.academiadecodigo.rhashtafaris.battlechip.Pickables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;

public interface Pickables {

    boolean isVisible();

    Position getPosition();

    int randomXPosition();

    int randomYPosition();

    void goInvisible();

    void goVisible();
}
