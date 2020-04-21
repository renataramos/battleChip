package org.academiadecodigo.rhashtafaris.battlechip.Movables;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Position;

public interface Movable {

    void changeDirection(Directions direction);

    Position getPosition();

    void movePosition (int distance);
}
