package hu.nye.progtech.engine;

import hu.nye.progtech.commands.MenuCommand;
import hu.nye.progtech.map.MapVO;

public class Menu {
    public void menuLogin() {
        Game game = new Game();
        LocateSaveFolder locateSaveFolder = new LocateSaveFolder();

        System.out.println("\t\tRush Hour Loading \uD83D\uDE97 \uD83C\uDD7F \n");
        game.load();
        game.init();
        game.draw();

    }


}
