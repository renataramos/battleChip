package org.academiadecodigo.rhashtafaris.battlechip;

import org.academiadecodigo.rhashtafaris.battlechip.GridPos.Directions;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardController implements KeyboardHandler {

    private Game game;
    private Menu menu;

    void setGame(Game game){
        this.game = game;
    }

    void setMenu(Menu menu){
        this.menu = menu;
    }

    void keyboardInit() {

        Keyboard keyboard = new Keyboard(this);

        /**
         * Menu keys
         */
        //Start - 1
        KeyboardEvent key1Press = new KeyboardEvent();
        key1Press.setKey(KeyboardEvent.KEY_1);
        key1Press.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key1Press);

        //Instructions - 2
        KeyboardEvent key2Press = new KeyboardEvent();
        key2Press.setKey(KeyboardEvent.KEY_2);
        key2Press.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key2Press);

        //Back - B
        KeyboardEvent keyBPress = new KeyboardEvent();
        keyBPress.setKey(KeyboardEvent.KEY_B);
        keyBPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyBPress);

        //game out - 0
        KeyboardEvent key0Press = new KeyboardEvent();
        key0Press.setKey(KeyboardEvent.KEY_0);
        key0Press.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(key0Press);


        /**
         * Player one keys
         */
        //Right - right
        KeyboardEvent rightPressP1 = new KeyboardEvent();
        rightPressP1.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightPressP1);

        //Left - left
        KeyboardEvent leftPressP1 = new KeyboardEvent();
        leftPressP1.setKey(KeyboardEvent.KEY_LEFT);
        leftPressP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftPressP1);

        //Up - up
        KeyboardEvent upPressP1 = new KeyboardEvent();
        upPressP1.setKey(KeyboardEvent.KEY_UP);
        upPressP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upPressP1);

        //Down - down
        KeyboardEvent downPressP1 = new KeyboardEvent();
        downPressP1.setKey(KeyboardEvent.KEY_DOWN);
        downPressP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downPressP1);

        //Shoot - m
        KeyboardEvent shootP1 = new KeyboardEvent();
        shootP1.setKey(KeyboardEvent.KEY_M);
        shootP1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(shootP1);


        /**
         * Player two keys
         */
        //Right - d
        KeyboardEvent rightPressP2 = new KeyboardEvent();
        rightPressP2.setKey(KeyboardEvent.KEY_D);
        rightPressP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightPressP2);

        //Left - a
        KeyboardEvent leftPressP2 = new KeyboardEvent();
        leftPressP2.setKey(KeyboardEvent.KEY_A);
        leftPressP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftPressP2);

        //Up - w
        KeyboardEvent upPressP2 = new KeyboardEvent();
        upPressP2.setKey(KeyboardEvent.KEY_W);
        upPressP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upPressP2);

        //Down - s
        KeyboardEvent downPressP2 = new KeyboardEvent();
        downPressP2.setKey(KeyboardEvent.KEY_S);
        downPressP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(downPressP2);

        //Shoot - c
        KeyboardEvent shootP2 = new KeyboardEvent();
        shootP2.setKey(KeyboardEvent.KEY_C);
        shootP2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(shootP2);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                if (game != null) {
                    game.getPlayer1().changeDirection(Directions.UP);
                }
                break;

            case KeyboardEvent.KEY_W:
                if (game != null) {
                    game.getPlayer2().changeDirection(Directions.UP);
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if (game != null) {
                    game.getPlayer1().changeDirection(Directions.DOWN);
                }
                break;

            case KeyboardEvent.KEY_S:
                if (game != null) {
                    game.getPlayer2().changeDirection(Directions.DOWN);
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if (game != null) {
                    game.getPlayer1().changeDirection(Directions.LEFT);
                }
                break;

            case KeyboardEvent.KEY_A:
                if (game != null) {
                    game.getPlayer2().changeDirection(Directions.LEFT);
                }
                break;

            case KeyboardEvent.KEY_RIGHT:
                if (game != null) {
                    game.getPlayer1().changeDirection(Directions.RIGHT);
                }
                break;

            case KeyboardEvent.KEY_D:
                if (game != null) {
                    game.getPlayer2().changeDirection(Directions.RIGHT);
                }
                break;

            case KeyboardEvent.KEY_M:
                if (game != null) {
                    game.getPlayer1().shoot();
                }
                break;

            case KeyboardEvent.KEY_C:
                if (game != null) {
                    game.getPlayer2().shoot();
                }
                break;

            case KeyboardEvent.KEY_1:
                if (menu != null) {
                    menu.startGame();
                }
                break;

            case KeyboardEvent.KEY_2:
                if (menu != null) {
                    menu.instructionsTrue();
                }
                break;

            case KeyboardEvent.KEY_B:
                if (menu != null) {
                    menu.backMenu();
                }
                break;
            case KeyboardEvent.KEY_0:
                if (game != null && game.isGameFinish()) {
                    game.gameOutToTrue();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
