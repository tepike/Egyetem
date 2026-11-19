package hu.nye.progtech.engine;

import hu.nye.progtech.commands.MenuCommands;
import hu.nye.progtech.map.MapVO;

import java.util.Scanner;

public class Menu extends MapVO{
    public void menuLogin(){
        LocateSaveFolder locateSaveFolder= new LocateSaveFolder();
        locateSaveFolder.PrintSavedFiles();
        new MapVO();

        System.out.println("\t\tRush Hour Loading \uD83D\uDE97 \uD83C\uDD7F \n");
        MenuCommands menuCommands = new MenuCommands();
        menuCommands.availableCommands();
    }





}
