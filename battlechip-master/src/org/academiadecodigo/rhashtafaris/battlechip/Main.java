package org.academiadecodigo.rhashtafaris.battlechip;

public class Main {
    public static void main(String[] args) {

        KeyboardController keyboard = new KeyboardController();

        Menu menu;
        Game game;

        keyboard.keyboardInit();

        while (true) {

            menu = new Menu();
            keyboard.setMenu(menu);
            menu.createMenu();
            menu = null;

            game = new Game();
            keyboard.setGame(game);
            game.start();
            game = null;
        }
    }
}
