package hu.nye.progtech;



import hu.nye.progtech.engine.*;
import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.Cars;
import hu.nye.progtech.model.GameObjects;
import hu.nye.progtech.model.ObjectList;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {



/*
        GenerateMap GenerateMap = new GenerateMap();
        GenerateMap.StartGeneration("test");
*/




                                                                    //Akadályok beolvasása és tárolása a következő lépés
                                                //Objektumok keresése, találta vissza adása, majd módosítása, irány eltolástól függően a tengely pozíció elejét vagy végét vesszük alapul.
        new Menu().menuLogin();
         //defaultMap.relocateObject();


/*
        System.out.println("KOcsi letrehoz kiir stb 1");
        Cars car = new Cars(2,4,2);
        ObjectList.addObject(car);
        GameObjects found = ObjectList.findObjectAt(3,3);
        System.out.println(found);

        System.out.println("KOcsi letrehoz kiir stb 2");
        car = new Cars(0,5,3);
        ObjectList.addObject(car);
        found = ObjectList.findObjectAt(1,5);
        System.out.println(found);


        if(ObjectList.isOccupied(3,3)) {
            System.out.println("A jármű elfoglalja ezt a mezőt: 3 3");
        }

        if(car.containsPosition(2,5)) {
            System.out.println("A jármű elfoglalja ezt a mezőt: 2 5\n Uj ki iars:");
        }


        System.out.println(ObjectList.findObjectAt(2,5)); // Eredmeny: 0,5  Ha át akarom rakni a 5,5-re a pontot akkor ugye 2,5 -> 5,5 legyen az x+3 eltolás tehát Az eredmény index 0+3,5 a fejpont
*/                                                      //A Cars-ban lévő toString miatt printeli így az adatot






    }
}