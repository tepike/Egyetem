package hu.nye.progtech.engine;

import hu.nye.progtech.commands.MenuCommand;
import hu.nye.progtech.map.MapVO;

public class Menu extends MapVO{
    public void menuLogin(){
        LocateSaveFolder locateSaveFolder= new LocateSaveFolder();
        locateSaveFolder.PrintSavedFiles();
        new MapVO();

        System.out.println("\t\tRush Hour Loading \uD83D\uDE97 \uD83C\uDD7F \n");
        MenuCommand menuCommands = new MenuCommand();
        menuCommands.availableCommands();
    }





}
